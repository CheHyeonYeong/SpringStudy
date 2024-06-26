<%--
  Created by IntelliJ IDEA.
  User: hyeonyeong
  Date: 2024-04-23
  Time: 오전 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>read </title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<!-- 부트스트랩의 container, row 적용 -->
<div class="container-fluid">
    <div class="row">
        <!-- 기존의 h1 태그(header)가 있던 위치 -->
        <div class="row">
            <div class="col">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">navbar</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                            <div class="navbar-nav">
                                <a class="nav-link active" aria-current="page" href="#">home</a>
                                <a class="nav-link" href="#">Features</a>
                                <a class="nav-link" href="#">Pricing</a>
                                <a class="nav-link" href="#">Disabled</a>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- header end -->

        <div class="row content">
            <div class="col">
                <div class="card">
                    <div class="card-header">
                        Featured
                    </div>
                    <div class="card-body">
                        <form action="/todo/modify" method="post">
                            <input type="hidden" name="page" value="${pageRequestDTO.page}">
                            <input type="hidden" name="size" value="${pageRequestDTO.size}">
                        <div class="input-group mb-3">
                            <div class="row">
                            <span class="input-group-text">TNO</span>
                            <input type="text" name="tno" class="form-control"
                                value=<c:out value="${dto.tno}"/> readonly>
                            </div>

                            <div class="row">
                            <span class="input-group-text">TITLE</span>
                            <input type="text" name="title" class="form-control"
                                   value='<c:out value="${dto.title}"/>'>
                            </div>

                            <div class="row">
                            <span class="input-group-text">WRITER</span>
                            <input type="text" name="writer" class="form-control"
                                   value=<c:out value="${dto.writer}"/> readonly>
                            </div>

                            <div class="row">
                            <span class="input-group-text">DUEDATE</span>
                            <input type="date" name="dueDate" class="form-control"
                                   value=<c:out value="${dto.dueDate}"/> >
                            </div>
                            <div class="row">
                            <label class="from-check-label">FINISHED &nbsp;</label>
                            <input type="checkbox" name="finished" class="form-check-input"
                                   ${dto.finished ? "checked" : ""} >
                            </div>
                        </div>
                        </form>
                        <div class="my-4">
                            <div class="float-end">
                                <button type="button" class="btn btn-danger">Remove</button>
                                <button type="submit" class="btn btn-primary">Modify</button>
                                <button type="button" class="btn btn-secondary">Go to List</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row content">
        <h1>Content</h1>
    </div>
    <div class="row footer">
        <!--<h1>Footer</h1>-->

        <div class="row fixed-bottom" style="z-index: -100">
            <footer class="py-1 my-1 ">
                <p class="text-center text-muted">footer</p>
            </footer>
        </div>
    </div>

</div>

<script>
    document.querySelector(".btn-primary").addEventListener("click", function (e){
        e.preventDefault(); //더 이상 진행하지 않음
        e.stopPropagation() //
        formObj.action = "/todo/modify";
        formObj.method = "post";
        formObj.submit();
    },false);
    //option이 없다

    document.querySelector(".btn-secondary").addEventListener("click", function (e){
        e.preventDefault(); //더 이상 진행하지 않음
        e.stopPropagation() //

        self.location = `/todo/list?${pageRequestDTO.link}`;
    },false);
    const formObj = document.querySelector("form")
    document.querySelector(".btn-danger").addEventListener("click", function (e) {
        e.preventDefault(); //더 이상 진행하지 않음
        e.stopPropagation() //
        formObj.action = "/todo/remove";
        formObj.method = "post";
        formObj.submit();
    },false);
</script>
<script>
    const serverValidResult = {}
    <c:forEach items="${errors}" var="error">
    serverValidResult['$[error..getFieldId()']='${error.defaultMessage}'
    </c:forEach>
    console.log(serverValidResult)
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>