<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/6/4
  Time: 下午5:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>教师信息表单</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />" />
</head>
<body>
<h2>${teacher.id == null ? '添加教师' : '编辑教师'}</h2>

<form action="<c:url value='/teachers/save' />" method="post">
    <input type="hidden" name="id" value="${teacher.id}" />

    姓名：<input type="text" name="name" value="${teacher.name}" required/><br/>
    工号：<input type="text" name="teacherNo" value="${teacher.teacherNo}" required/><br/>
    部门：<input type="text" name="department" value="${teacher.department}" required/><br/>
    年龄：<input type="number" name="age" value="${teacher.age}" required/><br/>
    性别：<input type="text" name="gender" value="${teacher.gender}" required/><br/>
    职称：<input type="text" name="title" value="${teacher.title}" required/><br/>
    邮箱：<input type="email" name="email" value="${teacher.email}" required/><br/>
    入职时间：<input type="date" name="hire_Date" value="${teacher.hire_Date}" required/><br/>

    <button type="submit">保存</button>
    <a href="<c:url value='/teachers' />">取消</a>
</form>
</body>
</html>
