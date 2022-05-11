<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--게시글쓰기 작성폼 --%>
	<form method="post" action="UpdatePostController.do">
		<table class="table">
			<tr>
				<td>
				<input type="hidden" name="no" value="${fvo.no}">
				<input type="text" name="title" value="${fvo.title}" required="required">
				</td>
			</tr>
			<tr>
				<td>
				<textarea rows="10" class="form-control" name="content" required="required">${fvo.content }</textarea>
				</td>
			</tr>
		</table>
		<div class="text-center">
			<button type="submit" class="btn btn-success">확인</button>
			<button type="reset" class="btn btn-success">취소</button>
		</div>
	</form>
