<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale scope="session" value="${language}"/>
<fmt:setBundle basename="property.text"/>
<!DOCTYPE html>
<html>
<head>
    <c:import url="fragment/bootstrap_style.jsp"/>
    <fmt:message key="result.title" var="title"/>
    <title>${title}</title>
</head>
<body>
<fmt:message key="result.message" var="message"/>
<h1>${message} ${square}</h1>
<h3>${text}</h3>
<c:import url="fragment/bootstrap_script.jsp"/>
</body>
</html>
