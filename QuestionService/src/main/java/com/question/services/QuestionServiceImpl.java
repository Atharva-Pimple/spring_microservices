package com.question.services;

import com.question.entities.Question;
import com.question.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question get(Long id) {
        return questionRepository.findById(id).orElseThrow(()-> new RuntimeException("Question Not Found!"));
    }

    @Override
    public List<Question> getByQuiz(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
