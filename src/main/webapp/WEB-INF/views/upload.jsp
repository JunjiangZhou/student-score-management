<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/6/7
  Time: 下午3:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>上传文件</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />" />
</head>
<body>
<h2>上传课程资料</h2>
<form action="${pageContext.request.contextPath}/uploadFile" method="post" enctype="multipart/form-data">
    <input type="file" name="file" required />
    <button type="submit">上传</button>
</form>

<c:if test="${not empty fileUrl}">
    <p>上传成功！文件地址：<a href="${fileUrl}" target="_blank">${fileUrl}</a></p>
</c:if>
<c:if test="${not empty error}">
    <p style="color: red">${error}</p>
</c:if>

<a href="${pageContext.request.contextPath}/index">返回首页</a>
</body>
</html>