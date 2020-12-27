<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale scope="session" value="${language}"/>
<fmt:setBundle basename="property.text" var="text"/>
<!DOCTYPE html>
<html>
<head>
    <c:import url="fragment/bootstrap_style.jsp"/>
    <fmt:message key="login.title" var="title" bundle="${text}"/>
    <link rel="stylesheet" href="css/login.css" type="text/css"/>
    <title>${title}</title>
</head>
<body>
<c:import url="fragment/header.jsp"/>
<div class="login-container">
    <div>
        <h2>Please sign in</h2>
        <form id="loginForm" class="needs-validation" action="controller" method="post" novalidate>
            <input type="hidden" name="command" value="login">
            <div class="form-group">
                <label for="email">Email address</label>
                <input type="email" name="email" value="" class="form-control" id="email"
                       placeholder="Enter email" required>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" name="password" value="" class="form-control" id="password"
                       placeholder="Enter password" aria-describedby="passwordHelp">
                <small id="passwordHelp" class="form-text text-muted">Password should be more then 8 less then 40
                    symbols</small>
                <div class="valid-feedback">
                    Looks good!
                </div>
            </div>
            <div class="login-item">
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="rememberMe">
                    <label class="form-check-label" for="rememberMe">Remember me</label>
                </div>
                <button type="submit" id="submit" class="btn btn-primary">Sign in</button>
            </div>
        </form>
    </div>
</div>
<script src="js/login.js"></script>
<c:import url="fragment/bootstrap_script.jsp"/>
</body>
</html>
