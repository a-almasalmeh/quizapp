package com.quiz.quizapp.controller;

import com.quiz.quizapp.model.QuestionWrapper;
import com.quiz.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String title,@RequestParam Integer numQ,@RequestParam String category){
        return quizService.createQuiz(title, numQ, category);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
        return quizService.getQuizById(id);
    }
}
