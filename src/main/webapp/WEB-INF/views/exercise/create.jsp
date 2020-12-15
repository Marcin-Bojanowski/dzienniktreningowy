<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-09-25
  Time: 15:17
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

        <form:form method="post" modelAttribute="newExerciseDTO">
            <div class="field">
                <div class="control">
                    <form:select path="defaultExercise" class="input is-primary" type="text">
                        <form:option value="0" label="Wybierz ćwiczenie"/>
                        <form:options items="${defaultExercise}" itemValue="id" itemLabel="name"/>
                    </form:select>
                </div>
                <div class="control">
                    Liczba serii:
                    <form:input path="sets" class="input is-primary" type="number"/>
                </div>
                <div class="control">
                    Liczba powtórzeń:
                    <form:input path="reps" class="input is-primary" type="number"/>
                </div>
                <div class="control">
                    Skala RPE:
                    <form:input path="rpe" class="input is-primary" type="number"/>
                </div>
                <div class="control">
                    Tempo:
                    <form:input path="tempo" class="input is-primary" type="text"/>
                </div>
                <form:hidden path="trainingSessionId"  value="${newExerciseDTO.trainingSessionId}"/>
            </div>
            <input type="submit" value="Wyślij">
        </form:form>
    </div>

</div>

</body>
</html>
