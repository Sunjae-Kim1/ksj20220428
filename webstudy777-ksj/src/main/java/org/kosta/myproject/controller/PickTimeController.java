package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.BookingDAO;

public class PickTimeController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filmNO = request.getParameter("filmNO");
		request.setAttribute("timeTableList", BookingDAO.getInstance().pickBookTime(filmNO));
		request.setAttribute("url", "film/booking-form.jsp");
		return "layout.jsp";
	}

}
