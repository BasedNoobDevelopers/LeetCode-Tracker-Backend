package com.acompletenoobsmoke.leetcodetrackerbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class TopicTag {
    @Id
    private String name;

}
