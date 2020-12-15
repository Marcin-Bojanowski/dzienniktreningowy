<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-09-24
  Time: 11:17
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
    <div><a href="/user/addExercise/${trainingSessionDTO.id}" class="button">Dodaj ćwiczenie</a>
        <a href="/user/performTraining/${trainingSessionDTO.id}"  class="button is-link is-light">Zrób trening</a></div>

    <table class="table">
        <thead>
        <tr>
            <th><abbr title="Name">Nazwa</abbr></th>
            <th><abbr title="Name">Grupa mięśniowa</abbr></th>
            <th><abbr title="Sets">Liczba serii</abbr></th>
            <th><abbr title="Reps">Liczba powtórzeń</abbr></th>
            <th><abbr title="RPE">RPE</abbr></th>
            <th><abbr title="Tempo">Tempo</abbr></th>
        </tr>
        </thead>
        <c:forEach items="${trainingSessionDTO.exercises}" var="exercises">
            <tbody>
            <tr class="clickable-row">
                <td><c:out value="${exercises.name}"/></td>
                <td><c:out value="${exercises.muscleGroup.name}"/></td>
                <td><c:out value="${exercises.sets}"/></td>
                <td><c:out value="${exercises.reps}"/></td>
                <td><c:out value="${exercises.rpe}"/></td>
                <td><c:out value="${exercises.tempo}"/></td>

            </tr>
            </tbody>

        </c:forEach>
    </table>
</div>


</body>
</html>
