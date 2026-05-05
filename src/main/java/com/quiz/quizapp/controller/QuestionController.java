package com.quiz.quizapp.controller;

import com.quiz.quizapp.model.Question;
import com.quiz.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping("allquestion")
    public ResponseEntity<List<Question>> showAllQuestions (){
        return questionService.getAllQuestions();
    }

    @RequestMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionBCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> setQuestion (@RequestBody Question question){
        return questionService.setQuestion(question);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteQuestion (@RequestParam Integer id){
        return questionService.deleteQuestion(id);
    }
}
