<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--상세 게시글 보기 화면 --%>

<input type="hidden" id="idlist" value="${idlist}">

<div class="col-sm-2 offset-sm-10" align="right">
<button type="button" onclick="return bookingage()">예매하기</button>
</div>
<table class="table">
<thead>
<tr>
	<td>제목 : ${fvo.filmName } </td>
	<td>개봉일 : ${fvo.openDate } </td>
	<td>제작년도 :  ${fvo.produceYear }</td>
	<td>감독 : ${fvo.director } </td>	
</tr>
</thead>
<tbody>
<tr>
	<td>
		<c:import url="images.jsp">
		<c:param name="filmNO" value="${fvo.filmNO}"/>
		</c:import>
	</td>
	<td colspan="5">
	<%-- html pre tag : db에 저장된 글 형식 그대로 표현, tip : pre tag 라인은 행 변경 없이 한 라인으로 표현해야한다. --%>
	<pre><font size="4">
	${fvo.content }
	${sessionScope.mvo.age}
	${fvo.ageLimit}
	</font></pre>
	</td>
</tr>
</tbody>
</table>

<%--영화 리뷰 --%>
<table class="table table-bordered table-hover boardlist">
	<thead>
		<tr style="background-color: #4dff4d ">
			<th>평  점</th>
			<th>리  뷰</th>
		</tr>
	</thead>
	<tbody>
<c:forEach items="${list}" var="list">
<tr style="background-color: #ffff66 ">
	<td>	${list.star} </td>
	<td>	${list.review} </td>
</tr>			
</c:forEach>
</tbody>
</table>

<%--댓글 작성 --%>
<label>별점을 평가해 주세요:</label> 
<select id="stars" onchange="return starchange(this.value)"> 
<option value="">평점을 선택해 주세요</option>
<option value="5">★★★★★</option> 
<option value="4">☆★★★★</option> 
<option value="3">☆☆★★★</option> 
<option value="2">☆☆☆★★</option> 
<option value="1">☆☆☆☆★</option> 
</select>

<%--영화 리뷰 작성 --%>
<form method="post" action="WritePostController.do">
<textarea rows="3" class="form-control" name="review" placeholder="영화 리뷰" required="required"></textarea>
		<div class="text-center">
			<button type="submit" class="btn btn-success" onclick="return postreview()">확인</button>
			<button type="reset" class="btn btn-success">취소</button>
			<input type="hidden" name="star" value="">
			<input type="hidden" name="MovieNo" value="${fvo.filmNO}">
		</div>
</form>

<script type="text/javascript">
	var idlist2 = document.getElementById("idlist").value;
	var idlist = idlist2.substring(1,idlist2.length-1);
	idlist = idlist.split(', ');
	var thisid = "<c:out value='${sessionScope.mvo.id}'/>";
	
	function bookingage(){
		if(${sessionScope.mvo.age}<${fvo.ageLimit}){
			window.open("member/checkid-fail.jsp", "나이확인", "width = 500, height = 500, top = 100, left = 200");
		}else{
			var filmNO="PickTimeController.do?filmNO="+${fvo.filmNO}
			location.href=filmNO;
		}
	}
	
	function starchange(star){
		$('input[name=star]').attr('value',star);
	}
	
	function postreview(){
		if(idlist.includes(thisid)){
			alert("이미 리뷰를 작성한 영화입니다.");
			return false;
		}
		<%--
		if(idlist.indexOf(thisid)!=-1){
			alert("이미 리뷰를 작성한 영화입니다.");
			return false;
			idlist.includes(thisid)
		}
		--%>
		var constar = $('input[name=star]').val();
		if(constar==""){
			alert("별점을 추가해 주세요.");
			return false;
		}
	}		
		
		<%--

		
		alert(id1);	
		if(${list.id}==${sessionScope.mvo.id}){
			alert("이미 리뷰를 작성한 영화입니다.");
			return false;
		}
		--%>
		<%--WritePostController.do--%>

</script>