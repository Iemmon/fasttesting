<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tests</title>
</head>
<body>
<jsp:useBean id="tests" scope="request" type="java.util.List"/>
<c:forEach var="test" items="${tests}">
    <tr>
        <td>${test.getId()}</td>
        <td><a href="questions?test_id=${test.getId()}">${test.getName()}</a></td><br />
    </tr>
</c:forEach>
</body>
</html>
