package com.acompletenoobsmoke.leetcodetrackerbackend.service;

import com.acompletenoobsmoke.leetcodetrackerbackend.model.Question;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class QuestionService {

    private final WebClient webClient;
    private final String graphQLURL = "https://leetcode.com/graphql";

    public QuestionService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(graphQLURL).build();
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
}
