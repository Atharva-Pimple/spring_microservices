package com.question.controllers;

import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question create(@RequestBody Question question){
        return questionService.add(question);
    }

    @GetMapping
    public List<Question> getAll(){
        System.out.println(questionService.getAll());
        return questionService.getAll();
    }

    @GetMapping("/{queId}")
    public Question get(@PathVariable Long queId){
        return questionService.get(queId);
    }

    // QUestions for the req Quiz
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId){
        return questionService.getByQuiz(quizId);
    }
}
