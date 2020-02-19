<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}"
       scope="session"></c:set>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title>Topics</title>
    <%@include file="includes/resources.jsp" %>
</head>
<body>
<%@include file="includes/header.jsp" %>
<div class="container">
    <div class="row">
        <div class="col main-content">
            <h3><fmt:message key="choose-topic"/></h3>
            <jsp:useBean id="topics" scope="request" type="java.util.List"/>
            <ol class="two-columns">
                <c:forEach var="topic" items="${topics}">
                    <li><a href="?command=tests&topic_id=${topic.getId()}">${topic.getTopicName()}</a></li>
                </c:forEach>
            </ol>
        </div>
    </div>
</div>

<%@include file="includes/footer.jsp" %>
</body>
</html>
