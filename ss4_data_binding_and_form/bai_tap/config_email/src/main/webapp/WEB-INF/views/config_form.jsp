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
    <h1>Settings</h1>
    <div>
        <form:form action="/updateConfig" method="post" modelAttribute="configEmail">
            <div class="row">
                <div class="col-2">
                    <h5>Languages: </h5>
                    <h5>Page Size: </h5>
                    <h5>Spams filter:</h5>
                    <h5>Signature:</h5>
                </div>
                <div class="col-3">
                    <form:select path="languages">
                        <form:options items="${language}"/>
                    </form:select> <br>
                    <div class="mt-2">
                        Show <form:select path="pageSize">
                        <form:options items="${pageSizes}"/>
                    </form:select> emails per page
                    </div>
                    <div class=" mt-2">
                        <form:checkbox path="spamsFilter"/> Enable spams filter
                    </div>
                    <form:textarea path="signature" class="mt-2" cols="40" rows="8"/>
                    <div class="d-flex mt-3">
                        <button class="btn btn-info" type="submit">Update</button>
                        <button type="button" class="ms-3 btn btn-light" style="border: black solid 1px">Cancel</button>
                    </div>
                </div>
                <div class="col-7"></div>
            </div>
        </form:form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
