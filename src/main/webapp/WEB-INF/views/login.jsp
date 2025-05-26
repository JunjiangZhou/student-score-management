<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/5/26
  Time: 下午4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<div class="login-container">
    <h2>学生成绩管理系统</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="text" name="username" placeholder="用户名" required />
        <input type="password" name="password" placeholder="密码" required />
        <button type="submit">登录</button>
    </form>
    <p class="register-link">
        还没有账号？<a href="${pageContext.request.contextPath}/register">立即注册</a>
    </p>
</div>
</body>
</html>
