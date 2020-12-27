<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale scope="session" value="${language}"/>
<fmt:setBundle basename="property.text" var="text"/>
<!DOCTYPE html>
<html>
<head>
    <c:import url="fragment/bootstrap_style.jsp"/>
    <link rel="stylesheet" href="css/login.css" type="text/css"/>
    <fmt:message key="login.title" var="title" bundle="${text}"/>
    <title>${title}</title>
</head>
<body>
<c:import url="fragment/header.jsp"/>
<div class="login-container">
    <div>
        <fmt:message key="login.message" var="message" bundle="${text}"/>
        <h2>${message}</h2>
        <form id="loginForm" class="needs-validation" action="controller" onsubmit="return false" method="post" novalidate>
            <input type="hidden" name="command" value="login">
            <div class="form-group">
                <fmt:message key="login.email.label" var="emailLabel" bundle="${text}"/>
                <label for="email">${emailLabel}</label>
                <fmt:message key="login.email.placeholder" var="emailPlaceholder" bundle="${text}"/>
                <input type="email" name="email" value="" class="form-control" id="email"
                       placeholder="${emailPlaceholder}" required pattern="^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$">
            </div>
            <div class="form-group">
                <fmt:message key="login.password.label" var="passwordLabel" bundle="${text}"/>
                <label for="password">${passwordLabel}</label>
                <fmt:message key="login.password.placeholder" var="passwordPlaceholder" bundle="${text}"/>
                <input type="password" name="password" value="" class="form-control" id="password"
                       placeholder="${passwordPlaceholder}" aria-describedby="passwordHelp" required pattern="[a-zA-Z0-9@#$%!]{8,40}">
                <fmt:message key="login.password.help" var="passwordHelp" bundle="${text}"/>
                <small id="passwordHelp" class="form-text text-muted">${passwordHelp}</small>
            </div>
            <div class="login-item">
                <fmt:message key="login.submit" var="submit" bundle="${text}"/>
                <button type="submit" id="submit" class="btn btn-primary">${submit}</button>
            </div>
        </form>
        <br/>
        <c:if test="${not empty errorEmailOrPassword}">
            <div class="alert alert-danger" role="alert">
                    ${errorEmailOrPassword}
            </div>
        </c:if>
        <c:if test="${not empty errorUser}">
            <div class="alert alert-danger" role="alert">
                    ${errorUser}
            </div>
        </c:if>
    </div>
</div>
<c:import url="fragment/bootstrap_script.jsp"/>
<script src="js/login.js"></script>
</body>
</html>
