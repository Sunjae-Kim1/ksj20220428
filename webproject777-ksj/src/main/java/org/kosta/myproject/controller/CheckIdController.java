package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.MemberDAO;

public class CheckIdController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		boolean result = MemberDAO.getInstance().checkId(id);
		if(result) {
			return "member/checkid-fail.jsp";
		}else {
			return "member/checkid-ok.jsp";
		}
	}
}
/*
		String viewName=null;
		String id=request.getParameter("id");
		boolean result=MemberDAO.getInstance().checkId(id);
		if(result)
			viewName="checkid-fail.jsp";
		else
			viewName="checkid-ok.jsp";
		return viewName;
*/