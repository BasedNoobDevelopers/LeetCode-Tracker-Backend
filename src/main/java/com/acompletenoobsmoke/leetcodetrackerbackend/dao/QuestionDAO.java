package com.acompletenoobsmoke.leetcodetrackerbackend.dao;

import com.acompletenoobsmoke.leetcodetrackerbackend.model.DIFFICULTY;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionDAO {

    Question saveQuestion(Question question);
    List<Question> getAllQuestions();
    Question getQuestionById(Integer id);
    Question getQuestionByName(String name);
    List<Question> getQuestionsByDifficulty(DIFFICULTY difficulty);

    List<Question> getAllQuestionsByUserId(Integer userId);
    Question getQuestionByUserIdAndQuestionID(Integer userId, Integer questionId);
    Question getQuestionByUserIdAndName(Integer userId, String name);
    List<Question> getAllQuestionsByUserIdAndDifficulty(Integer userId, DIFFICULTY difficulty);


}
