<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form method="post" action="RegisterMemberController.do" onsubmit="return checkForm()">
<input type="hidden" id="flag" value="">
<input type="text" name="id" id="id" placeholder="아이디" required="required">
<button type="button" onclick="checkId()">중복확인</button><br>
<input type="password" name="password" placeholder="패스워드" required="required"><br>
<input type="text" name="name" placeholder="이름" required="required"><br>
<input type="number" name="age" placeholder="나이" required="required"><br>
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
			alert("아이디를 입력하세요")
		}else{
			window.open("CheckIdController.do?id="+mid,"popup","width=200,height=200,top=150,left=500");			
		}
	}
</script>

