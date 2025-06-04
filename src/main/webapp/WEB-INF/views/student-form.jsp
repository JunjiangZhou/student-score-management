<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/5/28
  Time: 下午3:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生信息表单</title>
</head>
<body>
<h2>${student.id == null ? '添加学生' : '编辑学生'}</h2>

<form action="<c:url value='/students/save' />" method="post">
    <input type="hidden" name="id" value="${student.id}" />

    学号：<input type="text" name="studentNo" value="${student.studentNo}" required/><br/>
    姓名：<input type="text" name="name" value="${student.name}" required/><br/>
    性别：<input type="text" name="gender" value="${student.gender}" required/><br/>
    年龄：<input type="number" name="age" value="${student.age}" required/><br/>
    班级：<input type="text" name="className" value="${student.className}" required/><br/>
    邮箱：<input type="email" name="email" value="${student.email}" required/><br/>
    <button type="submit">保存</button>
    <a href="<c:url value='/students' />">取消</a>
</form>
</body>
</html>
