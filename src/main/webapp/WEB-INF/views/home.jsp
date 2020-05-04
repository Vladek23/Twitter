<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TWITTER</title>
    <style>
        <%@ include file="../css/style.css"%>
    </style>
</head>
<body>

<%@ include file="header.jsp"%>

<div class="containerMain">
    <%--FORM FOR NEW TWEET--%>
    <form:form method="post" action="/home" modelAttribute="tweet">
        <table>
            <thead>
            <tr>
                <td colspan="2">NEW TWEET</td>
            </tr>
            </thead>
            <tbody>
            <form:hidden path="id"/>
            <tr>
                <td>
                    <form:textarea cssClass="formTextarea" path="text"/>
                    <br>
                    <form:errors cssClass="error" path="text"/>
                </td>
            </tr>
            <tr>
                <td>
                    <c:choose>
                        <c:when test="${sessionScope.userSession.email == 'guest@test.pl'}">
                            CHOOSE SENDER:<br>
                            <form:select path="user"
                                         items="${allUsers}"
                                         itemLabel="email"
                                         itemValue="id"
                            />
                        </c:when>
                        <c:otherwise>
                            <form:hidden path="user" value="${sessionScope.userSession.id}"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                    <%--<td colspan="2"><form:button value="SAVE"/></td> todo: check if also works--%>
                <td colspan="2"><input type="submit" value="SAVE >>"></td>
            </tr>
            </tfoot>
        </table>
    </form:form>

    <%--LIST OF TWEETS--%>
    <table>
        <thead>
        <tr>
            <td colspan="4">LIST OF TWEETS</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${allTweets}" var="tweet">
            <tr>
                    <%--<td>${tweet.id}</td>--%>
                <td>${tweet.created.toLocalDate()} ${tweet.created.toLocalTime()}</td>
                <td>${tweet.text}</td>
                <td>${tweet.user.firstName} ${tweet.user.lastName}</td>
                <td>
                    <a href="<c:url value="/comments/tweet-${tweet.id}/all"/>">COMMENTS</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot></tfoot>
    </table>
</div>

<%@ include file="footer.jsp"%>

</body>
</html>
