package com.quiz.quizapp.controller;

import com.quiz.quizapp.model.Question;
import com.quiz.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller for managing questions.
 */
@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    /**
     * Retrieves a list of all questions available in the database.
     * @return A ResponseEntity containing a list of all questions and HTTP status.
     */
    @GetMapping("allquestion")
    public ResponseEntity<List<Question>> showAllQuestions (){
        return questionService.getAllQuestions();
    }

    /**
     * Retrieves a list of questions filtered by a specific category.
     * @param category The category to filter questions by
     * @return A ResponseEntity containing a list of matching questions and HTTP status.
     */
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }

    /**
     * Adds multiple questions to the database.
     * @param questions A list of question objects to be saved.
     * @return A ResponseEntity with a success message and HTTP status.
     */
    @PostMapping("addAll")
    public ResponseEntity<String> setQuestions(@RequestBody List<Question> questions){
        return questionService.setQuestions(questions);
    }

    /**
     * Adds a single question to the database.
     * @param question the question object to be saved.
     * @return A ResponseEntity with a success message and HTTP status.
     */
    @PostMapping("add")
    public ResponseEntity<String> setQuestion (@RequestBody Question question){
        return questionService.setQuestion(question);
    }

    /**
     * Deletes a specific question by its ID.
     * @param id The ID of the question to be deleted.
     * @return A ResponseEntity with a success message and HTTP status.
     */
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteQuestion (@RequestParam Integer id){
        return questionService.deleteQuestion(id);
    }
}
