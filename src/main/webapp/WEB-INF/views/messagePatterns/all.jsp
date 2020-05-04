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
    <c:forEach items="${messagePatterns}" var="messagePattern">
        <div class="card m-5">
            <div class="card-header">
                    ${messagePattern.id} ${messagePattern.title}
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col">
                            ${messagePattern.text}
                    </div>
                </div>
                <div class="row border-top mt-5 pt-2">
                    <c:forEach items="${messagePattern.messageLabelList}" var="messageLabel">
                        <div class="col border text-center" style="min-width: 150px; max-width: 150px">
                            <span class="rounded-sm">${messageLabel.color}</span>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="card-footer text-right">
                <a href="/messagePatterns/messagePattern/${sessionScope.userSession.id}/download/${messagePattern.id}" class="btn btn-success">DOWNLOAD TO MY PATTERNS</a>
            </div>
        </div>
    </c:forEach>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
