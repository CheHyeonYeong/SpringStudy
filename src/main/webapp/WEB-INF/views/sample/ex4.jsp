<%--
  Created by IntelliJ IDEA.
  User: hyeonyeong
  Date: 2024-04-19
  Time: 오후 4:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${message}</h1>
    <h1><c:out value="${message}" /></h1>
</body>
</html>
