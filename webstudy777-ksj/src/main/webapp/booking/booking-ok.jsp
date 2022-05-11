<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<table class="table table-bordered ">
<tbody>
<tr bgcolor="#FFFFFF">
<td>
<h3>예매가 완료되었습니다!</h3>
예매자 : ${userName} <br>
예매영화 : ${movieName} <br>
관람일 : ${picktime} <br>
예매좌석 : ${pickseat} <br>
</td>
</tr>
</tbody>
</table>
<br>

<a href="index.jsp" class="btn btn-success">홈으로</a>