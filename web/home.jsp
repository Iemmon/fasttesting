<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"></c:set>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message key="en"/></option>
        <option value="ru" ${language == 'ru' ? 'selected' : ''}><fmt:message key="ru"/></option>
    </select>
</form>
<a href="?command=results"> Results </a><br />
<a href="?command=topics">  Take a test</a><br />
<a href="?command=logout"> Logout </a>
</body>
</html>
