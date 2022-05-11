<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br>
<br>
<style>
.table{
margin-left:auto;
margin-right:auto;
width:100%;
height:auto;
}
</style>
<table class="table">
<tbody>
<tr bgcolor="#FFFFFF">
<td>
<h3>예매가 취소되었습니다</h3><br><br>
취소된 영화 : ${filmName} <br>
상영일자 : ${showTime} <br>
<td>
</tr>
</tbody>
</table>
<a href="index.jsp" class="btn btn-primary btn-outline">홈으로</a>