package org.kosta.myproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		ArrayList<String> myboardNoList = new ArrayList<String>();
		MemberVO vo = MemberDAO.getInstance().login(id, password);
		if(vo==null) {
			return "member/login-fail.jsp";
		}else{
			HttpSession session = request.getSession();
			//로그인 유지 기간동안 조회수 재증가 방지를 위해 myboardNoList를 세션에 저장한다.
			session.setAttribute("myboardNoList",myboardNoList);
			session.setAttribute("mvo", vo);
			return "redirect:ListController.do";
		}
	}

}
