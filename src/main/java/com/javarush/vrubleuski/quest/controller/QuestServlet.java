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

        if (req.getParameter("answer") != null) {
            HttpSession session = req.getSession();
            String answer = req.getParameter("answer");
            Question questionFromJsp = (Question) session.getAttribute("question");

            if (answer.equals("no")) {
                String lost = questionFromJsp.getAnswers().get(1).getAnswerEndGameText();
                session.setAttribute("WinOrLost", lost);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/win-or-lost.jsp");
                requestDispatcher.forward(req, resp);
            }

            if (questionFromJsp.getAnswers().get(0).nextQuestion() != null) {
                Question nextQuestion = questionFromJsp.getAnswers().get(0).nextQuestion();
                session.setAttribute("question", nextQuestion);
                resp.sendRedirect("/quest.jsp");
            } else {
                if (answer.equals("yes")) {
                    String win = questionFromJsp.getAnswers().get(0).getAnswerEndGameText();
                    session.setAttribute("WinOrLost", win);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/win-or-lost.jsp");
                    requestDispatcher.forward(req, resp);
                }
            }
        } else {
            resp.sendRedirect("/quest.jsp");
        }

    }
}