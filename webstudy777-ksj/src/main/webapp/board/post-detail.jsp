<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--상세 게시글 보기 화면 --%>
<div class="col-sm-2 offset-sm-8" align="right">
	<a href="PickTimeController.do?filmNO=${fvo.filmNO }">예매하기</a>
</div>
<br>
<table class="table">
<tr>
	<td>제목 : ${fvo.filmName } </td>
	<td>개봉일 : ${fvo.openDate } </td>
	<td>제작년도 :  ${fvo.produceYear }</td>
	<td>감독 : ${fvo.director } </td>	
</tr>
<tr>
	<td colspan="5">
	<%-- html pre tag : db에 저장된 글 형식 그대로 표현, tip : pre tag 라인은 행 변경 없이 한 라인으로 표현해야한다. --%>
	<pre><font size="4">${fvo.content }</font></pre>
	</td>
</tr>
</table>