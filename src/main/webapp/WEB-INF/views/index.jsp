<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生课程成绩管理系统</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />" />
</head>
<body>
<h1>欢迎使用学生课程成绩管理系统</h1>

<nav>
    <ul>
        <li><a href="<c:url value='/students' />">学生信息管理</a></li>
        <li><a href="<c:url value='/teachers' />">教师信息管理</a></li>
        <li><a href="<c:url value='/courses' />">课程信息管理</a></li>
        <li><a href="<c:url value='/enrollments' />">选课信息管理</a></li>
        <li><a href="<c:url value='/grades' />">成绩管理</a></li>
        <li><a href="<c:url value='/grades/statistics/score-distribution' />">统计与查询</a></li>
        <li><a href="<c:url value='/upload' />">文件上传</a></li>
        <li><a href="${pageContext.request.contextPath}/logout">退出系统</a></li>
    </ul>
</nav>

<p>当前用户：<c:out value="${pageContext.request.userPrincipal.name}" /></p>
</body>
</html>
