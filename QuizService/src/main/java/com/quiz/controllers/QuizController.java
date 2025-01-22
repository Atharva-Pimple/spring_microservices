package com.quiz.controllers;

import com.quiz.entities.Quiz;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;
    private QuestionClient questionClient;

    public QuizController(QuestionClient questionClient, QuizService quizService) {
        this.questionClient = questionClient;
        this.quizService = quizService;
    }

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        System.out.println(quiz.getTitle());
        return quizService.add(quiz);
    }

    @GetMapping
    public List<Quiz> quizGetAll(){
        List<Quiz> quizzes = quizService.getAll();
        List<Quiz> newQuizzes=quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());

        return newQuizzes;
    }

    @GetMapping("/{id}")
    public Quiz get(@PathVariable Long id){
        Quiz quiz=quizService.get(id);
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}
