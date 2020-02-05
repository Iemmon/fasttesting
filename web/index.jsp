<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"></c:set>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title>Main</title>
</head>
<body>
<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        <option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
    </select>
</form>
<a href="user"> <fmt:message key="users"/> </a><br />
<a href="register"><fmt:message key="register"/></a><br />
<a href="login"><fmt:message key="login"/></a><br />
<a href="topics"><fmt:message key="topics"/></a>
</body>
</html>
