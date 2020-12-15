<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-10-08
  Time: 15:59
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
    <c:forEach items="${training.listOfSets}" var="exercise" varStatus="j">
    <h4 class="title"><c:out value="${exercise.name}"/></h4>
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
                <c:out value="${set.weight}"/>
            </td>
            <td>
                <c:out value="${set.reps}"/>
            </td>
            <td>
                <c:out value="${set.rpe}"/>
            </td>
            <td>
                <c:out value="${set.tempo}"/>
            </td>



            </c:forEach>
    </table>
    </c:forEach>
</div>



</body>
</html>
