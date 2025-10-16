package com.acompletenoobsmoke.leetcodetrackerbackend.mapper;


import com.acompletenoobsmoke.leetcodetrackerbackend.model.Question;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class QuestionMapper {

    private final ObjectMapper objectMapper;

    public QuestionMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Question mapToQuestion(Map<String, Object> response) {
        Map<String, Object> data = (Map<String, Object>) response.get("data");
        Map<String, Object> problemsetQuestionList = (Map<String, Object>) data.get("problemsetQuestionList");
        List<Object[]> questionList = (List<Object[]>) problemsetQuestionList.get("questions");
        Question question = objectMapper.convertValue(questionList.getFirst(), new TypeReference<Question>() {});
        System.out.println(question);
        return question;
    }
}
