<%--
  Created by IntelliJ IDEA.
  User: TRUNG THIEN
  Date: 5/22/2023
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Updated config</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="col-6 ">
        <div class="card">
            <div class="card-body">
                <h1>Updated Config Email</h1>
                <div class="row">
                    <div class="col-3">
                        <h5>Languages:</h5>
                        <h5>Page size:</h5>
                        <h5>Spams filter:</h5>
                        <h5>Signature:</h5>
                    </div>
                    <div class="col-2">
                        <p class="mb-2">${configEmail.languages}</p>
                        <p class="mb-2">${configEmail.pageSize}</p>
                        <c:if test="${configEmail.spamsFilter}">
                        <p class="mb-2">Yes</p>
                        </c:if>
                        <c:if test="${configEmail.spamsFilter==false}">
                            <p class="mb-2">No</p>
                        </c:if>
                        <p class="m-0">${configEmail.signature}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
