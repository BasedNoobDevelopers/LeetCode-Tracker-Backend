package com.acompletenoobsmoke.leetcodetrackerbackend.controller;

import com.acompletenoobsmoke.leetcodetrackerbackend.model.Question;
import com.acompletenoobsmoke.leetcodetrackerbackend.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionRestController {

    private final QuestionService questionService;

    public QuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public Page<Question> getAllQuestions(Pageable pageable) {
        return questionService.getAllQuestions(pageable);
    }

    @GetMapping("{id}")
    public Question getQuestionById(@PathVariable Integer id) {
        return questionService.getQuestionById(id);
    }



}
