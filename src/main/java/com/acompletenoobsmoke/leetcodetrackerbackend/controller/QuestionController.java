package com.acompletenoobsmoke.leetcodetrackerbackend.controller;

import com.acompletenoobsmoke.leetcodetrackerbackend.mapper.QuestionMapper;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.Question;
import com.acompletenoobsmoke.leetcodetrackerbackend.service.QuestionService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QuestionController {


    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @QueryMapping
    public Question getQuestionById(@Argument Integer id) {
        Map<String, Object> filters = new HashMap<>();

        for (int i = 1; i <= 3617; i++) {
            filters.put("searchKeywords", i);
            Map<String, Object> request = questionService.getProblemSetQuestion("", 0, 1, filters);
            questionService.addQuestion(request);
        }
        //Map<String, Object> request = questionService.getProblemSetQuestion("", 0, 1, filters);
        return null;
    }
}
