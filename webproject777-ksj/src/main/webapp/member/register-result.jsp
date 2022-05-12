<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://tistory4.daumcdn.net/tistory/3134841/skin/images/confetti_v2.js"></script>

<style>
	canvas{z-index:10;pointer-events: none;position: fixed;top: 0;transform: scale(1.1);}
</style>

<div class="buttonContainer">
	<button class="canvasBtn" id="startButton"class="btn btn-success btn-outline">눌러보세요</button>	
	<button class="canvasBtn" id="stopButton"class="btn btn-danger btn-outline">폭죽끄기</button>
	
</div>

<canvas id="canvas"></canvas>


<br><br>
<div class="canvasBtn"style="	font-style:italic;font-weight:bold;text-align: center;font: 28px/60px sans-serif;color: #fff;font-style:italic;font-weight:bold;text-align: center;">회원가입을 축하드립니다~!</div>
<br><br>
<center><a href="index.jsp" class="btn btn-primary btn-outline">홈으로</a></center>

<script>
$(document).ready(function(){  
  //티스토리 공감버튼 이벤트
  function reAction(){
  	$("#startButton").trigger("click");
  	setTimeout(function(){
  		$("#stopButton").trigger("click");
  	}, 6000);
  }
      reAction();
  }); 
});
</script>