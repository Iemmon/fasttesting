<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Result</title>
</head>
<body>
<form method="post" action="testresult">
    <jsp:useBean id="test_results" scope="request" type="java.util.List"/>
    <jsp:useBean id="ans" scope="request" type="java.util.Set"/>
    <c:forEach var="question" items="${test_results}">
        <table>
            <tr>
                <td>${question.getId()}</td>
                <td>${question.getQuestion()}"</td>
            </tr>
            <c:forEach var="answer" items="${question.getListOfAnswers()}">
                <tr>
                    <td>
                            ${answer.getAnswerOption()} <br>
                            Question answer: ${answer.isCorrect()}
                            User choice: ${ans.contains(answer.getId())}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:forEach>
    <p>Score: ${score}</p>
</form>
</body>
</html>
