package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PickSeatController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filmNO = null;
		System.out.println(filmNO);
		request.setAttribute("url", "film/booking-seat.jsp");
		return "layout.jsp";
	}

}
