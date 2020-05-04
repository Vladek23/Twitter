<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<jsp:include page="/WEB-INF/views/header.jsp"/>

<div class="container">
    <c:forEach items="${messageUserPatterns}" var="messageUserPattern">
        <div class="card">
            <div class="card-header">
                    ${messageUserPattern.title}
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col"><p>${messageUserPattern.text}</p></div>
                </div>
                <div class="row">
                    <c:forEach items="${messageUserPattern.messageLabelList}" var="messageLabel">
                        <div class="col">${messageLabel.color}</div>
                    </c:forEach>
                </div>
            </div>
            <div class="card-footer text-right">
                <a href="#" class="btn btn-primary disabled">EDIT THIS PATTERN</a>
                <a href="#" class="btn btn-success disabled">CHOOSE TO EDIT AND SEND</a>
            </div>
        </div>

    </c:forEach>

</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>


</body>
</html>
