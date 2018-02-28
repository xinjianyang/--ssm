<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/28 0028
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello world</h1>
<div><c:if test="${not empty message}">${message}</c:if></div>
<form method="post">
    <input type="text" name="username" placeholder="请输入用户名:">
    <input type="password" placeholder="请输入密码:" name="password">
    <button>登录</button>
</form>
</body>
</html>
