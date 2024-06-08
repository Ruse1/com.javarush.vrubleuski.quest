package com.javarush.vrubleuski.quest.controller;

import com.javarush.vrubleuski.quest.entity.Question;
import com.javarush.vrubleuski.quest.service.Quest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@WebServlet(name = "startServlet", value = "/start-servlet")
public class StartServlet extends HttpServlet {
    private Properties prop;

    @Override
    public void init() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("/context-quest.properties");
        try (InputStreamReader inputStreamReader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            prop = new Properties();
            prop.load(inputStreamReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Quest quest = new Quest(prop);
        Question mainQuestion = quest.getMainQuestion();
        HttpSession session = req.getSession(true);

        String name = req.getParameter("username");
        String idSession = session.getId();
        Integer count = 1;

        if (session.getAttribute("count") != null) {
            count = (Integer) session.getAttribute("count") + 1;
        }

        session.setAttribute("question", mainQuestion);
        session.setAttribute("username", name);
        session.setAttribute("count", count);
        session.setAttribute("idsession", idSession);

        resp.sendRedirect("/quest.jsp");
    }

}