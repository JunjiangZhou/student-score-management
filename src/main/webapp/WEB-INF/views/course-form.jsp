<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/6/4
  Time: 下午6:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>课程信息表单</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />" />
</head>
<body>
<h2>${course.id == null ? '添加课程' : '编辑课程'}</h2>
<form action="<c:url value='/courses/save' />" method="post">
    <input type="hidden" name="id" value="${course.id}"/>

    课程编号：<input type="text" name="courseNo" value="${course.courseNo}" required/><br/>
    名称：<input type="text" name="name" value="${course.name}" required/><br/>
    学分：<input type="text" name="credit" value="${course.credit}" required/><br/>
    学期：<input type="text" name="semester" value="${course.semester}" required/><br/>
    所属学院：<input type="text" name="department" value="${course.department}" required/><br/>

    教师：
    <select name="teacherId">
        <c:forEach var="teacher" items="${teacherList}">
            <option value="${teacher.id}" ${teacher.id == course.teacherId ? 'selected' : ''}>${teacher.name}</option>
        </c:forEach>
    </select><br/>

    <button type="submit">保存</button>
    <a href="<c:url value='/courses' />">取消</a>
</form>
</body>
</html>