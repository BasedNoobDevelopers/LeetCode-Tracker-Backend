package com.acompletenoobsmoke.leetcodetrackerbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {

    @Id
    private Integer frontendQuestionId;
    private String title;
    private String difficulty;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "question_topic_tag",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_tag_id")
    )
    private List<TopicTag> topicTags;
}
