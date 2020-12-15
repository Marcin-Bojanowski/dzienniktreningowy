<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-09-17
  Time: 13:41
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
<section class="hero">
    <div class="hero-body">
        <div class="container">
            <h1 class="title">
             <c:out value="${trainingProgramDTO.name}"/>
            </h1>
            <h2 class="subtitle">
                Rozpoczącie: <c:out value="${trainingProgramDTO.start}"/><br>
                Zakończenie: <c:out value="${trainingProgramDTO.end}"/>
            </h2>
            <h3 class="subtitle ">
                <c:out value="${trainingProgramDTO.description}"/>
            </h3>
            <div><a href="/user/addTrainingSession/${trainingProgramDTO.id}" class="button">Dodaj jednostke treningową</a></div>
        </div>
    </div>

</section>
<div class="container">
    <c:forEach items="${trainingProgramDTO.trainingSessions}" var="session">
        <h2 > <a href="/user/trainingSession/${session.id}"  class="title is-4 button is-link is-light">${session.name}</a>

        </h2>
        <table class="table">
            <thead>
            <tr>
                <th><abbr title="Name">Nazwa</abbr></th>
                <th><abbr title="Sets">Liczba serii</abbr></th>
                <th><abbr title="Reps">Liczba powtórzeń</abbr></th>
                <th><abbr title="RPE">RPE</abbr></th>
                <th><abbr title="Tempo">Tempo</abbr></th>
            </tr>
            </thead>
            <c:forEach items="${session.exercises}" var="exercises">
                <tbody>
                <tr class="clickable-row">
                    <td><c:out value="${exercises.name}"/></td>
                    <td><c:out value="${exercises.sets}"/></td>
                    <td><c:out value="${exercises.reps}"/></td>
                    <td><c:out value="${exercises.rpe}"/></td>
                    <td><c:out value="${exercises.tempo}"/></td>

                </tr>
                </tbody>

            </c:forEach>
        </table>
    </c:forEach>
</div>








</body>
</html>
