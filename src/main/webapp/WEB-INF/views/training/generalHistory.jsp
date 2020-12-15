<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-10-08
  Time: 12:41
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
    <h1 class="title">Historia treningów</h1>
    <table class="table">
        <thead>
        <tr>
            <th><abbr title="PerformDate">Data</abbr></th>
            <th><abbr title="TrainingSessionName">Jednostka treningowa</abbr></th>
        </tr>
        </thead>
        <c:forEach items="${trainings}" var="training">
            <tbody>
            <tr class="clickable-row">
                <td><a href="/user/history/training/${training.id}" class="button"><c:out value="${training.performDate}"/></a>   </td>
                <td><c:out value="${training.trainingSessionName}"/></td>
            </tr>
            </tbody>

        </c:forEach>
    </table>
</div>

</body>
</html>
