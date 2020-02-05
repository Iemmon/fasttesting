<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>USER ID</th>
        <th>USER EMAIL</th>
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
