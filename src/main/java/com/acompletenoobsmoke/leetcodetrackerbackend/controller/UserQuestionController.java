package com.acompletenoobsmoke.leetcodetrackerbackend.controller;


import com.acompletenoobsmoke.leetcodetrackerbackend.dto.UserQuestionRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-question")
public class UserQuestionController {

    @GetMapping("{userName}/{questionNum}")
    public void getUserQuestion(@PathVariable String userName,
                                @PathVariable Integer questionNum) {

    }

    @PostMapping("{userName}")
    public void postUserQuestion(@PathVariable String userName, @RequestBody UserQuestionRequest userQuestionRequest) {

    }

    @PutMapping("{userName}")
    public void editUserQuestion(@PathVariable String userName, @RequestBody UserQuestionRequest userQuestionRequest) {

    }

    @DeleteMapping("{userName}/{questionNum}")
    public void deleteUserQuestion(@PathVariable String userName,
                                   @PathVariable Integer questionNum) {

    }
}
