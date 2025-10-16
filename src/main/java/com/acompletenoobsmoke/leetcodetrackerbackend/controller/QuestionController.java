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
    private final QuestionMapper questionMapper;

    public QuestionController(QuestionService questionService,  QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }

    @QueryMapping
    public Question problemsetQuestionList(@Argument String categorySlug,
                                           @Argument Integer skip,
                                           @Argument Integer limit,
                                           @Argument Map<String, Object> filters) {
        return questionMapper.mapToQuestion(questionService.getProblemSetQuestion(categorySlug, skip, limit, filters));
    }

    @QueryMapping
    public Question getQuestionById(@Argument Integer id) {
        Map<String, Object> filters = new HashMap<>();
        filters.put("searchKeywords", id);
        return questionMapper.mapToQuestion(questionService.getProblemSetQuestion("", 0, 1, filters));
    }
}
