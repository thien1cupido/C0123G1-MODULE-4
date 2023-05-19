<%--
  Created by IntelliJ IDEA.
  User: TRUNG THIEN
  Date: 5/18/2023
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyển đổi tiền tệ</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<body>
<div class="my-5">
    <h1 style="justify-content: center;text-align: center">Chuyển đổi tiền tệ</h1>
</div>
<div class="container" >
    <div class="mb-3" >
        <div  class="d-flex justify-content-center" >
            <form action="/currency" style="width: 50%">
                <label class="form-label">Nhập giá tiền (USD)</label>
                <input class="form-control" type="number" name="inputMoney" placeholder="Nhập giá tiền"><br>
                <label class="form-label">Tỉ giá</label>
                <input  class="form-control" type="number" name="exchangeRate" placeholder="Nhập tỉ giá">
                <div class="mt-4" style="display: flex;justify-content: center">
                    <button class="btn btn-success" type="submit">Chuyển đổi</button>
                </div>
            </form>
        </div>
        <div class="mt-3 d-flex justify-content-center">
            <h3 style="color: blue">${result}</h3>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
