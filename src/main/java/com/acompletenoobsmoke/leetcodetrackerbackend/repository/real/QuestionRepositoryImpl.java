//package com.acompletenoobsmoke.leetcodetrackerbackend.repository.real;
//
//import com.acompletenoobsmoke.leetcodetrackerbackend.dao.QuestionDAO;
//import com.acompletenoobsmoke.leetcodetrackerbackend.model.DIFFICULTY;
//import com.acompletenoobsmoke.leetcodetrackerbackend.model.Question;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//
//public class QuestionRepositoryImpl implements QuestionDAO {
//
//    private final QuestionRepository questionRepository;
//
//    public QuestionRepositoryImpl(QuestionRepository questionRepository) {
//        this.questionRepository = questionRepository;
//    }
//
//
//    public Question saveQuestion(Question question) {
//        return null;
//    }
//
//     @Override
//    public List<Question> getAllQuestions() {
//        return questionRepository.getAllQuestions().orElseThrow(() -> new RuntimeException("Questions not found"));
//    }
//
//    @Override
//    public Question getQuestionById(Integer id) {
//        return questionRepository.getQuestionById(id).orElseThrow(() -> new RuntimeException("Question not found"));
//    }
//
//    @Override
//    public Question getQuestionByName(String name) {
//        return questionRepository.getQuestionByName(name)
//                .orElseThrow(() -> new RuntimeException("Question with name " + name + " not found"));
//    }
//
//    @Override
//    public List<Question> getQuestionsByDifficulty(DIFFICULTY difficulty) {
//        return questionRepository.getQuestionsByDifficulty(difficulty)
//                .orElseThrow(() -> new RuntimeException("Question with Difficulty " + difficulty + " not found"));
//    }
//
//    @Override
//    public List<Question> getAllQuestionsByUserId(Integer userId) {
//        return questionRepository.getAllQuestionsByUserId(userId)
//                .orElseThrow(() -> new RuntimeException("Question with User " + userId + " not found"));
//    }
//
//    @Override
//    public Question getQuestionByUserIdAndQuestionID(Integer userId, Integer questionId) {
//        return questionRepository.getQuestionByUserIdAndQuestionID(userId, questionId)
//                .orElseThrow(() -> new RuntimeException("Question with User " + userId + " and Question " + questionId + " not found"));
//    }
//
//    @Override
//    public Question getQuestionByUserIdAndName(Integer userId, String name) {
//        return questionRepository.getQuestionByUserIdAndName(userId, name)
//                .orElseThrow(() -> new RuntimeException("Question with User " + userId + " and Name " + name + " not found"));
//    }
//
//    @Override
//    public List<Question> getAllQuestionsByUserIdAndDifficulty(Integer userId, DIFFICULTY difficulty) {
//        return questionRepository.getAllQuestionsByUserIdAndDifficulty(userId, difficulty)
//                .orElseThrow(() -> new RuntimeException("Question with Difficulty " + difficulty + " not found"));
//    }
//}
