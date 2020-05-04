<%@ page import="pl.vladek.twitterWorkshop.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<div class="header">
    <div class="loggedUserInfo">
        <p>
            <%--                    <% if (session.getAttribute("userSession") != null) { %>--%>
            <%--                        LOG OUT--%>
            <%--                    <% } else { %>--%>
            <%--                        LOG IN--%>
            <%--                    <% } %>--%>
            <%
                if (session.getAttribute("userSession") != null) {
                    User user = (User) session.getAttribute("userSession");
                    out.print(
                            user.getFirstName()+" "
                                    +user.getLastName()
                                    +" | "
                                    +"<a href='/logout'>LOG OUT</a>"
                    );
                } else {
                    out.print("<a href='/register'>REGISTER</a>");
                }
            %>
        </p>
    </div>
    <p>TWITTER</p>
    <ul class="menuHeader">
        <li>
            <a href="<c:url value="/startTestDB"/>">RUN DATABASE</a>
        </li>
        <li>
            <a href="<c:url value="/home"/>">HOME</a>
        </li>
        <li>
            <a href="<c:url value="/users/all"/>">USERS</a>
        </li>
        <c:if test="${not empty sessionScope.userSession}">
            <li>
                <a href="<c:url value="/messages/messagebox/${sessionScope.userSession.id}"/>">MESSAGE BOX</a>
            </li>
            <li>
                <a href="<c:url value="/messagePatterns/all"/>">MESSAGE PATTERNS</a>
            </li>
            <li>
                <a href="<c:url value="/messageLabels/all"/>">MESSAGE LABELS</a>
            </li>
        </c:if>
    </ul>
</div>
</body>
</html>
