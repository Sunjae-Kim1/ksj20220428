<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>film detail</title>
</head>
<body>
상영작 소개<br>
제목 : ${filmName }
감독 : ${derector }
연령제한 : ${ageLimit }
영화 상세 정보 : ${content }
상영일 : ${openDate }
제작연도 : ${produceYear }
</body>
</html>