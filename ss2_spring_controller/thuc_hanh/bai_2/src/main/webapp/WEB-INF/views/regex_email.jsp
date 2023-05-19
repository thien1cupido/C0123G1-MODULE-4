<%--
  Created by IntelliJ IDEA.
  User: TRUNG THIEN
  Date: 5/18/2023
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<body>
<div class="row d-flex justify-content-center">
    <div class="col-auto">
        <form action="/validate" method="post">
            <h1>Regex Email</h1>
            <label class="form-label">Email</label>
            <input type="text" name="email" class="form-control" placeholder="Enter email">
            <button type="submit" class="btn btn-primary my-3">Check</button>
            <p>${email} ${result}</p>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
