<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"></c:set>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message key="en"/></option>
        <option value="ru" ${language == 'ru' ? 'selected' : ''}><fmt:message key="ru"/></option>
    </select>
</form>
<c:if test="${error eq true}">
    <p><fmt:message key="pass-doesnt-match"/><br/></p>
</c:if>
<form method="post" action="register">

    <fmt:message key="email"/>:<input type="text" name="email" required pattern="^[a-zA-Z0-9_.-]+@[a-zA-Z0-9]+[\.][a-z]+$" /><br/>
    <fmt:message key="pass"/>:<input type="password" name="pass" required/><br/>
    <fmt:message key="confirm-pass"/>:<input type="password" name="confpass" /><br/>
    <input type="submit" />
    <a href="login"><fmt:message key="login"/></a>
</form>
</body>
</html>
