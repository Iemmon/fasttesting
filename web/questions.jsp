<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Questions</title>
</head>
<body>
<jsp:useBean id="questions" scope="request" type="java.util.List"/>
<c:forEach var="question" items="${questions}">
    <tr>
        <td>${question.getId()}</td>
        <td>${question.getQuestion()}</td><br />
    </tr>
    <c:forEach var="answer" items="${question.getListOfAnswers()}">
        <tr>
            <td>${answer.getAnswerOption()}</td><br />
        </tr>
    </c:forEach>
</c:forEach>
</body>
</html>
