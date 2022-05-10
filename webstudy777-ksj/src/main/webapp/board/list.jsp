<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<center><h3>현재상영작</h3></center>
<table class="table table-bordered table-hover boardlist">
	<thead>
		<tr style="background-color: #4dff4d ">
			<th>섬네일</th>
			<th>제  목</th>
			<th>평  점</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="fvo">
		<tr style="background-color: #ffff66 ">
			<td>
			<%--<a href="${pageContext.request.contextPath}/member/find-form.jsp">member find-form</a><br> --%>
			<%-- 
				<c:import url="images.jsp">
				<c:param name="filmNO" value="${fvo.filmVO.filmNO}"/>
				</c:import>
			--%>
			<img src="images/${fvo.filmVO.filmNO}.gif">	
			</td>
			<%-- 
				로그인상태일때만 title에 링크부여, PostDetailController.do?쿼리스트링 으로 pk인 게시물 no가 서버로 전달
			--%>
			<td>
			<c:choose>
				<c:when test="${sessionScope.mvo==null}">
				${fvo.filmVO.filmName}
				</c:when>
				<c:otherwise>				
				<a href="PostDetailController.do?filmNO=${fvo.filmVO.filmNO}">${fvo.filmVO.filmName}</a>
				</c:otherwise>
			</c:choose>
			</td>
			<td>${fvo.star}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<%--
pagination 처리 
${pagination.startPageOfPageGroup}
${pagination.endPageOfPageGroup}
--%>
<ul class="pagination justify-content-center" style="margin:20px 0">
  <c:if test="${pagination.previousPageGroup }">
    <li class="page-item"><a class="page-link" href="ListController.do?pageNo=${pagination.startPageOfPageGroup-1}">Previous</a></li>
  </c:if>
  <c:forEach begin="${pagination.startPageOfPageGroup}" end="${pagination.endPageOfPageGroup}" var="page">
  <c:choose>
  	<c:when test="${page==pagination.nowPage }">
  		  <li class="page-item active"><a class="page-link" href="ListController.do?pageNo=${page}">${page}</a></li>
  	</c:when>
  	  <c:otherwise>
		<li class="page-item"><a class="page-link" href="ListController.do?pageNo=${page}">${page}</a></li>
  </c:otherwise>
  </c:choose>
</c:forEach>  
  <c:if test="${pagination.nextPageGroup }">
    <li class="page-item"><a class="page-link" href="ListController.do?pageNo=${pagination.endPageOfPageGroup+1}">Next</a></li>
  </c:if>
</ul>