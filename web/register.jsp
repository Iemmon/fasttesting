<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<c:if test="${error eq true}">
    <p>Passwords don't match</p>
</c:if>
<form method="post" action="register">
    Email ID:<input type="text" name="email" /><br/>
    Password:<input type="password" name="pass" /><br/>
    Confirm Password:<input type="password" name="confpass" /><br/>
    <input type="submit" />
</form>

</body>
</html>
