<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}"
       scope="session"></c:set>
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
<%--<c:if test="${sessionScope.currentUser.role eq 'ADMIN'}"><a href="?command=users"> View user list </a></c:if> <br/>--%>
<c:if test="${sessionScope.currentUser.role eq 'STUDENT'}"><a href="?command=results"> View results </a></c:if> <br/>
<c:if test="${sessionScope.currentUser.role eq 'STUDENT'}"><a href="?command=topics"> Take a test </a></c:if> <br/>
<a href="?command=logout"> Logout </a>
</body>
</html>
