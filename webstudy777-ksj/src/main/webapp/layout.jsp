<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="css/myhome.css">


<title>KOSTA CINEMA</title>
  <link href="/docs/5.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-image: url('images/cinema.jpg')" >

			<c:import url="header.jsp"></c:import>
	<div class="row">
		<div class="col-sm-8 offset-sm-2">
			<c:import url="${requestScope.url}"></c:import>
			<%--각 컨트롤러에서  reqiest에 할당한 url을 이용해서 import한다.--%>
		</div>
	</div><%--메인화면 div 끝 --%>	

<br>
<br>
<c:import url="footer.jsp"></c:import>
</body>
</html>