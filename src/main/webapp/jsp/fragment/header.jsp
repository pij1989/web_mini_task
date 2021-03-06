<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale scope="session" value="${language}"/>
<fmt:setBundle basename="property.text" var="text"/>
<fmt:message key="main.title" var="title" bundle="${text}"/>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div style="display: flex; flex-grow: inherit; justify-content: flex-end">
                <form class="form-inline my-2 my-lg-0" action="controller" method="post">
                    <input type="hidden" name="command" value="change_language"/>
                    <div class="dropdown">
                        <fmt:message key="header.button.language" var="language" bundle="${text}"/>
                        <button class="btn btn-success dropdown-toggle mx-2" type="button" id="language"
                                data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                            ${language}
                        </button>
                        <div class="dropdown-menu" aria-labelledby="change_language">
                            <button class="dropdown-item" type="submit" name="language" value="en">EN</button>
                            <button class="dropdown-item" type="submit" name="language" value="ru">RU</button>
                        </div>
                    </div>
                </form>
                <c:choose>
                    <c:when test="${isAuthentication}">
                        <form class="form-inline my-2 my-lg-0" action="controller">
                            <input type="hidden" name="command" value="logout">
                            <fmt:message key="header.button.signout" var="signout" bundle="${text}"/>
                            <button class="btn btn-outline-success mx-2 my-2 my-sm-0" type="submit">${signout}</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form class="form-inline my-2 my-lg-0" action="controller">
                            <input type="hidden" name="command" value="to_login_page_command">
                            <fmt:message key="header.button.signin" var="signin" bundle="${text}"/>
                            <button class="btn btn-outline-success mx-2 my-2 my-sm-0" type="submit">${signin}</button>
                        </form>
                    </c:otherwise>
                </c:choose>
                <form class="form-inline my-2 my-lg-0" action="controller">
                    <input type="hidden" name="command" value="to_register_page_command">
                    <fmt:message key="header.button.signup" var="signup" bundle="${text}"/>
                    <button class="btn btn-outline-success mx-2 my-2 my-sm-0" type="submit">${signup}</button>
                </form>
            </div>
        </div>
    </nav>
</header>


