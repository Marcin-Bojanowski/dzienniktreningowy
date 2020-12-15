<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-09-16
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
<html>
<head>
    <title>Title</title>

</head>
<body>
<jsp:include page="/WEB-INF/views/page/header.jsp"/>
<div class="container">
    <div class="columns is-centered">
        <form:form method="post" modelAttribute="newUserTrainingProgramDTO">
            <form:errors path="*"/><br>
            <div class="field">
                <div class="control">
                    Nazwa planu treningowego:
                    <form:input path="name" class="input is-primary" type="text"/>
                </div>
                <div class="control">
                    Opis:
                    <form:input path="description" class="input is-primary" type="text"/>
                </div>
                <div class="control">
                    Data rozpoczęcia:
                    <form:input path="start" class="input is-primary" type="date"/>
                </div>
                <div class="control">
                    Data zakończenia:
                    <form:input path="end" class="input is-primary" type="date"/>
                </div>
            </div>
            <input type="submit" value="Wyślij">

        </form:form>
    </div>

</div>

</body>
</html>
