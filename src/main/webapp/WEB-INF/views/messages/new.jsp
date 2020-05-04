<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TWITTER</title>
    <style>
        <%@ include file="../../css/style.css"%>
    </style>
</head>
<body>

<%@ include file="../header.jsp"%>

<div class="containerMain">
    <table>
        <form:form action="/messages/sendMessage" method="post" modelAttribute="message">
            <thead>
            <tr>
                <td colspan="2">
                    NEW MESSAGE
                </td>
            </tr>
            </thead>
            <tbody>
            <form:hidden path="id"/>
            <form:hidden path="userSender" value="${message.userSender.id}"/>
            <form:hidden path="userAddressee" value="${message.userAddressee.id}"/>
            <tr CLASS="headOfTBody1">
                <td>FROM: ${message.userSender.email}</td>
                <td>TO: ${message.userAddressee.email}</td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:textarea cssClass="formTextarea" path="text"/>
                </td>
            </tr>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="2">
                    <input type="submit" value="SEND >>">
                </td>
            </tr>
            </tfoot>
        </form:form>
    </table>
</div>

<%@ include file="../footer.jsp"%>

</body>
</html>
