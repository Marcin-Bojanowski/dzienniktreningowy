<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-09-15
  Time: 22:51
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

<%--<h2> <a href="user/createTrainingProgram"  class="title is-2 button is-link is-light">Utwórz plan treningowy</a></h2>--%>
<div class="container is-desktop">
    <h2 class="title">Twoje plany treningowe</h2>
    <table class="table">
        <thead>
        <tr>
            <th><abbr title="Name">Nazwa</abbr></th>
            <th><abbr title="Description">Opis</abbr></th>
            <th><abbr title="Start">Data rozpoczęcia</abbr></th>
            <th><abbr title="End">Data zakończenia</abbr></th>
        </tr>
        </thead>
        <c:forEach items="${userTrainingProgramsDTO}" var="utp">
            <tbody>
            <tr class="clickable-row">
                <td><a href="/user/trainingProgram/${utp.id}" class="button is-link is-light">${utp.name}</a></td>
                <td><c:out value="${utp.description}" /></td>
                <td><c:out value="${utp.start}" /></td>
                <td><c:out value="${utp.end}" /></td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>


</body>
</html>
