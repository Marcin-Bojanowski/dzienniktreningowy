<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-10-03
  Time: 12:16
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
<%--    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
<%--    <script src="../../../newTrainingJS.js" type="text/javascript"></script>--%>
</head>
<body>
<jsp:include page="/WEB-INF/views/page/header.jsp"/>
<div class="container">
    <form:form method="post" modelAttribute="newTrainingDTO" action="/user/performTraining">



        <form:input name="trainingSessionId" path="trainingSessionId" type="hidden" value="${newTrainingDTO.trainingSessionId}"/>
        <form:errors path="*"/><br>
        <c:forEach items="${newTrainingDTO.listOfSets}" var="exercise" varStatus="j">
            <div class="exercise">
                <h4 class="title"><c:out value="${exercise.name}"/></h4>
                <form:input path="listOfSets[${j.index}].id" type="hidden" value="${exercise.id}" class="exerciseId"/>
                <form:input path="listOfSets[${j.index}].name" type="hidden" value="${exercise.name}" class="exerciseName"/>
                <table class="table">
                    <thead>
                    <tr>

                        <th><abbr title="Sets">Seria</abbr></th>
                        <th><abbr title="Weight">Ciężar</abbr></th>
                        <th><abbr title="Reps">Liczba powtórzeń</abbr></th>
                        <th><abbr title="RPE">RPE</abbr></th>
                        <th><abbr title="Tempo">Tempo</abbr></th>
                    </tr>
                    </thead>
                    <c:forEach items="${exercise.sets}" var="set" varStatus="i" >
                    <tbody>
                    <tr class="clickable-row">
                        <td><c:out value="${i.index+1}"/></td>
                        <td>
                            <form:input path="listOfSets[${j.index}].sets[${i.index}].weight" type="number" id="weight" class="input" value="0"/>
                        </td>
                        <td>
                            <form:input path="listOfSets[${j.index}].sets[${i.index}].reps" type="number"  id="reps" class="input" value="${set.reps}"/>
                        </td>
                        <td>
                            <form:input path="listOfSets[${j.index}].sets[${i.index}].rpe" type="number" id="rpe" class="input" value="${set.rpe}"/>
                        </td>
                        <td>
                            <form:input path="listOfSets[${j.index}].sets[${i.index}].tempo" type="text" id="tempo" class="input" value="${set.tempo}"/>
                        </td>



                        </c:forEach>
                </table>
            </div>
        </c:forEach>
        <input id="button" type="submit" value="Wyślij"/>
    </form:form>
</div>


</body>
</html>
