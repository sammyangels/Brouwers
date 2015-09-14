<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags' %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt' %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang='nl'>
<head><v:head title='Brouwers'/></head>
<body>
<h1>Brouwers</h1>
<h2><fmt:message key="${groet}"/></h2>
<nav>
    <ul id="menu">
        <security:authorize url="/brouwers">
            <li><a href="<c:url value='/brouwers'/>">Alle brouwers</a></li>
        </security:authorize>
        <security:authorize url="/brouwers/beginnaam">
            <li><a href="<c:url value='/brouwers/beginnaam'/>">Brouwers op naam</a></li>
        </security:authorize>
        <security:authorize url="/brouwers/opalfabet">
            <li><a href="<c:url value='/brouwers/opalfabet'/>">Brouwers op alfabet</a></li>
        </security:authorize>
        <security:authorize url="/brouwers/toevoegen">
            <li><a href="<c:url value='/brouwers/toevoegen'/>">Brouwer toevoegen</a></li>
        </security:authorize>
        <security:authorize access="isAnonymous()">
            <li><a href="<c:url value='/login'/>">Aanmelden</a></li>
        </security:authorize>
        <security:authorize access="isAuthenticated()">
            <li><a href="<c:url value='/j_spring_security_logout'/>">Afmelden</a></li>
        </security:authorize>
    </ul>
</nav>
</body>
</html>