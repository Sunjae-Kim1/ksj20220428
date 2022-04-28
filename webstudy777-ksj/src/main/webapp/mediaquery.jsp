<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name = "viewport" content = "width = device-width , initial-scale = 1">
<title>CSS Media Query</title>
<style type = "text/css">
	body{
		background-color: coral;
	}
	/*
		부트스트랩 version 3	sm ( 768 이상 ) md ( 992 이상 ) lg ( 1200 이상 )
		부트스트랩 version 4	sm ( 576 이상 ) md ( 768 이상 ) lg ( 992 이상 )
	*/
@media (min-width : 576px) {
		body{
			background-color: steelblue;
		}
}
@media (min-width : 768px) {
		body{
			background-color: violet;
		}
}
@media (min-width : 992px) {
		body{
			background-color: lime;
		}
}
</style>
</head>
<body>



</body>
</html>