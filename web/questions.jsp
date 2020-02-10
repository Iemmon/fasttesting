<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Questions</title>
</head>
<body>
<form method="post" action="${pageContext.servletContext.contextPath}/">
    <jsp:useBean id="questions" scope="request" type="java.util.List"/>
    <c:forEach var="question" items="${questions}">
        <table>
            <tr>
                <td>${question.getId()}</td>
                <td>${question.getQuestion()}"</td>
            </tr>
            <c:forEach var="answer" items="${question.getListOfAnswers()}">
                <tr>
                    <td>
                        <input type="checkbox" name="${answer.getId()}"/>
                            ${answer.getAnswerOption()}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:forEach>
    <input type="hidden" value="${param.test_id}" name="test_id"/>
    <input type="submit"/>
    <input type="hidden" name="command" value="result">
</form>
</body>
</html>
