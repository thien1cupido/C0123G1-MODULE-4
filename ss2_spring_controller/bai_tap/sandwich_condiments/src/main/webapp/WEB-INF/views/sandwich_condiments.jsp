<%--
  Created by IntelliJ IDEA.
  User: TRUNG THIEN
  Date: 5/19/2023
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>App that displays seasoning with sandwich</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<body>
<div class="container-fluid">
<div class="d-flex justify-content-center">
    <div class="col-5 row">
        <h1 class="my-3">Sandwich Condiments</h1>
        <form action="/sandwich" method="post">
            <div class="d-flex justify-content-between" style="font-weight: bold">
                <div>
                    <input type="checkbox" name="spice" value="lettuce"> Lettuce
                </div>
                <div>
                    <input type="checkbox" name="spice" value="tomato"> Tomato
                </div>
                <div>
                    <input type="checkbox" name="spice" value="mustard"> Mustard
                </div>
                <div>
                    <input type="checkbox" name="spice" value="sprouts"> Sprouts
                </div>
            </div>
            <div>
                <hr>
                <button type="submit" class="btn btn-success">Save</button>
            </div>
        </form>
        <div class="col-5">
            <span>The spice your chose:</span>
            <c:forEach var="spice" items="${spiceArray}">
            <span>${spice}</span>
            </c:forEach>
        </div>
    </div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
