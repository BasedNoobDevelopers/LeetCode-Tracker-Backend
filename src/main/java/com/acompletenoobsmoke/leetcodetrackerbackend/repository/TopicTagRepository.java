package com.acompletenoobsmoke.leetcodetrackerbackend.repository;

import com.acompletenoobsmoke.leetcodetrackerbackend.model.TopicTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicTagRepository extends JpaRepository<TopicTag, Long> {
    Optional<TopicTag> findByName(String name);
}
