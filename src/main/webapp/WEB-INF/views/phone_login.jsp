<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>手机号登录</title>
</head>
<body>
<h2>验证码登录</h2>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<form action="${pageContext.request.contextPath}/phone/verify" method="post">
    <input type="text" name="phone" placeholder="手机号" required />
    <input type="text" name="code" placeholder="验证码" required />
    <button type="submit">登录</button>
</form>

<form action="${pageContext.request.contextPath}/api/sms/send" method="post">
    <input type="text" name="phone" placeholder="手机号" required />
    <button type="submit">获取验证码</button>
</form>
</body>
</html>