package org.kosta.myproject.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equals("POST")==false)
			throw new ServletException("로그인 서비스는 POST 방식에서만 가능");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		// 일치하면 vo 가 객체 반환 ,아니면 null 반환
		MemberVO vo = MemberDAO.getInstance().login(id , password);
		String ViewName = null;
		if(vo==null) {
			ViewName = "redirect:login-fail.jsp";
		} else {
			ViewName = "redirect:index.jsp";
			HttpSession session = request.getSession();
			session.setAttribute("mvo", vo);
		}
		return ViewName;
	}
}