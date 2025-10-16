package com.acompletenoobsmoke.leetcodetrackerbackend.repository.real;

import com.acompletenoobsmoke.leetcodetrackerbackend.dao.QuestionDAO;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.DIFFICULTY;
import com.acompletenoobsmoke.leetcodetrackerbackend.model.Question;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {


    Optional<Question> findAllByFrontendQuestionId(Integer frontendQuestionId);
    Optional<Question>  findAllByTitle(String title);
    Optional<List<Question>>  findAllByDifficulty(DIFFICULTY difficulty);

//    Optional<List<Question>> findAllQuestionsByUserId(Integer userId);
//    Optional<Question>  findQuestionByUserIdAndQuestionID(Integer userId, Integer questionId);
//    Optional<Question>  findQuestionByUserIdAndName(Integer userId, String name);;
//    Optional<List<Question>>  findAllQuestionsByUserIdAndDifficulty(Integer userId, DIFFICULTY difficulty);

}
