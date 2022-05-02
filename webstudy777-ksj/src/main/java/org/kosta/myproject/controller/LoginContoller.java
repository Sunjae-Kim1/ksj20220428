package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class LoginContoller implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		MemberVO vo = MemberDAO.getInstance().login(id, pw);
		String viewName = null;
		if(vo==null) {
			viewName="member/login-fail.jsp";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("memberVO", vo);
			viewName = "redirect:FilmListController.do";
		}
		return viewName;
	}

}
