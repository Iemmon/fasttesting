<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${users.size()}

<table>

<jsp:useBean id="users" scope="request" type="java.util.List"/>
<c:forEach var="user" items="${users}">
    <tr>
        <td>${user.getUserId()}</td>
        <td>${user.getEmail()}</td>
    </tr>
</c:forEach>

</table>
</body>
</html>
