<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale scope="session" value="${language}"/>
<fmt:setBundle basename="property.text" var="text"/>
<!DOCTYPE html>
<html>
<head>
    <c:import url="fragment/bootstrap_style.jsp"/>
    <fmt:message key="main.title" var="title" bundle="${text}"/>
    <title>${title}</title>
</head>
<body>
<c:import url="fragment/header.jsp"/>
<div style="display: flex; justify-content: center">
    <div>
        <fmt:message key="main.message" var="message" bundle="${text}"/>
        <h1>${message}</h1>
        <hr/>
        <form action="controller" method="get">
            <input type="hidden" name="command" value="circle_square"/>
            <div class="form-group">
                <fmt:message key="main.label" var="label" bundle="${text}"/>
                <label for="inputRadius">${label}</label>
                <fmt:message key="main.placeholder" var="placeholder" bundle="${text}"/>
                <input type="text" class="form-control" name="radius" value="" id="inputRadius"
                       placeholder="${placeholder}"/>
                <input type="text"class="form-control" name="text" value=""/>
            </div>
            <fmt:message key="main.submit" var="submit" bundle="${text}"/>
            <button type="submit" class="btn btn-primary">${submit}</button>
        </form>
        <br/>
        <c:if test="${not empty errorRadiusPassMessage}">
            <div class="alert alert-danger" role="alert">
                    ${errorRadiusPassMessage}
            </div>
        </c:if>
    </div>
</div>
<c:import url="fragment/bootstrap_script.jsp"/>
</body>
</html>
