<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--상세 게시글 보기 화면 --%>
<style>
.table{
margin-left:auto;
margin-right:auto;
}
}

</style>


<input type="hidden" id="idlist" value="${idlist}">


<div class="col-sm-2 offset-sm-10" align="right">
<button type="button" onclick="return bookingage()" class="btn btn-light btn-outline-success">예매하기</button>
</div>

<table class="table" style="overflow:auto;">
<thead>
<tr bgcolor="#DDDDDD">
	<td>제목 : ${fvo.filmName } </td>
	<td>개봉일 : ${fvo.openDate } </td>
	<td>제작년도 :  ${fvo.produceYear }</td>
	<td>감독 : ${fvo.director } </td>	
</tr>
</thead>
<tbody>
<tr bgcolor="#FFFFFF">
	<td>
		<img src="images/${fvo.filmNO}.gif" width=300px;>
	</td>

	<td colspan="5">
	<%-- html pre tag : db에 저장된 글 형식 그대로 표현, tip : pre tag 라인은 행 변경 없이 한 라인으로 표현해야한다. --%>
	<pre><font size="4">
<span class="box">${fvo.content }</span>
<c:choose>
<c:when test = "${fvo.ageLimit>=18}">
<span style="color:red"><strong>연령제한:${fvo.ageLimit}세 관람가</strong></span>
</c:when>
<c:otherwise>
<span style="color:blue"><strong>연령제한:${fvo.ageLimit}세 관람가</strong></span>
</c:otherwise>
</c:choose>	
	</font></pre>
	</td>
</tr>
</tbody>
</table>
<%--영화 리뷰 --%>
<table class="table table-bordered ">
	<tbody>
<c:forEach items="${list}" var="list">
<tr style="background-color: #EEEEEE ">
	<td width="100" style="border: hidden;">${list.memberVO.id }</td>
	<td width="100" style="border: hidden;">	${list.star} </td>
	<td style="border: hidden;">	${list.review} </td>
	<td width=150 style="border: hidden;">
	<c:choose>
		<c:when test="${list.memberVO.id==sessionScope.mvo.id}">
			<input type="button" value="리뷰 삭제하기" onclick="return deletereview()"class="btn btn-light btn-outline-danger">
		</c:when>
	</c:choose>
	</td>
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
<form method="post" action="WritePostController.do?filmNO=${fvo.filmNO}">
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
			alert("관람연령등급을 확인해주세요");
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
		var constar = $('input[name=star]').val();
		if(constar==""){
			alert("별점을 추가해 주세요.");
			return false;
		}
	}
	
	function deletereview(){
		alert(${fvo.filmNO});
		if (confirm("리뷰를 삭제하시겠습니까?")) {
			location.href="DeleteReviewController.do?filmNO=${fvo.filmNO}";
	    } else {
	        return false;
	    }
	}
</script>