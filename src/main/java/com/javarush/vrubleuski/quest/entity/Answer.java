package com.javarush.vrubleuski.quest.entity;

public class Answer {
    private String answerText;
    private String answerEndGameText;
    private Question nextQuestion;

    public Answer(String answerText) {
        this.answerText = answerText;
    }

    public void setNextQuestion(Question nextQuestion) {
        this.nextQuestion = nextQuestion;
    }

    public String getAnswerText() {
        return answerText;
    }

    public String getAnswerEndGameText() {
        return answerEndGameText;
    }

    public void setAnswerEndGameText(String answerEndGameText) {
        this.answerEndGameText = answerEndGameText;
    }

    public Question nextQuestion(){
        return nextQuestion;
    }
}
