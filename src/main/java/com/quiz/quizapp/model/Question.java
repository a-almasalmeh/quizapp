package com.quiz.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String OptionA;
    String OptionB;
    String OptionC;
    String OptionD;

    String correctAnswer;

    public long getI() {
        return id;
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

    public void setI(long id) {
        this.id = id;
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
