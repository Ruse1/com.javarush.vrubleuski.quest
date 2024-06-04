<%@ page import="com.javarush.vrubleuski.quest.entity.Question" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</head>
<body>
<br>
<br>
<br>
<% Question q = (Question) session.getAttribute("question");
    String questionText = null;
    String answer0 = null;
    String answer1 = null;
    if (q != null) {
        questionText = q.getQuestionText();
        answer0 = q.getAnswers().get(0).getAnswerText();
        answer1 = q.getAnswers().get(1).getAnswerText();
    }
%>
<h4><%=questionText%>
</h4>

<form action="quest-servlet" method="get">
    <input type="radio" id="answer0" name="positive" value="true">
    <label for="answer0">
        <%= answer0 %>
        <% session.setAttribute("question", q); %>
    </label><br>

    <input type="radio" id="answer1" name="negative" value="false">
    <label for="answer1"><%= answer1 %>
        <% session.setAttribute("question", q); %>
    </label><br>
    <br>
    <input type="submit" value="Ответить">
</form>
<br>
<br>
<br>
<br>
<br>
<p><b>Статистика:</b>
    <br>Имя в игре:<b><%= session.getAttribute("username") %>
    </b>
    <br>Количество игр: <b><%= session.getAttribute("count") %>
    </b>
    <br>Номер сессии : <b><%= session.getAttribute("idsession") %>
</p>
</body>
</html>