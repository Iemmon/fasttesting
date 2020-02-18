<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'en'}"
       scope="session"></c:set>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization"/>
<html>
<head>
    <title>Results</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="row ">
        <div class="col-1 offset-10">
            <form>
                <input type="hidden" name="page" value="${param.page}"/>
                <input type="hidden" name="command" value="${param.command}"/>
                <select id="language" name="language" onchange="submit()">
                    <option value="en" ${language == 'en' ? 'selected' : ''}><fmt:message key="en"/></option>
                    <option value="ru" ${language == 'ru' ? 'selected' : ''}><fmt:message key="ru"/></option>
                </select>
            </form>
        </div>
    </div>
    <table>
        <tr>
            <th><fmt:message key="test-name"/></th>
            <th><fmt:message key="score"/></th>
        </tr>
        <jsp:useBean id="results" scope="request" type="java.util.List"/>
        <c:forEach var="result" items="${results}">
            <tr>
                <td>${result.getId()}</td>
                <td>${result.getTest().getName()}</td>
                <td>${result.getScore()}</td>
            </tr>
        </c:forEach>
    </table>
    <table>
        <tr>
            <c:forEach begin="1" end="${maxPages}" var="i">
                <td><a href="?command=${param.command}&page=${i}&user=${param.user}">${i}</a></td>
            </c:forEach>
        </tr>
    </table>
</div>

</body>
</html>
