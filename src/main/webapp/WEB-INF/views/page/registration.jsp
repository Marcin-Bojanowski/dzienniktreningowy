<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-09-14
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/page/header.jsp"/>
<section class="hero is-half">
    <div class="hero-body">
        <div class="container is-centered">
            <div class="columns is-centered">
                <form:form method="post" modelAttribute="userDTO">
                    <div>
                        Nazwa użytkownika <form:input class="input is-primary" path="username"/>
                        <form:errors path="username"/>
                    </div>
                    <div>
                        Email: <form:input class="input is-primary" path="email"/>
                        <form:errors path="email"/>
                    </div>
                    <div>
                        Hasło: <form:password class="input is-primary" path="password"/>
                        <form:errors path="password"/>
                    </div>
                    <div>
                        Powtórz hasło: <form:password class="input is-primary" path="rePassword"/>
                        <form:errors path="rePassword"/>
                    </div>
                    <div>
                        <input type="submit" value="Zarejestruj">
                    </div>
                    <c:forEach items="${violations}" var="viol">
                        <spring:message code="${viol.message}"/><br>
                    </c:forEach>
                    <%--    <spring:message code="uniqueEmail.error.message"/>--%>
                </form:form>
            </div>

        </div>
    </div>
</section>
</body>
</html>
