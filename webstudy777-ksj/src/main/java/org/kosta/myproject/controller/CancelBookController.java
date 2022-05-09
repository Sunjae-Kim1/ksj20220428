package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.BookingDAO;

public class CancelBookController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BookingDAO.getInstance().cancleBook(request.getParameter("bookNo"));
		return "ListController.do";
	}

}
