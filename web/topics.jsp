<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}"
       scope="session"></c:set>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title>Topics</title>
</head>
<body>
<form>
    <input type="hidden" name="command" value="${param.command}"/>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message key="en"/></option>
        <option value="ru" ${language == 'ru' ? 'selected' : ''}><fmt:message key="ru"/></option>
    </select>
</form>
<p><fmt:message key="choose-topic"/></p>
<jsp:useBean id="topics" scope="request" type="java.util.List"/>
<table>
<c:forEach var="topic" items="${topics}">
    <tr>
        <td>${topic.getId()}</td>
        <td><a href="?command=tests&topic_id=${topic.getId()}">${topic.getTopicName()}</a></td>
    </tr>
</c:forEach>
</table>>
<a href="?command=logout"> Logout </a>
</body>
</html>
