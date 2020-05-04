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
    <form:form method="post" modelAttribute="user">
        <table>
            <thead>
            <tr>
                <td colspan="2">REGISTRATION FORM</td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>FIRST NAME:</td>
                <td>
                    <form:input path="firstName"/>
                </td>
            </tr>
            <tr>
                <td>LAST NAME:</td>
                <td>
                    <form:input path="lastName"/>
                </td>
            </tr>
            <tr>
                <td>E-MAIL:</td>
                <td>
                    <form:input path="email"/>
                    <form:errors cssClass="error" path="email"/>
                </td>
            </tr>
            <tr>
                <td>PASSWORD:</td>
                <td>
                    <form:password path="password"/>
                </td>
            </tr>
                <%--<tr>
                    <td>CONFIRM PASSWORD:</td>
                    <td>
                        <input type="password"/>
                    </td>
                </tr>--%>
            </tbody>
            <tfoot>
            <tr>
                <td colspan="2">
                    <input type="submit" value="REGISTER >>">
                </td>
            </tr>
            </tfoot>
        </table>
    </form:form>
</div>

<%@ include file="footer.jsp"%>

</body>
</html>
