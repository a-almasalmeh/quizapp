package com.quiz.quizapp.service;

import com.quiz.quizapp.model.Question;
import com.quiz.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<List<Question>> getAllQuestions(){
        return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<Question>> getQuestionBCategory(String category){
        return new ResponseEntity<>(questionRepository.getQuestionByCategory(category), HttpStatus.OK);
    }


    public ResponseEntity<String> setQuestion(Question question) {
        questionRepository.save(question);
        return new ResponseEntity<>("saved successfully", HttpStatus.OK);
    }



    public ResponseEntity<String> deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
        return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
    }
}
