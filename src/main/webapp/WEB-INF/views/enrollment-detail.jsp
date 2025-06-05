<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/6/4
  Time: 下午8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>课程详情</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />" />
</head>
<body>
<h2>已选学生列表（${courseName}）</h2>

<table border="1">
    <thead>
    <tr>
        <th>学号</th>
        <th>姓名</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>${student.studentNo}</td>
            <td>${student.studentName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="<c:url value='/enrollments' />">返回课程列表</a>
</body>
</html>
