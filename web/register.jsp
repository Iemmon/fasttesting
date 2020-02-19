<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}"
       scope="session"></c:set>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title>Register</title>
    <%@include file="includes/resources.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row justify-content-end">
        <div class="col-1">
            <form>
                <select id="language" name="language" onchange="submit()">
                    <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message key="en"/></option>
                    <option value="ru" ${language == 'ru' ? 'selected' : ''}><fmt:message key="ru"/></option>
                </select>
            </form>
        </div>
    </div>

    <c:if test="${error eq true}">
        <div class="row justify-content-end">
            <div class="col-2">
                <p><fmt:message key="pass-doesnt-match"/><br/></p>
            </div>
        </div>
    </c:if>


    <form method="post" action="${pageContext.servletContext.contextPath}/">
        <input type="hidden" name="command" value="processregister">

        <div class="row justify-content-center">
            <div class="col-2">
                <input type="text" name="email" required
                       pattern="^[a-zA-Z0-9_.-]+@[a-zA-Z0-9]+[\.][a-z]+$" placeholder="<fmt:message key="email"/>"/>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-2">
                <input type="password" name="pass" placeholder="<fmt:message key="pass"/>" id="password" required /><br/>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-2">
                <input type="password" name="confpass" placeholder="<fmt:message key="confirm-pass"/>" id="confirm_password" required/><br/>
            </div>
        </div>

        <div class="row justify-content-center">
            <div class="col-2">
                <button type="submit" class="btn btn-info"><fmt:message key="login"/></button>
                <a href="?command=login"><fmt:message key="login"/></a>
            </div>
        </div>

    </form>

</body>
</html>
