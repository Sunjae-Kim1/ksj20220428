<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

예매 일자: 
<input type="date" min="20${MinMax.get(0)}" max="20${MinMax.get(1)}" id="bookTime_date" value="" onchange="return test()" required="required">
<br><br>
예매 시간 : 
<select id="time" required="required">
	<option>예매일 선택 후 시간을 선택하세요</option>
</select>
<form id="SeatForm" action="PickSeatController.do" method="post">
	<input type="hidden" name="picktime" value="">
	<input type="hidden" name="movieNo" value="${filmNO}">
	<button type="submit" onclick="return seatView()" >좌석 선택하기</button>
</form>
<script type="text/javascript">
function test(){
	var bookTimeList=[];
	var target = document.getElementById("time");
	target.options.length = 0;
	
	 <c:forEach items="${timeList}" var="t">
	 	var dayTime = "${t}";
	 	var day = dayTime.substr(0,10);
	 	var time = dayTime.substr(day.length+1, 5);
	 	var v = document.getElementById("bookTime_date").value;
	 	if(day==v){
	 		bookTimeList.push(time);
	 		var opt = document.createElement("option");
	 		opt.value = time;
	 		opt.innerHTML = time;
	 		target.appendChild(opt);
	 		}
	 </c:forEach>
		}
/*
function seatView(){
	var day = $('#bookTime_date').val();
	var time = $('#time').val();
	var daytime = day+" "+time;
	$('input[name=picktime]').attr('value',daytime);
	if(time.length==5){
		document.getElementById("SeatForm").submit();
	}else{
		alert(time.length);
		alert("예매일시를 선택하세요");
		return false;
	}
}
 */
	function seatView(){
		var day = document.getElementById("bookTime_date").value;
		var time = document.getElementById("time").value;
		alert(time);
		alert(time.length);
		var daytime = day+" "+time;
		if(time.length==5){
			$('input[name=picktime]').attr('value',daytime);
			return true;
		}else{
			alert("예매일시를 선택하세요");
			return false;
		}
	}
</script>
<%--
$('input[name=picktime]').attr('value',v);
		alert(document.getElementById("time"));
	onchange="return test()" 
		var AllArray = ${timeList};
		var selArray = new Array();
		for(var i=0;i<AllArray.size();i++){
			alert(i);
		}	
			alert("확인");
		<%
		@SuppressWarnings("unchecked")
		ArrayList<String> list = (ArrayList<String>)request.getAttribute("timeList");
		int size = list.size();
		ArrayList<String> slist = new ArrayList<String>();
		String dday =(String) request.getAttribute("bookTime_date");
		for(int i=0;i<size;i++){
			if(list.get(i)==dday){
				 System.out.println(dday);
			}
		}
		%>	
		
 --%>

