package com.javarush.vrubleuski.quest.entity;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private int id;
    private String questionText;
    private List<Answer> answers;

    public Question(int id, String questionText) {
        this.id = id;
        this.questionText = questionText;
        this.answers = new ArrayList<>();
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public int getId() {
        return id;
    }
}
