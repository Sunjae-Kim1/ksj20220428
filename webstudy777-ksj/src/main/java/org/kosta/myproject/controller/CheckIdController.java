package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.MemberDAO;

public class CheckIdController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean result = true;
		String id = request.getParameter("id");
		result = MemberDAO.getInstance().checkId(id);
		if(result) {
			return "member/checkid-fail.jsp";
		}else {
			return "member/checkid-ok.jsp";
		}
	}
}
