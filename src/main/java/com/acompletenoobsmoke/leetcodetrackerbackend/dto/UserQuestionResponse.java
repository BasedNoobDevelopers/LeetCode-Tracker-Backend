package com.acompletenoobsmoke.leetcodetrackerbackend.dto;

import com.acompletenoobsmoke.leetcodetrackerbackend.model.Question;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.Status;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.ValidationChoices;

public class UserQuestionResponse {
    private Question question;
    private Status status;
    private ValidationChoices optimizedChoice;
    private String notes;
    private ValidationChoices needReview;
}
