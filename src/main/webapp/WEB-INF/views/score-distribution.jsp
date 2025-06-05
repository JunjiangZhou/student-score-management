<%--
  Created by IntelliJ IDEA.
  User: zhoujunjiang
  Date: 2025/6/5
  Time: 下午3:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>课程成绩分布统计</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css' />" />
</head>
<body>
<div class="page-container">
    <h2>课程成绩分布统计</h2>

    <table>
        <thead>
        <tr>
            <th>课程名</th>
            <th>平均分</th>
            <th>0-59</th>
            <th>60-69</th>
            <th>70-79</th>
            <th>80-89</th>
            <th>90-100</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${distributionList}" var="item">
            <tr>
                <td>${item.courseName}</td>
                <td>${item.averageScore}</td>
                <td>${item.range0to59}</td>
                <td>${item.range60to69}</td>
                <td>${item.range70to79}</td>
                <td>${item.range80to89}</td>
                <td>${item.range90to100}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br/>
    <a href="<c:url value='/index' />">返回首页</a>
</div>
</body>
</html>
