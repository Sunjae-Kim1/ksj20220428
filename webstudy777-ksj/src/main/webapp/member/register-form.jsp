<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form method="post" action="RegisterMemberController.do" onsubmit="return checkForm()">
<input type="hidden" id="flag" value="">
<input type="text" name="id" id="id" placeholder="아이디" required="required">
<button type="button" onclick="checkId()">중복확인</button>
<br>
<input type="password" name="password" placeholder="비밀번호" required="required"><br>
<input type="text" name="name" placeholder="이름" required="required"><br>
<input type="text" name="age" placeholder="나이" required="required"><br>
<%--date type이 placeholder가 적용 안 되므로 포커스가 갈 때 type을 text에서 date로 변경 --%>
<button type="submit">회원가입</button>
</form>
<script type="text/javascript">
	function checkForm() {
		if(document.getElementById("flag").value!=document.getElementById("id").value){
			alert("아이디 중복을 확인하세요");
			return false;
		}
	}
	function checkId() {
		let mid = document.getElementById("id").value;
		if(mid==""){
			alert("아이디를 입력하세요");
		}else{
			window.open("CheckIdController.do?id="+mid,"mypopup","width=300, height=200, top=150, left=500");
		}
	}
</script>

</body>
</html>