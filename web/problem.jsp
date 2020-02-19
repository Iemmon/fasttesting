<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}"
       scope="session"></c:set>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title>Problem</title>
    <%@include file="includes/resources.jsp" %>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col">
            <div class="alert alert-danger" role="alert">
                Error! RUN FOR YOUR LIFE!!!!!
                <a href="?command=home">Return to main page</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
