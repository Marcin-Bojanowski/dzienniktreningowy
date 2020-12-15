<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-09-29
  Time: 23:41
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
<div class="container is-centered">
    <h1 class="title has-text-centered">Dodaj ćwiczenie</h1>
    <div class="columns is-centered">
        <form:form method="post" modelAttribute="newDefaultExerciseDTO">
            <form:errors path="*"/><br>
            <div class="field">
                <div class="control">
                    Nazwa ćwiczenia
                    <form:input path="name" class="input is-primary" type="text"/><br>
                </div>
                <div class="control">
Grupa mięśniowa
                    <form:select path="muscleGroup" class="input is-primary" type="text">
                        <form:option value="0" label="Wybierz grupę mieśniową"/>
                        <form:options items="${muscleGroups}" itemValue="id" itemLabel="name"/>
                    </form:select>
                </div>
                <div class="control">
                    Opis
                    <form:input path="description" class="input is-primary" type="text"/>
                </div>
            </div>
            <input type="submit" value="Wyślij">
        </form:form>
    </div>
</body>
</html>
