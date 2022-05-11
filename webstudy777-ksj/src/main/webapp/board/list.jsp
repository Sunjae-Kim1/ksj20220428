<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.table,th,tr{
  margin-left:auto; 
  margin-right:auto;
  width: auto;
  height: auto;
}
</style>
<br>
<br>
<center>
	<h2>현재상영작</h2>
</center>
<br>
<br>


<div align="right">
	<form action="OrderByListController.do">
		<button type="button" name="avgStar"
			onclick="location.href='ListController.do'" class="btn btn-light my-2">평점</button>
		<button type="submit" name="filmName" class="btn btn-secondary my-2">제목</button>
		<button type="submit" name="openDate" class="btn btn-dark my-2">신작</button>
	</form>
</div>

<table class="table table-bordered table-hover boardlist">
	<tbody>
	
	<tr style="background-color: #333333">
		<c:forEach items="${list}" var="fvo">
			
				<td class="card-body">
				<div class="card shadow-sm">
				 <img src="images/${fvo.filmVO.filmNO}.gif" width=300px height=auto>
				 
					<div class="d-flex justify-content-between align-items-center">

						<c:choose>
							<c:when test="${sessionScope.mvo==null}">
								<p class="card-text">${fvo.filmVO.filmName}</p>
							</c:when>
							<c:otherwise>
								<a type="button" class="btn btn-sm btn-outline-dark"
									href="PostDetailController.do?filmNO=${fvo.filmVO.filmNO}"
									class="card-text">상세페이지로</a>
							</c:otherwise>
						</c:choose>
					</div> <small class="text-muted">☆:${fvo.star}</small>
					</div>

				</td>
		
		</c:forEach>
		</tr>
	</tbody>
</table>
<%--
pagination 처리 
${pagination.startPageOfPageGroup}
${pagination.endPageOfPageGroup}
--%>
<ul class="pagination justify-content-center" style="margin: 20px 0">
	<c:if test="${pagination.previousPageGroup }">
		<li class="page-item"><a class="page-link"
			href="ListController.do?pageNo=${pagination.startPageOfPageGroup-1}">Previous</a></li>
	</c:if>
	<c:forEach begin="${pagination.startPageOfPageGroup}"
		end="${pagination.endPageOfPageGroup}" var="page">
		<c:choose>
			<c:when test="${page==pagination.nowPage }">
				<li class="page-item active"><a class="page-link"
					href="ListController.do?pageNo=${page}">${page}</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link"
					href="ListController.do?pageNo=${page}">${page}</a></li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${pagination.nextPageGroup }">
		<li class="page-item"><a class="page-link"
			href="ListController.do?pageNo=${pagination.endPageOfPageGroup+1}">Next</a></li>
	</c:if>
</ul>