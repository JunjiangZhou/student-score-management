<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/6/5
  Time: 下午2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>成绩录入</title></head>
<body>
<h2>${grade.id == null ? '添加成绩' : '编辑成绩'}</h2>

<form action="<c:url value='/grades/save' />" method="post">
    <input type="hidden" name="id" value="${grade.id}" />

    选课记录：
    <select name="enrollmentId" required>
        <c:forEach items="${enrollments}" var="e">
            <option value="${e.id}" ${e.id == grade.enrollmentId ? 'selected' : ''}>选课ID ${e.id}</option>
        </c:forEach>
    </select><br/>

    分数：<input type="number" step="0.01" name="score" value="${grade.score}" required /><br/>
    等级：<input type="text" name="grade" value="${grade.grade}" /><br/>

    <button type="submit">保存</button>
    <a href="<c:url value='/grades' />">取消</a>
</form>
</body>
</html>
