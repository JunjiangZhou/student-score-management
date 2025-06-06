<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/6/6
  Time: 下午8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>手机号登录</title></head>
<body>
<form action="/phone/verify" method="post">
    <label>手机号：<input type="text" name="phone"/></label><br/>
    <label>验证码：<input type="text" name="code"/></label><br/>
    <button type="submit">登录</button>
</form>
<form action="/api/sms/send" method="post">
    <input type="text" name="phone" placeholder="手机号"/>
    <button type="submit">发送验证码</button>
</form>
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
</body>
</html>