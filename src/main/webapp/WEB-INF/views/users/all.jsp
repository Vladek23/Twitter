<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@ include file="../../css/style.css"%>
    </style>
</head>
<body>

<%@ include file="../header.jsp"%>

<div class="containerMain">
    <table>
        <thead></thead>
        <tbody>
        <%--<c:choose>
            <c:when test="${sessionScope.userSession.email == 'guest@test.pl'}">
                <c:forEach items="${allUsersWithMessages}" var="user">
                    <tr class="headOfTBody1">
                        <td>${user.id}</td>
                        <td colspan="2">${user.email}</td>
                    </tr>
                    <tr class="headOfTBody2">
                        <td colspan="3">INBOX</td>
                    </tr>
                    <c:if test="${empty user.messagesReceived}">
                        <tr>
                            <td colspan="3">NO MESSAGES</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${user.messagesReceived}" var="messageReceived">
                        <tr>
                            <td>${messageReceived.created.toLocalDate()} ${messageReceived.created.toLocalTime()}</td>
                            <td>${messageReceived.userSender.email}</td>
                            <td>read: ${messageReceived.isRead}</td>
                        </tr>
                        <tr>
                            <td colspan="3">${messageReceived.text}</td>
                        </tr>
                    </c:forEach>
                    <tr class="headOfTBody2">
                        <td colspan="3">OUTBOX</td>
                    </tr>
                    <c:if test="${empty user.messagesReceived}">
                        <tr>
                            <td colspan="3">NO MESSAGES</td>
                        </tr>
                    </c:if>
                    <c:forEach items="${user.messagesSent}" var="messageSent">
                        <tr>
                            <td>${messageSent.created.toLocalDate()} ${messageSent.created.toLocalTime()}</td>
                            <td colspan="2">${messageSent.userAddressee.email}</td>
                        </tr>
                        <tr>
                            <td colspan="3">${messageSent.text}</td>
                        </tr>
                    </c:forEach>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr class="headOfTBody1">
                    <td>${sessionScope.userSession.id}</td>
                    <td colspan="2">${sessionScope.userSession.email}</td>
                </tr>
                <tr class="headOfTBody2">
                    <td colspan="3">INBOX</td>
                </tr>
                <c:if test="${empty sessionScope.userSession.messagesReceived}">
                    <tr>
                        <td colspan="3">NO MESSAGES</td>
                    </tr>
                </c:if>
                <c:forEach items="${sessionScope.userSession.messagesReceived}" var="messageReceived">
                    <tr>
                        <td>${messageReceived.created.toLocalDate()} ${messageReceived.created.toLocalTime()}</td>
                        <td>${messageReceived.userSender.email}</td>
                        <td>read: ${messageReceived.isRead}</td>
                    </tr>
                    <tr>
                        <td colspan="3">${messageReceived.text}</td>
                    </tr>
                </c:forEach>
                <tr class="headOfTBody2">
                    <td colspan="3">OUTBOX</td>
                </tr>
                <c:if test="${empty sessionScope.userSession.messagesReceived}">
                    <tr>
                        <td colspan="3">NO MESSAGES</td>
                    </tr>
                </c:if>
                <c:forEach items="${sessionScope.userSession.messagesSent}" var="messageSent">
                    <tr>
                        <td>${messageSent.created.toLocalDate()} ${messageSent.created.toLocalTime()}</td>
                        <td colspan="2">${messageSent.userAddressee.email}</td>
                    </tr>
                    <tr>
                        <td colspan="3">${messageSent.text}</td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>--%>
        <%--<c:forEach items="${allUsersWithMessages}" var="user">
            <tr class="headOfTBody1">
                <td>${user.id}</td>
                <td colspan="2">${user.email}</td>
            </tr>
            <tr class="headOfTBody2">
                <td colspan="3">INBOX</td>
            </tr>
            <c:if test="${empty user.messagesReceived}">
                <tr>
                    <td colspan="3">NO MESSAGES</td>
                </tr>
            </c:if>
            <c:forEach items="${user.messagesReceived}" var="messageReceived">
                <tr>
                    <td>${messageReceived.created.toLocalDate()} ${messageReceived.created.toLocalTime()}</td>
                    <td>${messageReceived.userSender.email}</td>
                    <td>read: ${messageReceived.isRead}</td>
                </tr>
                <tr>
                    <td colspan="3">${messageReceived.text}</td>
                </tr>
            </c:forEach>
            <tr class="headOfTBody2">
                <td colspan="3">OUTBOX</td>
            </tr>
            <c:if test="${empty user.messagesReceived}">
                <tr>
                    <td colspan="3">NO MESSAGES</td>
                </tr>
            </c:if>
            <c:forEach items="${user.messagesSent}" var="messageSent">
                <tr>
                    <td>${messageSent.created.toLocalDate()} ${messageSent.created.toLocalTime()}</td>
                    <td colspan="2">${messageSent.userAddressee.email}</td>
                </tr>
                <tr>
                    <td colspan="3">${messageSent.text}</td>
                </tr>
            </c:forEach>
        </c:forEach>--%>

        <c:forEach items="${allUsers}" var="user">
            <tr class="headOfTBody1">
                <td>${user.id}</td>
                <td>${user.firstName} ${user.lastName}</td>
                    <%--                        <td><a href="#">(INFO)</a></td>--%>
                <td><a href="<c:url value="/messages/send/${sessionScope.userSession.id}/${user.id}"/>">SEND MESSAGE</a></td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot></tfoot>
    </table>
</div>

<%@ include file="../footer.jsp"%>

</body>
</html>
