package com.quiz.quizapp.controller;

import com.quiz.quizapp.model.QuestionWrapper;
import com.quiz.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing quizzes
 */
@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    /**
     * Creates a new quiz based on the provided title, number of question and category.
     * @param title The title of the new quiz.
     * @param numQ The number of the questions the quiz should contain.
     * @param category The category from witch the questions should be fetched.
     * @return A ResponseEntity with success message and HTTP status.
     */
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(
            @RequestParam String title,
            @RequestParam(required = false, defaultValue = "5") Integer numQ,
            @RequestParam(required = false, defaultValue = "easy") String category){

        return quizService.createQuiz(title, numQ, category);
    }

    /**
     * Retrieves a specific quiz by its ID.
     * @param id The identifier of the quiz to retrieve.
     * @return A ResponseEntity containing a list of QuestionWrappers and HTTP status.
     */
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
        return quizService.getQuizById(id);
    }
}
