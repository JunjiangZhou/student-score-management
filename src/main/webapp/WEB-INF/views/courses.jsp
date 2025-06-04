<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/6/4
  Time: 下午6:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>课程管理</title></head>
<body>
<h2>课程信息列表</h2>
<a href="<c:url value='/courses/new' />">添加课程</a>
<table border="1">
    <tr>
        <th>ID</th><th>课程号</th><th>学院</th><th>教师ID</th><th>学期</th><th>名称</th><th>描述</th><th>学分</th><th>学时</th><th>操作</th>
    </tr>
    <c:forEach var="course" items="${courseList}">
        <tr>
            <td>${course.id}</td>
            <td>${course.courseNo}</td>
            <td>${course.department}</td>
            <td>${course.teacherId}</td>
            <td>${course.semester}</td>
            <td>${course.name}</td>
            <td>${course.description}</td>
            <td>${course.credit}</td>
            <td>${course.hours}</td>
            <td>
                <a href="<c:url value='/courses/edit/${course.id}'/>">编辑</a>
                <a href="<c:url value='/courses/delete/${course.id}'/>" onclick="return confirm('确定删除？')">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value='/' />">返回首页</a>
</body>
</html>
