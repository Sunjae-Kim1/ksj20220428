<%@page import="javax.websocket.Session"%>
<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">

<title>예매하기</title>


예매 일자: 
<input type="date" min="20${MinMax.get(0)}" max="20${MinMax.get(1)}" 
	id ="bookDay" name="bookDay" onchange="test(this.value)" 
	required="required">
<br><br>
예매 시간 : 
<select id="time" required="required">
	<option>예매일 선택 후 시간을 선택하세요</option>
</select>
<form action="PickSeatController.do" method="post">
<button type="submit" onclick="return seatView()" >좌석 선택하기</button>
</form>
<script type="text/javascript">
	function test(v) {
		var bookTimeList=[];
		var target = document.getElementById("time");
		target.options.length = 0;
		 <c:forEach items="${timeList}" var="t">
		 	var dayTime = "${t}";
		 	var day = dayTime.substr(0,10);
		 	var time = dayTime.substr(day.length+1, 5);
		 	if(day==v){
		 		bookTimeList.push(time);
		 		var opt = document.createElement("option");
		 		opt.value = bookTimeList;
		 		opt.innerHTML = time;
		 		target.appendChild(opt);
		 	}
		 </c:forEach> 
	}
	function seatView(){
		if(document.getElementById("time").length==5)
			return true;
		else{
			alert("예매일시를 선택하세요");
			return false;
		}
	}
	 
</script>
