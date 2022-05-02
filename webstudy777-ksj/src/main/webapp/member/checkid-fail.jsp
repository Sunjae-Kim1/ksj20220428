<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복</title>
<script type="text/javascript">
	//opener : 현재 팝업창을 띄운 본 창 객체 (register-form)
	opener.document.getElementById("id").value="";
	opener.document.getElementById("id").focus();  doc
	opener.document.getElementById("flag").value=""; //가입폼의 hidden을 공란으로 초기화
	function closeWindow() {
		self.close();
	}
</script>
</head>
<body bgcolor="orange">
${param.id } 아이디는 중복되어 사용 불가<br><br>
<button type="button" onclick="closeWindow()">확인</button>

</body>
</html>