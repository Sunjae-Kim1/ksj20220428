<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매확인</title>
</head>
<body>
<div><h4>예매 내역</h4></div>
<div align="right"><a href="ListController.do">홈으로</a></div>
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
				<td>${list.seatNo }</td>
				<td>${bookTimeList[status.index]}
				<form action="CancelBookController.do" method="post">
					<input type="hidden" name="bookNo" value="${list.bookNo}">
					<button type="submit" onclick="return confirmCancelBook()"class="btn btn-danger my-2">취소하기</button>
				</form>
				</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<script type="text/javascript">
	function confirmCancelBook(){
		return confirm("예매된 내역을 취소하시겠습니까?");
	}
</script>

</body>
</html>