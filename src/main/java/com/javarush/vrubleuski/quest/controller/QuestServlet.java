package com.javarush.vrubleuski.quest.controller;

import com.javarush.vrubleuski.quest.entity.Question;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "questServlet", value = "/quest-servlet")
public class QuestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        if (req.getParameter("negative") != null || req.getParameter("positive") != null) {
            HttpSession session = req.getSession();
            Question questionFromJsp = (Question) session.getAttribute("question");

            if (questionFromJsp.getAnswers().get(0).nextQuestion() != null) {
                Question nextQuestion = questionFromJsp.getAnswers().get(0).nextQuestion();
                session.setAttribute("question", nextQuestion);
            } else {
                String positive = req.getParameter("positive");
                if (positive != null && req.getParameter("positive").equals("true")) {
                    String win = questionFromJsp.getAnswers().get(0).getAnswerEndGameText();
                    session.setAttribute("WinOrLost", win);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/win-or-lost.jsp");
                    requestDispatcher.forward(req, resp);
                }
            }

            String negative = req.getParameter("negative");
            if (negative != null && negative.equals("false")) {
                String lost = questionFromJsp.getAnswers().get(1).getAnswerEndGameText();
                session.setAttribute("WinOrLost", lost);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/win-or-lost.jsp");
                requestDispatcher.forward(req, resp);
            }
            resp.sendRedirect("/quest.jsp");
        } else {
            resp.sendRedirect("/quest.jsp");
        }

    }
}