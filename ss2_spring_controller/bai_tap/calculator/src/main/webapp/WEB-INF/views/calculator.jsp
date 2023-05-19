<%--
  Created by IntelliJ IDEA.
  User: TRUNG THIEN
  Date: 5/19/2023
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        button{
            border-color: #dcdcdc;
            background-color: #f3f3f3;
            border-radius: 2px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="col-6">
        <div class="my-4">
            <h1>Calculator</h1>
        </div>
        <div class="row">
            <form action="/calculate">
                <div>
                    <div>
                        <input required type="number" name="number1" placeholder="Enter number">
                        <input required type="number" name="number2" placeholder="Enter number" class="ms-2">
                    </div>
                </div>
                <div class="mt-3">
                    <button type="submit" name="operation" value="Addition">Addition(+)</button>
                    <button type="submit" class="ms-2" name="operation" value="Subtraction">Subtraction(-)</button>
                    <button type="submit" class="ms-2" name="operation" value="Multiplication">Multiplication(X)</button>
                    <button type="submit" class="ms-2" name="operation" value="Division">Division(/)</button>
                </div>
            </form>
            <div style="font-weight: bold">
                <p>${result}</p>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
