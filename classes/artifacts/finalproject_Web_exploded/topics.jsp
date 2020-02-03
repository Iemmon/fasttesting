<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Topics</title>
</head>
<body>
<jsp:useBean id="topics" scope="request" type="java.util.List"/>
<c:forEach var="topic" items="${topics}">
    <tr>
        <td>${topic.getId()}</td>
        <td><a href="tests?topic_id=${topic.getId()}">${topic.getTopicName()}</a></td><br />
    </tr>
</c:forEach>

</body>
</html>
