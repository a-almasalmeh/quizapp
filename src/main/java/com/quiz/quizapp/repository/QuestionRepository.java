package com.quiz.quizapp.repository;

import com.quiz.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface QuestionRepository extends JpaRepository <Question, Integer> {

    @Query("SELECT q FROM Question q WHERE q.category = :category")
    List<Question> getQuestionByCategory (String category);

}
