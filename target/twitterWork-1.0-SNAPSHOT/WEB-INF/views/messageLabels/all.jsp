<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Twitter</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>

<jsp:include page="/WEB-INF/views/header.jsp"/>

<div class="container">
    <div class="card">
        <div class="card-header">
            <h3>MESSAGE LABELES</h3>
        </div>
        <c:forEach items="${messageLabelsAll}" var="messageLabel">
            <div class="card-body">
                <div class="row">
                    <div class="col border-right" style="min-width: 75px; max-width: 75px;">
                            ${messageLabel.id}
                    </div>
                    <div class="col">
                            ${messageLabel.title}
                    </div>
                    <div class="col">
                            ${messageLabel.description}
                    </div>
                    <div class="col border-left" style="min-width: 100px; max-width: 100px;">
                            ${messageLabel.color}
                    </div>
                </div>
            </div>
        </c:forEach>

        <div class="card-footer text-right">
            <a href="<c:url value="/messageLabels/create"/>" class="btn btn-success">
                + NEW MESSAGE LABEL
            </a>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>
