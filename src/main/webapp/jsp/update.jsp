<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<h3>Update department</h3>
<form method="post">
    <%--@elvariable id="department" type="com.shop_kiev.model.Product"--%>
    <input type="hidden" value="${department.id}" name="id"/>
    <label>Name</label><br>
    <label><input name="name" value="${department.name}"/></label><br><br>
    <input type="submit" value="Save"/>
</form>
</body>
</html>