<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script defer src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/general.css">
</head>
<body>
<br>
<br>
<h4><%=session.getAttribute("WinOrLost")%></h4>
<form action="index.html" method="get" >
    <input type="submit" value="Начать заново"/>
</form>
<br>
<br>
<br>
<b>Статистика:</b>
<br>Имя в игре:<b><%= session.getAttribute("username") %>
</b>
<br>Количество игр: <b><%= session.getAttribute("count") %>
</b>
<br>Номер сессии : <b><%= session.getAttribute("idsession") %>
</body>
</body>
</html>
