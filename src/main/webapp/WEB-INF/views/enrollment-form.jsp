<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/6/4
  Time: 下午8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>新增选课</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />" />
</head>
<body>
<h2>添加选课记录</h2>

<form action="<c:url value='/enrollments/save' />" method="post">
    学生：
    <select name="studentId" required>
        <c:forEach var="student" items="${students}">
            <option value="${student.id}">${student.name}（${student.studentNo}）</option>
        </c:forEach>
    </select><br/><br/>

    课程：
    <select name="courseId" required>
        <c:forEach var="course" items="${courses}">
            <option value="${course.id}">${course.name}（${course.teacherName}）</option>
        </c:forEach>
    </select><br/><br/>

    <button type="submit">保存</button>
    <a href="<c:url value='/enrollments' />">取消</a>
</form>
</body>
</html>
