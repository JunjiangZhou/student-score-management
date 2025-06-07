<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/5/26
  Time: 下午4:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<div class="login-container">
    <h2>用户注册</h2>

    <!-- 注册表单 -->
    <form action="${pageContext.request.contextPath}/register" method="post">
        <input type="text" name="username" placeholder="用户名" required />
        <input type="password" name="password" placeholder="密码" required />
        <button type="submit">注册</button>
    </form>

    <!-- 手机注册链接 -->
    <div class="phone-register-link">
        <a href="${pageContext.request.contextPath}/phone/login">手机号注册/登录</a>
    </div>

    <p class="register-link">
        已有账号？<a href="${pageContext.request.contextPath}/login">返回登录</a>
    </p>
</div>
<a href="${pageContext.request.contextPath}/index">返回首页</a>
</body>
</html>
