<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>List Department</title>
</head>
<body>
<h1>List Department</h1>
<p><a href='<c:url value="/add"/>'>Add department</a></p>
<table border="1" cellpadding="5" cellspacing="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Update</th>
        <th>Delete</th>
        <th>List Employees</th>
    </tr>
    <%--@elvariable id="departmentList" type="java.util.List"--%>
    <c:forEach items="${departmentList}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td><a href='<c:url value="/update?id=${item.id}"/>'>Update</a></td>
            <td>
                <form method="post" action='<c:url value="/delete" />' style="background-color:red;display:inline;">
                    <input type="hidden" name="id" value="${item.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
