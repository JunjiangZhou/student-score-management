<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/6/7
  Time: 下午6:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>文件列表</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />">
</head>
<body>
<div class="page-container">
    <h2>上传文件列表</h2>

    <%-- 修复：检查正确的变量名 fileList 而不是 fileUrls --%>
    <c:if test="${empty fileList}">
        <p>当前没有文件。</p>
    </c:if>

    <%-- 修复：只有在有文件时才显示列表 --%>
    <c:if test="${not empty fileList}">
        <ul>
            <c:forEach var="file" items="${fileList}">
                <li>
                    <a href="${file.url}" target="_blank">${file.name}</a>
                </li>
            </c:forEach>
        </ul>
    </c:if>

    <br>
    <a href="<c:url value='/upload' />" class="action-buttons">返回上传页面</a>
</div>
</body>
</html>