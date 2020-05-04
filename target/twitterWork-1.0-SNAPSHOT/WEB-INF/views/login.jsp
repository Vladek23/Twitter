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
    <table>

        <thead>
        <tr>
            <td colspan="2">
                LOGIN
            </td>
        </tr>
        </thead>
        <tbody>
        <form method="post">
            <tr>
                <td>E-MAIL:</td>
                <td>
                    <input type="text" name="email">
                </td>
            </tr>
            <tr>
                <td>PASSWORD:</td>
                <td>
                    <input type="password" name="password">
                </td>
            </tr>
        </tbody>

        <tfoot>
        <tr>
            <td colspan="2">
                <input type="submit" value="LOG IN">
            </td>
        </tr>
        </form>
        <form method="post">
            <tr>
                <td colspan="2">
                    <input type="text" name="email" value="guest@test.pl" hidden>
                    <input type="password" name="password" value="guest" hidden>
                    <input type="submit" value="log in as a guest">
                </td>
            </tr>
        </form>
        </tfoot>

    </table>

</div>

<%@ include file="footer.jsp"%>

</body>
</html>
