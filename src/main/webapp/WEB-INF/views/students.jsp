<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/5/27
  Time: 下午9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生信息管理</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />" />
</head>
<body>
<h2>学生信息管理</h2>

<a href="<c:url value='students/new' />">添加新学生</a>
<br/><br/>

<table>
    <thead>
    <tr>
        <th>姓名</th>
        <th>学号</th>
        <th>班级</th>
        <th>性别</th>
        <th>邮箱</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>${student.name}</td>
            <td>${student.studentNo}</td>
            <td>${student.className}</td>
            <td>${student.gender}</td>
            <td>${student.email}</td>
            <td>
                <a href="<c:url value='/students/edit/${student.id}' />">编辑</a> |
                <a href="<c:url value='/students/delete/${student.id}' />"
                   onclick="return confirm('确定删除该学生吗？');">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br/>
<a href="<c:url value='/index' />">返回首页</a>
</body>
</html>
