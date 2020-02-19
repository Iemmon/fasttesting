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
            <form method="post" action="${pageContext.servletContext.contextPath}/">
                <jsp:useBean id="questions" scope="request" type="java.util.List"/>
                <ol>
                    <c:forEach var="question" items="${questions}">
                    <li class="question-item">
                        <span class="question">${question.getQuestion()}</span>
                        <c:forEach var="answer" items="${question.getListOfAnswers()}">
                            <div>
                                <input type="checkbox" name="${answer.getId()}"/> ${answer.getAnswerOption()}
                            </div>
                        </c:forEach>
                    </li>
                    </c:forEach>
                </ol>
                <input type="hidden" value="${param.test_id}" name="test_id"/>
                <input type="submit"/>
                <input type="hidden" name="command" value="result">
            </form>
        </div>
    </div>
</div>

<%@include file="includes/footer.jsp" %>
</body>
</html>
