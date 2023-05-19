<%--
  Created by IntelliJ IDEA.
  User: TRUNG THIEN
  Date: 5/18/2023
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Từ điển đơn giản</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<body>
<div class="container-fluid">
    <div class="row justify-content-center">
        <div class="col-auto">
            <h1 class="my-5">Từ điển Anh-Việt</h1>
            <div>
                <form action="/dictionary" class="d-flex justify-content-between">
                    <input class="form-control" type="text" name="search" placeholder="Nhập từ cần tra" style="width: 70%">
                    <button type="submit" class="btn btn-info">Dịch</button>
                </form>
            </div>
            <div>
                <h3>${result}</h3>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
