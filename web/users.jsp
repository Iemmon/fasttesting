<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"></c:set>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message key="en"/></option>
        <option value="ru" ${language == 'ru' ? 'selected' : ''}><fmt:message key="ru"/></option>
    </select>
</form>
<table>
    <tr>
        <th><fmt:message key="user-id"/></th>
        <th><fmt:message key="user-email"/></th>
    </tr>
<jsp:useBean id="users" scope="request" type="java.util.List"/>
<c:forEach var="user" items="${users}">
    <tr>
        <td>${user.getUserId()}</td>
        <td>${user.getEmail()}</td>
    </tr>
</c:forEach>
</table>
    <tr>
        <c:forEach begin="1" end="${maxPages}" var="i">
                    <td><a href="user?page=${i}">${i}</a></td>
        </c:forEach>
    </tr>
</table>
</body>
</html>
