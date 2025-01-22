package com.quiz.services;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{

    private QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAll() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz get(Long id) {
        return quizRepository.findById(id).orElseThrow(()-> new RuntimeException("Quiz not found!"));
    }
}
