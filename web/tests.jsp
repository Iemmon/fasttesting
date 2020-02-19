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

            <h3><fmt:message key="choose-test"/></h3>
            <jsp:useBean id="tests" scope="request" type="java.util.List"/>

            <ol class="two-columns">
                <c:forEach var="test" items="${tests}">
                    <li>
                        <a href="?command=questions&test_id=${test.getId()}">${test.getName()}</a>
                    </li>
                </c:forEach>
            </ol>

            <c:if test="${maxPages > 1}" >
                <ul class="pagination justify-content-center">
                    <c:forEach begin="1" end="${maxPages}" var="i">
                        <li class="page-item"><a class="page-link" href="?command=${param.command}&topic_id=${param.topic_id}&page=${i}">${i}</a></li>
                    </c:forEach>
                </ul>
            </c:if>

        </div>
    </div>
</div>

<%@include file="includes/footer.jsp" %>
</body>
</html>
