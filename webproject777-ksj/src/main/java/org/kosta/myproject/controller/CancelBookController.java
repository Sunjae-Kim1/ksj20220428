package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.BookingDAO;

public class CancelBookController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("filmName", request.getParameter("filmName"));
		request.setAttribute("showTime", request.getParameter("showTime"));
		BookingDAO.getInstance().cancleBook(request.getParameter("bookNo"));
		request.setAttribute("url", "booking/cancelBook.jsp");
		return "layout.jsp";
	}

}
