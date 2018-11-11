<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<h1>Employees</h1>
<table border="1" cellpadding="5" cellspacing="1">
    <tr>
        <th>Id</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Age</th>
        <th>Email</th>
        <th>Data</th>
        <th>DepartmentId</th>
    </tr>
    <%--@elvariable id="employeeList" type="java.util.List"--%>
    <c:forEach items="${employeeList}" var="item">
    <tr>
        <td>${item.id}</td>
        <td>${item.firstName}</td>
        <td>${item.lastName}</td>
        <td>${item.age}</td>
        <td>${item.mail}</td>
        <td>${item.dateOfCreation}</td>
        <td>${item.departmentId}</td>
    </tr>
    </c:forEach>
</body>
</html>
