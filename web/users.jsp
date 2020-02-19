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

            <jsp:useBean id="users" scope="request" type="java.util.List"/>
            <table  class="generic-table">
                <tr>
                    <th><fmt:message key="user-id"/></th>
                    <th><fmt:message key="user-email"/></th>
                    <th>Mark</th>
                    <th>Role</th>
                </tr>

                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.getUserId()}</td>
                        <td><a href="?command=userdetails&user=${user.getUserId()}">${user.getEmail()}</a></td>
                        <td>${user.getAverageMark()}</td>
                        <td>${user.getRole()}</td>
                    </tr>
                </c:forEach>

            </table>

            <c:if test="${maxPages > 1}" >
                <ul class="pagination justify-content-center">
                    <c:forEach begin="1" end="${maxPages}" var="i">
                        <li class="page-item"><a class="page-link" href="?command=${param.command}&page=${i}">${i}</a></li>
                    </c:forEach>
                </ul>
            </c:if>

        </div>
    </div>
</div>

<%@include file="includes/footer.jsp" %>
</body>
</html>
