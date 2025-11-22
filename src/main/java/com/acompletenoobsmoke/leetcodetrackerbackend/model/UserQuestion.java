package com.acompletenoobsmoke.leetcodetrackerbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userID;
    private long questionID;
    private Status status;
    private ValidationChoices optimized;
    private String notes;
    private ValidationChoices needReview;
}
