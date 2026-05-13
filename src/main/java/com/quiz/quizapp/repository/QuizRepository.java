package com.quiz.quizapp.repository;

import com.quiz.quizapp.model.Quiz;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
