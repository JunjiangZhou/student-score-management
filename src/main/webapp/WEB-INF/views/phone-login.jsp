<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>手机号登录</title>
    <meta charset="UTF-8">
</head>
<body>
<h2>手机号验证码登录</h2>

<!-- 登录表单 -->
<form action="<c:url value='/phone/verify'/>" method="post">
    <label>手机号：<input type="text" name="phone" id="phoneInput"/></label><br/>
    <label>验证码：<input type="text" name="code"/></label><br/>
    <button type="submit">登录</button>
</form>

<!-- 验证码发送按钮 -->
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
            "Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"
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

<!-- 登录失败信息提示 -->
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
<a href="${pageContext.request.contextPath}/index">返回首页</a>
</body>
</html>