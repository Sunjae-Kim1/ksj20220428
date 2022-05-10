package org.kosta.myproject.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.BookingVO;
import org.kosta.myproject.model.MemberVO;
import org.kosta.myproject.model.TimeTableDAO;

public class CheckBookingController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		ArrayList<BookingVO> bookList= TimeTableDAO.getInstance().findBookById(mvo);
		System.out.println("책리스트="+bookList);
		
		ArrayList<String> bookTimeList = new ArrayList<String>();
		for(BookingVO vo : bookList) {
			Date dBookTime = vo.getBookTime();
			SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd / HH시 mm분 ss초");
			String bookTime = format.format(dBookTime);
			bookTimeList.add(bookTime);
		}
		
		ArrayList<String> showTimeList = new ArrayList<String>();
		for(int i = 0; i<bookList.size();i++) {
			Date dateshow = bookList.get(i).getTimeTableVO().getShowTime();
			SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd / HH시 mm분");
			String showTime = format.format(dateshow);
			showTimeList.add(showTime);
		}
		request.setAttribute("bookList", bookList);
		request.setAttribute("bookTimeList", bookTimeList);
		request.setAttribute("showTimeList", showTimeList);
		request.setAttribute("url", "booking/checkBook.jsp");
		return "layout.jsp";
	}

}
