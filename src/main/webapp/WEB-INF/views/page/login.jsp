<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-09-15
  Time: 18:01
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
<jsp:include page="header.jsp"/>
<section class="hero is-half">
    <div class="hero-body">
        <div class="container">
            <div class="columns  is-centered ">
                <form method="post">
                    <div class="field">
                        <label class="label">Nazwa użytkownika:</label>
                        <div class="control">
                            <input class="input" type="text" placeholder="Text input" name="username">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Hasło:</label>
                        <div class="control">
                            <input class="input" type="password" placeholder="Text input" name="password">
                        </div>
                    </div>

                    <div><input type="submit" value="Sign In"/></div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>

        </div>
    </div>
</section>


</body>
</html>
