<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--  jsp:include or jstl import 대상이 되는 jsp 는 선언부없이 자신의 내용만 정의해야 한다   --%>
<%--  
			현 header.jsp는 layout.jsp 에서 import 하는 대상 , 상단부에 배치될 예정 
			비로그인 상태에서는 로그인 폼을 제공 , 로그인 상태에서는 홈, 글쓰기 , 회원명, 로그아웃 링크를 제공 
 --%>
 <div class ="col-sm-2">
 <a href="MovieListController.do">
			<img src ="images/kostaCinema.png" width="250" height="130">
		</a>
</div>
<div class= "col-sm-8" align="right">
<c:choose>
	<c:when test="${sessionScope.mvo==null}">
		<form method="post" action="LoginController.do">
			<input type="text" name="id" placeholder="아이디" required="required" size="12">
			<input type="password" name="password"placeholder="비밀번호" size="12">
			<button type="submit">로그인</button>
		</form>
		<a href="javascript:register()">회원가입</a>
		<form id="registerForm" method="post" action="registerController.do"></form>
		<script>
		function register() {
				document.getElementById("registerForm").submit();
		}
		</script>
	</c:when>
	<c:otherwise>
		${sessionScope.mvo.name}님 &nbsp;&nbsp;
		<a href="javascript:logout()">로그아웃</a>
		<form id="logoutForm" method="post" action="LogoutController.do"></form>
		
		<script>
			function logout() {
				if(confirm("로그아웃 하시겠습니까?")){
					document.getElementById("logoutForm").submit();
				}
			}
		</script>
	</c:otherwise>
</c:choose>
</div>
















