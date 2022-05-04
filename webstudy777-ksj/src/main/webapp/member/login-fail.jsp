<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login-fail</title>
</head>
<body>
<script type="text/javascript">
	alert("로그인되지 않았습니다. \n 아이디와 패스워드를 확인해 주세요.")
	location.href="ListController.do"
</script>
</body>
</html>