package org.kosta.myproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

/*
	로그인 체크 여부 역할하는 객체
	인증이 필요없는 서비스 컨트롤러 저장
	인증이 필요없는 컨트롤러 외 인증이 필요한 컨트롤러는
	세션 존재 , 세션 내의 인증정보 ( 회원 객체 ) 존재 유무를
	로그인 상태면 true , 비 로그인 시 false 반환
*/
public class CheckLoginInterceptor {
	private static CheckLoginInterceptor instance = new CheckLoginInterceptor(); 
	// 인증이 필요없는 컨트롤러 리스트
	private ArrayList<String> permitAllList = new ArrayList<String>();
	private CheckLoginInterceptor() {
		// 인터셉터가 생성되는 시점에 인증이 필요없는 컨트롤러 명을 저장
		permitAllList.add("CheckIdController");
		permitAllList.add("FindMemberByIdController");
		permitAllList.add("LoginController");
		permitAllList.add("RegisterMemberController");
	} 
	public static CheckLoginInterceptor getInstance(){ 
		return instance;
	}
	/*
		로그인이 필요한 컨트롤러이라도 비 로그인 상태 시 false 반환
		컨트롤러가 실행되어도 문제없으면 true 반환
	*/
	public boolean checkLogin(HttpServletRequest request , String controllerName) {
		boolean result = true;
//		if(permitAllList.contains(controllerName)==false) { // 비 로그인 상태에서 실행되는 컨트롤러가 아니면
//			HttpSession session = request.getSession(false);
//			if(session==null||session.getAttribute("mvo")==null) {
//				System.out.println("***" + controllerName + " 인증이 필요한 서비스이기에 로그인하세요.");
//				result=false;
//			}
//		}
		return result;
	}
}