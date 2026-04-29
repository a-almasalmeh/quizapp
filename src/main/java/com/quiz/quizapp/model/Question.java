package com.quiz.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Question {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;


    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    String questionDescription;
    String OptionA;
    String OptionB;
    String OptionC;
    String OptionD;
    String correctAnswer;
    String category;



    public String getCategory() {
        return category;
    }

    public Long getId() {
        return id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }




    public String getOptionA() {
        return OptionA;
    }

    public String getOptionB() {
        return OptionB;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getOptionD() {
        return OptionD;
    }

    public String getOptionC() {
        return OptionC;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setOptionA(String optionA) {
        OptionA = optionA;
    }

    public void setOptionB(String optionB) {
        OptionB = optionB;
    }

    public void setOptionC(String optionC) {
        OptionC = optionC;
    }

    public void setOptionD(String optionD) {
        OptionD = optionD;
    }
}
