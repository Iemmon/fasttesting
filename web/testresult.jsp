<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Result</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<form method="post" action="${pageContext.servletContext.contextPath}/">
    <jsp:useBean id="test_results" scope="request" type="java.util.List"/>
    <jsp:useBean id="ans" scope="request" type="java.util.Set"/>
    <c:choose><c:when test="${test_results.size() > 0}">
        Incorrectly answered questions:
    </c:when>
    </c:choose>
    <c:forEach var="question" items="${test_results}">
        <table>
            <tr>
                <td>${question.getId()}</td>
                <td>${question.getQuestion()}"</td>
            </tr>
            <c:forEach var="answer" items="${question.getListOfAnswers()}">
                <tr>
                    <td>
                        <c:choose>
                        <c:when test="${ans.contains(answer.getId()) eq answer.isCorrect()}">
                            <div style="color: #ff8079">${answer.getAnswerOption()}</div>
                        </c:when>
                        <c:when test="${answer.isCorrect()}">
                            <div style="color: #3aae39">${answer.getAnswerOption()}</div>
                        </c:when>
                        <c:otherwise>
                        <div>
                                ${answer.getAnswerOption()}
                            </c:otherwise>
                            </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:forEach>
<c:choose><c:when test="${test_results.size() eq 0}">
    Congratulations, everything is correct!
</c:when>
</c:choose>
    <p>Your score is ${score} / 100</p>
</form>
</body>
</html>
