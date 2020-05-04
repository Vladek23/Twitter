<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TWITTER</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style>
        <%@ include file="../../css/style.css"%>
    </style>
</head>
<body>

<%@ include file="../header.jsp"%>

<div class="container">
    <div class="containerMain">
        <table>
            <thead>
            <a href="#" class="btn btn-success m-1 disabled">NEW CLEAR MESSAGE</a>
            <a href="/messageUserPattern/${user.id}" class="btn btn-success m-1">NEW MESSAGE FROM PATTERN</a>
            </thead>
            <tbody>
            <tr class="headOfTBody1">
                <%--<td>${user.id}</td>--%>
                <td>MESSAGEBOX</td>
                <td>${user.email}</td>
            </tr>
            <tr class="headOfTBody2">
                <td colspan="2">INBOX</td>
            </tr>
            <c:if test="${empty user.messagesReceived}">
                <tr>
                    <td colspan="2">NO MESSAGES</td>
                </tr>
            </c:if>
            <c:forEach items="${user.messagesReceived}" var="messageReceived">
                <tr>
                    <td>${messageReceived.created.toLocalDate()} ${messageReceived.created.toLocalTime()}</td>
                    <td>FROM: ${messageReceived.userSender.email}</td>
                        <%--<td>read: ${messageReceived.isRead}</td>--%>
                </tr>
                <tr>
                    <td colspan="2" class="messageText">${messageReceived.text}</td>
                </tr>
            </c:forEach>
            <tr class="headOfTBody2">
                <td colspan="2">OUTBOX</td>
            </tr>
            <c:if test="${empty user.messagesSent}">
                <tr>
                    <td colspan="2">NO MESSAGES</td>
                </tr>
            </c:if>
            <c:forEach items="${user.messagesSent}" var="messageSent">
                <tr>
                    <td>${messageSent.created.toLocalDate()} ${messageSent.created.toLocalTime()}</td>
                    <td>TO: ${messageSent.userAddressee.email}</td>
                </tr>
                <tr>
                    <td colspan="2" class="messageText">${messageSent.text}</td>
                </tr>
            </c:forEach>
            </tbody>
            <tfoot></tfoot>
        </table>

    </div>
</div>
<%@ include file="../footer.jsp"%>

</body>
</html>
