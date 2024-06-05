package com.javarush.vrubleuski.quest.service;

import com.javarush.vrubleuski.quest.entity.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class QuestTest {
    @Spy
    Quest quest;

    @BeforeEach
    public void init() throws IOException {
        Properties prop = new Properties();
        FileReader reader = new FileReader("src/main/resources/context-quest.properties", StandardCharsets.UTF_8);
        prop.load(reader);
        quest = new Quest(prop);
    }

    @Test
    void initialize() {
        Question quest1 = quest.getMainQuestion();
        String q1 = quest1.getQuestionText();
        Assertions.assertEquals(q1, "Ты потерял память.\nПринять вызов НЛО?");

        String answer11 = quest1.getAnswers().get(0).getAnswerText();
        String answer12 = quest1.getAnswers().get(1).getAnswerText();
        String endGame11 = quest1.getAnswers().get(0).getAnswerEndGameText();
        String endGame12 = quest1.getAnswers().get(1).getAnswerEndGameText();

        Assertions.assertEquals(answer11, "Принять вызов");
        Assertions.assertEquals(answer12, "Отклонить вызов");
        assertNull(endGame11);
        Assertions.assertEquals(endGame12, "Ты отклонил вызов. Поражение!");

        Question quest2 = quest1.getAnswers().get(0).nextQuestion();
        String q2 = quest2.getQuestionText();
        Assertions.assertEquals(q2, "Ты принял вызов.\nПоднимаешься на мостик к капитану?");

        String answer21 = quest2.getAnswers().get(0).getAnswerText();
        String answer22 = quest2.getAnswers().get(1).getAnswerText();
        String endGame21 = quest2.getAnswers().get(0).getAnswerEndGameText();
        String endGame22 = quest2.getAnswers().get(1).getAnswerEndGameText();

        Assertions.assertEquals(answer21, "Подняться на мостик");
        Assertions.assertEquals(answer22, "Отказаться подниматься на мостик");
        assertNull(endGame21);
        Assertions.assertEquals(endGame22, "Ты отказался подниматься на мостик. Поражение!");


        Question quest3 = quest2.getAnswers().get(0).nextQuestion();
        String q3 = quest3.getQuestionText();

        Assertions.assertEquals(q3, "Ты поднялся на мостик.\nТы кто?");

        String answer31 = quest3.getAnswers().get(0).getAnswerText();
        String answer32 = quest3.getAnswers().get(1).getAnswerText();
        String endGame31 = quest3.getAnswers().get(0).getAnswerEndGameText();
        String endGame32 = quest3.getAnswers().get(1).getAnswerEndGameText();

        Assertions.assertEquals(answer31, "Рассказать правду о себе");
        Assertions.assertEquals(answer32, "Солгать о себе");
        Assertions.assertEquals(endGame31, "Тебя вернули домой. Победа!");
        Assertions.assertEquals(endGame32, "Твою ложь разоблачили. Поражение!");
    }

}