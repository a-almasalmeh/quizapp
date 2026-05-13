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

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz (String title, Integer numQ, String category){

        List<Question> questions = questionRepository.getRandomQuestionByCategory(numQ, category);

        Quiz quiz = new Quiz();
        quiz.setQuizTitle(title);
        quiz.setQuestions(questions);

        quizRepository.save(quiz);

        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizById(Integer id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow();

        List<Question> questionsFromDB = quiz.getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for (Question q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionDescription(), q.getOptionA(), q.getOptionB(), q.getOptionC(), q.getOptionD());

            questionsForUser.add(qw);
        }
        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }
}
