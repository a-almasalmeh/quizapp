package com.quiz.quizapp.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;

import java.util.List;

/**
 * Represents quiz entity in the database.
 * Each quiz has a title and a collection of questions linked with a many-to-many relationship.
 */
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String quizTitle;
    @ManyToMany
    private List<Question> questions;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Integer getId() {
        return id;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
