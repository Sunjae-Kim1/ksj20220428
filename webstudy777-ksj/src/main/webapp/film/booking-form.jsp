<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>예매하기</title>
</head>
<body>
<table class="table">
<tr>
<c:forEach items="${timeTableList }" var ="list">
${list}
</c:forEach>
</tr>
</table>