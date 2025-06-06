<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="<c:url value="/phone/verify"/>" method="post">
    <label>手机号：<input type="text" name="phone"/></label><br/>
    <label>验证码：<input type="text" name="code"/></label><br/>
    <button type="submit">登录</button>
</form>
<input type="text" id="phoneInput" placeholder="手机号"/>
<button type="button" onclick="sendCode()">发送验证码</button>
<p id="sms-status"></p>

<script>
function sendCode() {
    const phone = document.getElementById("phoneInput").value;
    if (!phone) {
        alert("请输入手机号");
        return;
    }

    fetch("<c:url value='/api/sms/send'/>", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: "phone=" + encodeURIComponent(phone)
    })
    .then(response => response.text())
    .then(text => {
        document.getElementById("sms-status").innerText = text;
    })
    .catch(error => {
        document.getElementById("sms-status").innerText = "发送失败";
    });
}
</script>
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
</body>
</html>