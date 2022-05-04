/*
package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.BookingDAO;
import org.kosta.myproject.model.BookingDAO2;

public class PickTimeController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filmNO = request.getParameter("filmNO");
		request.setAttribute("filmNO", filmNO);
		String day = request.getParameter("bookTime");
		request.setAttribute("MinMax", BookingDAO2.getInstance().timeTableMinMax());
		request.setAttribute("timeList", BookingDAO2.getInstance().findBookTimeByDay(filmNO, day));
		request.setAttribute("url", "film/booking2-form.jsp");
		return "layout.jsp";
	}

}
*/
package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.BookingDAO;

public class PickTimeController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filmNO = request.getParameter("filmNO");
		request.setAttribute("filmNO", filmNO);
		request.setAttribute("MinMax", BookingDAO.getInstance().timeTableMinMax());
		request.setAttribute("timeList", BookingDAO.getInstance().pickBookTime(filmNO));
		request.setAttribute("url", "film/booking-form.jsp");
		return "layout.jsp";
	}

}

