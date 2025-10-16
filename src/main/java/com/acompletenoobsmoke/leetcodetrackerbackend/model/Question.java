package com.acompletenoobsmoke.leetcodetrackerbackend.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    private String frontendQuestionId;
    private String title;
    private String difficulty;
    private List<TopicTag> topicTags;
}
