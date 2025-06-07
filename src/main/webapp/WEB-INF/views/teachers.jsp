<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/6/4
  Time: 下午5:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>教师列表</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />" />
</head>
<body>
<h2>教师信息列表</h2>
<a href="<c:url value='/teachers/new' />">添加教师</a>
<table border="1">
    <tr>
        <th>ID</th><th>姓名</th><th>工号</th><th>部门</th><th>年龄</th><th>性别</th><th>职称</th><th>邮箱</th><th>入职时间</th><th>操作</th>
    </tr>
    <c:forEach var="teacher" items="${teacherList}">
        <tr>
            <td>${teacher.id}</td>
            <td>${teacher.name}</td>
            <td>${teacher.teacherNo}</td>
            <td>${teacher.department}</td>
            <td>${teacher.age}</td>
            <td>${teacher.gender}</td>
            <td>${teacher.title}</td>
            <td>${teacher.email}</td>
            <td>${teacher.hire_Date}</td>
            <td>
                <a href="<c:url value='/teachers/edit/${teacher.id}' />">编辑</a>
                <a href="<c:url value='/teachers/delete/${teacher.id}' />" onclick="return confirm('确认删除？')">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/index">返回首页</a>
</body>
</html>
