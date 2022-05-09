package org.kosta.myproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.BookingDAO;
import org.kosta.myproject.model.TimeTableDAO;

public class PickSeatController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String picktime = request.getParameter("picktime");
		String filmNO = request.getParameter("movieNo");
		//이미 예매된 자리 전송
		ArrayList<String> seatArr = new ArrayList<String>();
		String timetableNo = TimeTableDAO.getInstance().findtimeTableNO(filmNO, picktime);
		seatArr = BookingDAO.getInstance().duplicateFilm(timetableNo);
		request.setAttribute("seatArr", seatArr);
		request.setAttribute("picktime", picktime);
		request.setAttribute("filmNO", filmNO);
		request.setAttribute("url", "booking/pickSeat.jsp");
		return "layout.jsp";
	}
}
