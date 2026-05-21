package com.quiz.quizapp.service;

import com.quiz.quizapp.model.Question;
import com.quiz.quizapp.model.QuestionWrapper;
import com.quiz.quizapp.model.Quiz;
import com.quiz.quizapp.repository.QuestionRepository;
import com.quiz.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class responsible for managing quizzes.
 * Handles the business logic for creating new quizzes retrieving existing ones.
 */
@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;

    /**
     * Creates a new quiz by fetching a specified number of random questions from a certain category.
     * @param title the title of the new quiz.
     * @param numQ the number of the questions the quiz should contain.
     * @param category the category from which the questions should be fetched.
     * @return A ResponseEntity containing a success message and HTTP status (CREATED) if successful,
     * or HTTP stats (BAD REQUEST) if an error accurse
     */
    public ResponseEntity<String> createQuiz (String title, Integer numQ, String category){

        try{
            List<Question> questions = questionRepository.getRandomQuestionByCategory(numQ, category);

            Quiz quiz = new Quiz();
            quiz.setQuizTitle(title);
            quiz.setQuestions(questions);

            quizRepository.save(quiz);

            return new ResponseEntity<>("created", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("Some thing went wrong "+ e.getMessage());
            return new ResponseEntity<>("Some thing went wrong",HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * Retrieves a quiz by its id and converts its questions into QuestionWrappers
     * to hide the correct answer from the user.
     * @param id the unique identifier of the quiz to retrieve.
     * @return A ResponseEntity containing a list of QuestionWrappers and HTTP status (OK),
     * or an empty list with HHTP status (NOT FOUND) id the quiz does not exist
     */
    public ResponseEntity<List<QuestionWrapper>> getQuizById(Integer id) {
        try{
            Quiz quiz = quizRepository.findById(id).orElseThrow();

            List<Question> questionsFromDB = quiz.getQuestions();
            List<QuestionWrapper> questionsForUser = new ArrayList<>();

            for (Question q : questionsFromDB){
                QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionDescription(), q.getOptionA(), q.getOptionB(), q.getOptionC(), q.getOptionD());

                questionsForUser.add(qw);
            }
            return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("some thing went wrong " + e.getMessage());
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }

    }
}
