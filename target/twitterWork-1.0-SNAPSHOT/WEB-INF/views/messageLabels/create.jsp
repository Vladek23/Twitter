<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Twitter</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<jsp:include page="/WEB-INF/views/header.jsp"/>

<div class="container">
    <form:form action="/messageLabels/create" method="post" modelAttribute="messageLabel">
        <div class="card">
            <div class="card-header">
                <h3>CREATE NEW MESSAGE LABEL</h3>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col">
                        ID:
                    </div>
                    <div class="col">
                        <form:input path="id" readonly="true"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        TITLE:
                    </div>
                    <div class="col">
                        <form:input path="title"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        DESCRIPTION:
                    </div>
                    <div class="col">
                        <form:textarea path="description"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        COLOR:
                    </div>
                    <div class="col">
                        <form:input path="color"/>
                    </div>
                </div>
            </div>
            <div class="card-footer">
                <input type="submit" class="btn btn-success" value="CREATE"/>
            </div>
        </div>
    </form:form>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>

</body>
</html>