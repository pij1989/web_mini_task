<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <c:import url="fragment/bootstrap_style.jsp"/>
    <fmt:setLocale scope="session" value="${language}"/>
    <fmt:setBundle basename="property.text"/>
    <fmt:message key="result.title" var="title"/>
    <title>${title}</title>
</head>
<body>
<fmt:message key="result.h1" var="h1"/>
<h1>${h1} ${square}</h1>
<c:import url="fragment/bootstrap_script.jsp"/>
</body>
</html>
