<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<c:if test="${error eq true}">
    <p>Email or password is incorrect or user doesn't exist</p>
</c:if>
<form method="post" action="login">
    Email ID:<input type="text" name="email" required pattern="^[a-zA-Z0-9_.-]+@[a-zA-Z0-9]+[\.][a-z]+$"/><br/>
    Password:<input type="password" name="pass" required pattern="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20}"/><br/>
    <input type="submit" />
</form>
</body>
</html>
