<%--
  Created by IntelliJ IDEA.
  User: TRUNG THIEN
  Date: 5/22/2023
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Config email</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<body>
<div class="container-fluid">
    <div class="d-flex justify-content-center">
        <h1>Settings</h1>
    </div>
    <div class="row">
        <div class="col-12">
            <div class="d-flex justify-content-center">
                <form:form action="/updateConfig" method="post" modelAttribute="configEmail">
                    <div class="d-flex">
                        <p>Languages: </p> <form:select path="languages" class="ms-4">
                        <form:options items="${language}"/>
                    </form:select>
                    </div>
                    <div class="d-flex">
                        <p>Page Size: </p>
                        <div class="ms-4">
                            Show <form:select path="pageSize">
                            <form:options items="${pageSizes}"/>
                        </form:select>
                            <p>emails per page</p>
                        </div>
                    </div>
                    <div class="d-flex">
                        <p>Spams filter:</p> <form:checkbox path="spamsFilter"/>Enable spams filter
                    </div>
                    <div class="d-flex">
                        <p>Signature:</p>
                        <form:textarea path="signature"/>
                    </div>
                    <div class="d-flex">
                        <button class="btn btn-info" type="submit">Update</button>
                        <button>Cancel</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
