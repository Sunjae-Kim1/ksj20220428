package org.kosta.myproject.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;

public class RegisterMemberController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equals("POST")==false) {
			throw new ServletException("로그인 서비스는 POST방식 요청만 가능합니다.");
		}
		String id =  request.getParameter("id");
		String password =  request.getParameter("password");
		String name =  request.getParameter("name");
		int age =Integer.parseInt(request.getParameter("age")); 
		MemberVO vo = new MemberVO(id,name,age,password);
		MemberDAO.getInstance().register(vo);
		request.setAttribute("url", "member/register-result.jsp");
		return "layout.jsp";
	}

}
