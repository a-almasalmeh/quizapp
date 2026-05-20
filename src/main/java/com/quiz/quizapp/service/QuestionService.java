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
        try{
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("something went wrong" + e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionBCategory(String category){

        try {
            return new ResponseEntity<>(questionRepository.getQuestionByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Some thing went wrong" + e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> setQuestion(Question question) {
        try{
            questionRepository.save(question);
            return new ResponseEntity<>("saved successfully", HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println("Some thing went wrong" + e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



    public ResponseEntity<String> deleteQuestion(Integer id) {
        try{
            questionRepository.deleteById(id);
            return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Some thing went wrong" + e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> setQuestions(List<Question> questions) {
        for(Question q : questions){
            questionRepository.save(q);
        }
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
