<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}"
       scope="session"></c:set>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title>Home</title>
    <%@include file="includes/resources.jsp" %>
</head>
<body>
<%@include file="includes/header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col main-content">

            <div class="jumbotron jumbotron-fluid">
                <div class="container">
                    <h1 class="display-4">Hello!</h1>
                    <p class="lead">Welcome to the best quiz website! Enjoy out variaty of different questions in JAVA, SQL and other topics. I have spent sooo many hours collecting questions for these tests.</p>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="includes/footer.jsp" %>
</body>
</html>
