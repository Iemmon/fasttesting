<script type="text/javascript">
    function addParameterToURL(param){
        let url = location.href.replace("?language=ru", "").replace("&language=ru", "").replace("?language=en", "").replace("&language=en", "");
        url += (url.split('?')[1] ? '&':'?command=home&') + param;
        return url;
    }

    function changeLang(){
        const lang = document.querySelector("select[name=language]").value;
        window.location.replace(addParameterToURL("language=" + lang));
    }
</script>
<nav class="navbar navbar-light bg-light navbar-expand-lg">
        <span class="navbar-brand h1">
            <a th:href="">superQuizer()</a>
        </span>
    <ul class="navbar-nav mr-auto">

        <c:if test="${sessionScope.currentUser.role eq 'ADMIN'}">
            <li class="nav-item"><a class="nav-link" href="?command=users"><fmt:message key="users"/></a></li>
        </c:if>

        <c:if test="${sessionScope.currentUser.role eq 'STUDENT'}">
            <li class="nav-item"><a class="nav-link" href="?command=topics"><fmt:message key="topics"/></a></li>
        </c:if>

        <c:if test="${sessionScope.currentUser.role eq 'STUDENT'}">
            <li class="nav-item"><a class="nav-link" href="?command=results"><fmt:message key="results"/></a></li>
        </c:if>

        <li class="nav-item"><a class="nav-link" href="?command=logout"><fmt:message key="logout"/></a></li>
    </ul>
    <form class="form-inline">
        <select name="language" onchange="changeLang()">
            <option value=""><fmt:message key="select-lang"/></option>
            <option value="en"><fmt:message key="en"/></option>
            <option value="ru"><fmt:message key="ru"/></option>
        </select>
    </form>
</nav>