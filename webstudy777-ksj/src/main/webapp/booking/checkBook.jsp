<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><h4>예매 내역</h4></div>
<br><br>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>예매번호</th>
			<th>영화제목</th>
			<th>상영시간</th>
			<th>좌석 </th>
			<th>예매일시</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="list" items="${bookList}" varStatus="status">
		<tr>
			
				<td>${list.bookNo }</td>
				<td>${list.timeTableVO.filmVO.filmName }</td>
				<td>${showTimeList[status.index] }</td>
				<td>${list.seatNO }</td>
				<td>${bookTimeList[status.index]}</td>
			
		</tr>
		</c:forEach>
	</tbody>
<%-- <td><c:forEach items="${showTimeList}" var="string">
					${string}
				</c:forEach></td> --%>

</table>
</body>
</html>