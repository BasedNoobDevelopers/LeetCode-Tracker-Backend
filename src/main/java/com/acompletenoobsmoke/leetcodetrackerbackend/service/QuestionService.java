package com.acompletenoobsmoke.leetcodetrackerbackend.service;

import com.acompletenoobsmoke.leetcodetrackerbackend.dao.QuestionDAO;
import com.acompletenoobsmoke.leetcodetrackerbackend.mapper.QuestionMapper;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.Question;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.TopicTag;
import com.acompletenoobsmoke.leetcodetrackerbackend.repository.TopicTagRepository;
import com.acompletenoobsmoke.leetcodetrackerbackend.repository.real.QuestionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class QuestionService {

    private final WebClient webClient;
    private final String graphQLURL = "https://leetcode.com/graphql";
    private final QuestionMapper questionMapper;
    private final QuestionRepository questionRepository;
    private final TopicTagRepository topicTagRepository;

    public QuestionService(WebClient.Builder webClientBuilder, QuestionMapper questionMapper,  QuestionRepository questionRepository, TopicTagRepository topicTagRepository) {
        this.webClient = webClientBuilder.baseUrl(graphQLURL).build();
        this.questionMapper = questionMapper;
        this.questionRepository = questionRepository;
        this.topicTagRepository = topicTagRepository;
    }

    public Map<String, Object> getProblemSetQuestion(String categorySlug, Integer skip, Integer limit, Map<String, Object> filters)  {
        String query = """
            query problemsetQuestionList($categorySlug: String, $limit: Int, $skip: Int, $filters: QuestionListFilterInput) {
                problemsetQuestionList: questionList(
                    categorySlug: $categorySlug,
                    limit: $limit,
                    skip: $skip,
                    filters: $filters
                ) {
                    total: totalNum
                    questions: data {
                        difficulty
                        frontendQuestionId: questionFrontendId
                        title
                        topicTags {
                            name
                        }
                    }
                }
            }
        """;

        Map<String, Object> variables = Map.of(
                "categorySlug", categorySlug,
                "limit", limit,
                "skip", skip,
                "filters", filters
        );

        Map<String, Object> request = Map.of(
                "query", query,
                "variables", variables
        );


        try {
            return webClient.post()
                    .uri(graphQLURL)
                    .header("Content-Type", "application/json")
                    .header("Referer", "https://leetcode.com")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                    .bodyValue(request)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .doOnNext(System.out::println)
                    .block();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Question addQuestion(Map<String, Object> request) {
        Question question = questionMapper.mapToQuestion(request);
        List<TopicTag> dedupedTags = question.getTopicTags().stream()
                .map(tag -> topicTagRepository.findByName(tag.getName())
                        .orElseGet(() -> topicTagRepository.save(new TopicTag(tag.getName()))))
                .toList();

        question.setTopicTags(dedupedTags);
        questionRepository.save(question);
        return question;
    }
}
