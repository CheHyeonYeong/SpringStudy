<%--
  Created by IntelliJ IDEA.
  User: hyeonyeong
  Date: 2024-04-19
  Time: 오후 3:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/todo/register" method="post">
    <label for="title">Title:</label><br>
    <input type="text" id="title" name="title"><br><br>

    <label for="dueDate">DueDate:</label><br>
    <input type="date" id="dueDate" name="dueDate"><br><br>

    <label for="writer">Writer:</label><br>
    <input type="text" id="writer" name="writer"><br><br>

    <label for="finished">Finished:</label><br>
    <input type="checkbox" id="finished" name="finished"><br><br>

    <input type="submit" value="Register">
</form>
</body>
</html>
