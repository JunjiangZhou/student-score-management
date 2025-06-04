<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/6/4
  Time: 下午8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>选课信息管理</title>
</head>
<body>
<h2>课程选课总览</h2>

<table border="1">
    <thead>
    <tr>
        <th>课程名称</th>
        <th>任课教师</th>
        <th>已选人数</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="course" items="${courseList}">
        <tr>
            <td>${course.courseName}</td>
            <td>${course.teacherName}</td>
            <td>${course.enrollmentCount}</td>
            <td>
                <a href="<c:url value='/enrollments/detail/${course.courseId}' />">查看学生</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="<c:url value='/enrollments/new' />">新增选课记录</a>
</body>
</html>
