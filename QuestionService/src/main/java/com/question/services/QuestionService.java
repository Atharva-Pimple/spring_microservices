package com.question.services;

import com.question.entities.Question;

import java.util.List;

public interface QuestionService {
    Question add(Question question);
    List<Question> getAll();
    Question get(Long id);
    List<Question> getByQuiz(Long quizId);
}
