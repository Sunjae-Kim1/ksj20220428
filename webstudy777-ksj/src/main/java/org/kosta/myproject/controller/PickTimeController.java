package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.TimeTableDAO;

public class PickTimeController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filmNO = request.getParameter("filmNO");
		request.setAttribute("filmNO", filmNO);
		request.setAttribute("MinMax", TimeTableDAO.getInstance().timeTableMinMax());
		request.setAttribute("timeList", TimeTableDAO.getInstance().pickBookTime(filmNO));
		request.setAttribute("url", "booking/pickTime.jsp");
		return "layout.jsp";
	}

}
