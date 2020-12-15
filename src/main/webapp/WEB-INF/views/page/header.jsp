<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-10-09
  Time: 9:59
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
<nav class="navbar is-dark" role="navigation" aria-label="dropdown navigation">
    <p class="title is-1 has-text-white">
        <a class="has-text-white" href="/">Dziennik treningowy</a>

    </p>

    <%--    <div class="navbar-item has-dropdown is-active">--%>
    <%--        <a class="navbar-link">--%>
    <%--            Docs--%>
    <%--        </a>--%>

    <%--        <div class="navbar-dropdown">--%>
    <%--            <a class="navbar-item">--%>
    <%--                Overview--%>
    <%--            </a>--%>
    <%--            <a class="navbar-item is-active">--%>
    <%--                Elements--%>
    <%--            </a>--%>
    <%--            <a class="navbar-item">--%>
    <%--                Components--%>
    <%--            </a>--%>
    <%--            <hr class="navbar-divider">--%>
    <%--            <div class="navbar-item">--%>
    <%--                Version 0.6.2--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </div>--%>
    <div class="navbar-end">
        <div class="navbar-item">
            <div class="field is-grouped">
                <c:if test="${empty role}">
                    <p class="control">
                        <a class="bd-tw-button button" href="/login">
                        <span>
                Logowanie
              </span>
                        </a>
                    </p>
                    <p class="control">
                        <a class="button is-primary" href="/register">
                            <span>Rejestracja</span>
                        </a>
                    </p>
                </c:if>
                <c:if test="${not empty role}">


                    <div class="navbar-item has-dropdown is-hoverable">
                            <%--        <nav class="button" role="navigation" aria-label="dropdown navigation">--%>
                        <div class="navbar-item has-dropdown is-hoverable">
                            <a class="button">
                                Menu
                            </a>

                                <div class="navbar-dropdown">
                                    <c:if test="${role=='user'}">
                                    <a class="navbar-item" href="/user">
                                        Twoje plany treningowe
                                    </a>
                                    <a class="navbar-item" href="/user/createTrainingProgram">
                                        Dodaj plan treningowy
                                    </a>
                                    <a class="navbar-item" href="/user/history">
                                        Historia treningów
                                    </a>
                                        <%--                    <hr class="navbar-divider">--%>
                                        <%--                    <div class="navbar-item">--%>
                                        <%--                        Version 0.6.2--%>
                                        <%--                    </div>--%>
                                    </c:if>
                                    <c:if test="${role=='admin'}">
                                        <a class="navbar-item" href="admin/addExercise">
                                           Dodaj ćwiczenie
                                        </a>
                                    </c:if>
                                </div>

                        </div>
                            <%--        </nav>--%>
                    </div>


                    <p class="control">
                    <form action="<c:url value="/logout"/>" method="post">
                        <input class="bd-tw-button button" type="submit" value="Wyloguj">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                    </p>

                </c:if>
            </div>
        </div>
    </div>
    </div>
</nav>
</body>
</html>
