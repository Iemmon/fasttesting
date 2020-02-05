<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}" scope="session"></c:set>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title>Tests</title>
</head>
<body>
<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message key="en"/></option>
        <option value="ru" ${language == 'ru' ? 'selected' : ''}><fmt:message key="ru"/></option>
    </select>
</form>
<p><fmt:message key="choose-test"/></p>
<jsp:useBean id="tests" scope="request" type="java.util.List"/>
<c:forEach var="test" items="${tests}">
    <tr>
        <td>${test.getId()}</td>
        <td><a href="questions?test_id=${test.getId()}">${test.getName()}</a></td><br />
    </tr>
</c:forEach>
</body>
</html>
