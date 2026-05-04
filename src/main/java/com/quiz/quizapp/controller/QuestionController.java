package com.quiz.quizapp.controller;

import com.quiz.quizapp.model.Question;
import com.quiz.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @RequestMapping("allquestion")
    public List<Question> showAllQuestions (){
        return questionService.getAllQuestions();
    }

    @RequestMapping("category/{ctg}")
    public List<Question> getQuestionByCategory(@PathVariable("ctg") String category){
        return questionService.getQuestionBCategory(category);
    }

    @PostMapping("add")
    public String setQuestion (@RequestBody Question question){
        return questionService.setQuestion(question);
    }

    @DeleteMapping("delete")
    public String deleteQuestion (@RequestParam Integer id){
        return questionService.deleteQuestion(id);
    }
}
