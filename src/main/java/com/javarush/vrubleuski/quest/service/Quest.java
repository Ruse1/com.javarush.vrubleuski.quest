package com.javarush.vrubleuski.quest.service;

import com.javarush.vrubleuski.quest.entity.Answer;
import com.javarush.vrubleuski.quest.entity.Question;

import java.util.Properties;

public class Quest {
    private Question mainQuestion;
    private final Properties propFile;

    public Quest(Properties properties){
        this.propFile = properties;
        initialize();
    }

    public void initialize() {
        mainQuestion = new Question(1, propFile.getProperty("Question-1"));
        Answer answer1 = new Answer(propFile.getProperty("Answer-1.1"));
        Answer answer2 = new Answer(propFile.getProperty("Answer-1.2"));
        mainQuestion.addAnswer(answer1);
        mainQuestion.addAnswer(answer2);

        Question question2 = new Question(2, propFile.getProperty("Question-2"));
        answer1.setNextQuestion(question2);
        answer2.setAnswerEndGameText(propFile.getProperty("EndGame-1.2"));
        Answer answer3 = new Answer(propFile.getProperty("Answer-2.1"));
        Answer answer4 = new Answer(propFile.getProperty("Answer-2.2"));
        question2.addAnswer(answer3);
        question2.addAnswer(answer4);

        Question question3 = new Question(3, propFile.getProperty("Question-3"));
        answer3.setNextQuestion(question3);
        answer4.setAnswerEndGameText(propFile.getProperty("EndGame-2.2"));
        Answer answer5 = new Answer(propFile.getProperty("Answer-3.1"));
        Answer answer6 = new Answer(propFile.getProperty("Answer-3.2"));
        answer5.setAnswerEndGameText(propFile.getProperty("EndGame-3.1"));
        answer6.setAnswerEndGameText(propFile.getProperty("EndGame-3.2"));
        question3.addAnswer(answer5);
        question3.addAnswer(answer6);
    }

    public Question getMainQuestion() {
        return mainQuestion;
    }

}
