<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
				<c:choose>
					<c:when test="${param.filmNO==1}">
					<img src="images/닥터.JPG">
					${param.filmNO}
					</c:when>
					<c:when test="${param.filmNO==2}">
					<img src="images/KostaCinemaLogo.png">
					${param.filmNO}
					</c:when>
					<c:when test="${param.filmNO==3}">
					<img src="images/댕댕.gif">
					${param.filmNO}
					</c:when>
				</c:choose>
<%--영화 테이블에 이미지 컬럼 추가 후 경로를 삽입.(VO에 추가변수) --%>

