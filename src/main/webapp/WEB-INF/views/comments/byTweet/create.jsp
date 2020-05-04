<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@ include file="../../../css/style.css"%>
    </style>
</head>
<body>

<%@ include file="../../header.jsp"%>

<div class="containerMain">
    <form:form method="post" action="/comments/save" modelAttribute="comment">
        <table>
            <thead>
            <tr>
                <td colspan="2">CREATE NEW COMMENT</td>
            </tr>
            </thead>
            <tbody>
            <form:hidden path="id"/>
            <form:input path="tweet.id"/>
                <%--<form:hidden path="created"/>--%>
            <tr>
                <td>USER:</td>
                <td>
                    <form:select path="user.id"
                                 items="${allUsers}"
                                 itemLabel="email"
                                 itemValue="id"
                    />
                </td>
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
                    <input type="submit" value="SAVE >>"/>
                </td>
            </tr>
            </tfoot>
        </table>
    </form:form>
</div>

<%@ include file="../../footer.jsp"%>

</body>
</html>
