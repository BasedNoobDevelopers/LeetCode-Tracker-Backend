package com.acompletenoobsmoke.leetcodetrackerbackend.dto;

import com.acompletenoobsmoke.leetcodetrackerbackend.model.Status;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.ValidationChoices;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserQuestionRequest {
    private String userName;
    private Integer questionNum;
    private Status status;
    private ValidationChoices optimized;
    private String notes;
    private ValidationChoices needReview;
}
