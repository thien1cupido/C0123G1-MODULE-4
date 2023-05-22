<%--
  Created by IntelliJ IDEA.
  User: TRUNG THIEN
  Date: 5/22/2023
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Updated config</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<style>
    span{
        margin-left: 5px;

    }
</style>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-6">
            <div class="card">
                <div class="card-body">
                    <div>
                        <h1>Updated Config Email</h1>
                    </div>
                    <div>
                        <div class="d-flex">
                            <h4>Languages:</h4><p>${configEmail.languages}</p>
                        </div>
                        <div class="d-flex">
                            <h4>Page size:</h4><p>${configEmail.pageSize}</p>
                        </div>
                        <div class="d-flex">
                            <h4>Spams filter:</h4><p>${configEmail.spamsFilter}</p>
                        </div>
                        <div class="d-flex">
                            <h4>Signature:</h4><p>${configEmail.signature}</p>
                        </div>
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
