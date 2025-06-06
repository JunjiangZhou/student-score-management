<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/5/26
  Time: 下午8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<div class="login-container">
    <h2>学生成绩管理系统</h2>

    <!-- 登录失败信息 -->
    <c:if test="${param.error != null}">
        <p class="error" style="color: red;">用户名或密码错误</p>
    </c:if>

    <!-- 退出成功提示 -->
    <c:if test="${param.logout != null}">
        <p class="logout" style="color: green;">您已成功退出</p>
    </c:if>

    <!-- 表单 -->
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="text" name="username" placeholder="用户名" required />
        <input type="password" name="password" placeholder="密码" required />
        <button type="submit">登录</button>
    </form>

    <!-- 注册链接 -->
    <div class="register-link">
        还没有账号？
        <a href="${pageContext.request.contextPath}/register">立即注册</a>
    </div>

    <!-- 手机登录链接 -->
    <div class="phone-login-link">
        <a href="${pageContext.request.contextPath}/phone/login">手机号登录</a>
    </div>
</div>
</body>
</html>
