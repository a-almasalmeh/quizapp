package com.quiz.quizapp.service;

import com.quiz.quizapp.model.Question;
import com.quiz.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class for managing quiz questions.
 */
@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    /**
     * Retrieves all available questions from the database.
     * @return A ResponseEntity containing a list of all questions and Http status (OK),
     * Http status (BAD_REQUEST) if an error occurs during retrieval.
     */
    public ResponseEntity<List<Question>> getAllQuestions(){
        try{
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("something went wrong" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * Retrieves all questions belonging to aspecific category.
     *
     * @param category
     * @return
     */
    public ResponseEntity<List<Question>> getQuestionByCategory(String category){

        try {
            return new ResponseEntity<>(questionRepository.getQuestionByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Some thing went wrong" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Adds a single new question to the database.
     * @param question The question object to be saved.
     * @return A ResponseEntity with success message and Http status (CREATED),
     * Http status (BAD_REQUEST) if the save operation fails.
     */
    public ResponseEntity<String> setQuestion(Question question) {
        try{
            questionRepository.save(question);
            return new ResponseEntity<>("saved successfully", HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println("Some thing went wrong" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    /**
     * Deletes a specific question from the database using its unique ID.
     * @param id The ID of the question to be deleted.
     * @return A ResponseEntity with success message and Http status (OK),
     * or Http status (BAD_REQUEST) if the deletion fails.
     */
    public ResponseEntity<String> deleteQuestion(Integer id) {
        try{
            questionRepository.deleteById(id);
            return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Some thing went wrong" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * A multiple question to the database.
     * @param questions A List of Question objects to be saved to the database.
     * @return A ResponseEntity with a success message and Http status (OK)
     */
    public ResponseEntity<String> setQuestions(List<Question> questions) {
        for(Question q : questions){
            questionRepository.save(q);
        }
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
