<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@ include file="../../../css/style.css"%>
    </style>
</head>
<body>

<%@ include file="../../header.jsp"%>

<div>
    <table>
        <thead>
        <tr>
            <td colspan="3">
                ALL COMMENTS FOR TWEET
            </td>
        </tr>
        </thead>
        <tbody>
        <tr class="headOfTBody1">
            <td>${tweet.created.toLocalDate()} ${tweet.created.toLocalTime()}</td>
            <td colspan="2">${tweet.user.firstName} ${tweet.user.lastName}</td>
        </tr>
        <tr class="headOfTBody2">
            <td colspan="3">${tweet.text}</td>
        </tr>
        <c:forEach items="${comments}" var="comment">
            <tr>
                <td>${comment.created.toLocalDate()} ${comment.created.toLocalTime()}</td>
                <td>${comment.text}</td>
                <td>${comment.user.firstName} ${comment.user.lastName}</td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="3">
                <a href="/comments/tweet-${tweet.id}/create">+ ADD COMMENT</a>
            </td>
        </tr>
        </tfoot>
    </table>
</div>

<%@ include file="../../footer.jsp"%>

</body>

</html>
