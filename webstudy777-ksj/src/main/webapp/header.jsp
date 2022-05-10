<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--jsp:include or jstl import 대상이 되는 jsp는 선언부없이 자신의 내용만 정의해야 한다. --%>
<%-- 현 header.jsp 는 layout.jsp에서 import 하는 대상, 상단부에 배치될 예정
 		비로그인 상태에서는 로그인 폼을 제공, 로그인 상태에선는 홈, 글쓰기, 회원명, 로그아웃 링크를 제공
--%>
<header>
  
  
  <div class="navbar navbar-dark bg-dark shadow-sm">
    <div class="container">
      <a href="index.jsp" class="navbar-brand d-flex align-items-center">
        
        <img src="images/KostaCinemaLogo.png" width = 60% height =60%/>
      </a>
      
      <div class=float-left>
      <c:choose>
	<c:when test="${sessionScope.mvo==null}">
		<form method="post" action="LoginController.do">
		<input type="text" name="id" placeholder="아이디" required="required" size="12">
		<input type="password" name="password" placeholder="비밀번호" required="required" size="12">
		<br>
		<button type="submit"  class="btn btn-success my-2">로그인</button>
		</form>
		<a href="RegisterFormController.do" class="btn btn-primary my-2">회원가입</a>
	</c:when>
	
	<c:otherwise>
		<h5 style="color:#FFFFFF">${mvo.name}님 반갑습니다!</h5>
		<a href="javascript:logout()" class="btn btn-danger my-2">로그아웃</a>
		<form id="logoutForm" method="post" action="LogoutController.do"></form>
		<script type="text/javascript">
			function logout(){
				if(confirm("로그아웃 하시겠습니까?")){
					document.getElementById("logoutForm").submit();
				}
			}
		</script>
		<a href="CheckBookingController.do" class="btn btn-warning my-2">예매확인</a>
	</c:otherwise>
</c:choose>
</div>
    </div>
  </div>
</header>