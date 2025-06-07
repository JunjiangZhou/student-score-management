<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/6/5
  Time: 下午2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>成绩管理</title></head>
<body>
<h2>成绩管理</h2>
<a href="<c:url value='/grades/new' />">添加成绩</a><br/><br/>
<table>
    <tr>
        <th>ID</th><th>选课ID</th><th>成绩</th><th>等级</th><th>操作</th>
    </tr>
    <c:forEach items="${gradeList}" var="g">
        <tr>
            <td>${g.id}</td>
            <td>${g.enrollmentId}</td>
            <td>${g.score}</td>
            <td>${g.grade}</td>
            <td>
                <a href="<c:url value='/grades/edit/${g.id}' />">编辑</a> |
                <a href="<c:url value='/grades/delete/${g.id}' />" onclick="return confirm('确定删除？')">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="<c:url value='/index' />">返回首页</a>
</body>
</html>
