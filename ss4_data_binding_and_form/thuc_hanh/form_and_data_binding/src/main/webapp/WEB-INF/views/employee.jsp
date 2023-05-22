<%--
  Created by IntelliJ IDEA.
  User: TRUNG THIEN
  Date: 5/22/2023
  Time: 05:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form:form method="POST" action="addEmployee" modelAttribute="employee">
    <table>
        <tr>
            <td><form:label path="id">Employee ID: </form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Employee's name: </form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="contactNumber">Contact's number: </form:label></td>
            <td><form:input path="contactNumber"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
<div>
    <h3>Info</h3>
    <table>
        <tr>
            <td>Name:</td>
            <td>${name}</td>
        </tr>
        <tr>
            <td>ID:</td>
            <td>${id}</td>
        </tr>
        <tr>
            <td>Contact Number:</td>
            <td>${contactNumber}</td>
        </tr>
    </table>
</div>
</body>
</html>