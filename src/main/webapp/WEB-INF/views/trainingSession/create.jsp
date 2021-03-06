<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-09-23
  Time: 11:49
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
<section class="hero is-half is-left">
    <div class="container is-desktop">
        <form:form method="post" modelAttribute="newTrainingSessionDTO">
            <div class="field">
                <div class="control">
                    <h3 class="title is-4">Nazwa jednostki treningowej</h3>
                    <form:input path="name" class="input is-primary" type="text" />
                </div>

                <form:hidden path="trainingProgramId"  value="${newTrainingSessionDTO.trainingProgramId}"/>
            </div>
            <input type="submit" value="Wyślij">
        </form:form>
    </div>
</section>


</body>
</html>
