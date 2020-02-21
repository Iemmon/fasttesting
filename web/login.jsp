<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}"
       scope="session"></c:set>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title>Login</title>
    <%@include file="includes/resources.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row justify-content-end">
        <div class="col-1">
            <form>
                <input type="hidden" name="command" value="login">
                <select id="language" name="language" onchange="submit()">
                    <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message key="en"/></option>
                    <option value="ru" ${language == 'ru' ? 'selected' : ''}><fmt:message key="ru"/></option>
                </select>
            </form>
        </div>
    </div>

    <c:if test="${has_error != null}">
        <div class="row justify-content-center">
            <div class="col">
                <div class="alert alert-danger" role="alert">
                    <p><fmt:message key="login-error"/></p>
                </div>
            </div>
        </div>
    </c:if>
    <div class="login-form">
        <form method="post" action="${pageContext.servletContext.contextPath}/">
            <input type="hidden" name="command" value="processlogin">

            <h2 class="text-center"><fmt:message key="login"/></h2>
            <div class="row justify-content-center">

                <input class="form-control" type="text" name="email" required
                       pattern="^[a-zA-Z0-9_.-]+@[a-zA-Z0-9]+[\.][a-z]+$" placeholder="<fmt:message key="email"/>"/>

            </div>

            <div class="row justify-content-center">

                <input class="form-control" type="password" name="pass" required
                       placeholder="<fmt:message key="pass"/>"/><br/>

            </div>

            <div class="row justify-content-center">

                <input type="submit" class="btn btn-info" value="<fmt:message key="login"/>"/> <br/>
                <a href="?command=signup"><fmt:message key="register"/></a>

            </div>
        </form>
    </div>
</div>

</body>
</html>
