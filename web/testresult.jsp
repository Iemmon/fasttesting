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

            <div class="text-center">
                <h3>Your score is <strong>${score}</strong></h3>
            </div>


            <jsp:useBean id="test_results" scope="request" type="java.util.List"/>
            <jsp:useBean id="ans" scope="request" type="java.util.Set"/>


            <c:if test="${test_results.size() eq 0}" >
                Congratulations, everything is correct!
            </c:if>

            <c:if test="${test_results.size() > 0}" >
                Incorrectly answered questions:

                <ul>
                    <c:forEach var="question" items="${test_results}">
                    <li class="question-item">
                        <span class="question">${question.getQuestion()}</span>

                        <c:forEach var="answer" items="${question.getListOfAnswers()}">

                            <c:choose>

                                <c:when test="${ans.contains(answer.getId()) && !answer.isCorrect()}">
                                    <div style="color: #ff8079"><strong>${answer.getAnswerOption()}</strong></div>
                                </c:when>

                                <c:when test="${ans.contains(answer.getId()) && answer.isCorrect()}">
                                    <div style="color: #3aae39"><strong>${answer.getAnswerOption()}</strong></div>
                                </c:when>

                                <c:when test="${answer.isCorrect()}">
                                    <div style="color: #3aae39">${answer.getAnswerOption()}</div>
                                </c:when>


                                <c:otherwise>
                                    <div>${answer.getAnswerOption()}</div>
                                </c:otherwise>

                            </c:choose>

                        </c:forEach>
                    </li>
                    </c:forEach>
                </ul>

            </c:if>

        </div>
    </div>
</div>

<%@include file="includes/footer.jsp" %>
</body>
</html>
