package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.BookingDAO;
import org.kosta.myproject.model.FilmDAO;
import org.kosta.myproject.model.MemberVO;
import org.kosta.myproject.model.TimeTableDAO;

public class bookingController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String picktime = request.getParameter("picktime");
		String movieNo = request.getParameter("movieNo");
		String pickseat = request.getParameter("seats1");
		String[] seatArr = pickseat.split(",");
		String id = null;
		System.out.println(picktime);
		System.out.println(movieNo);
		System.out.println(pickseat);
		HttpSession session = request.getSession();
		MemberVO mvo =(MemberVO) session.getAttribute("mvo");
		id = mvo.getId();
		String userName = mvo.getName();
		String picktimeTableNo = null;
		String movieName = null;
		picktimeTableNo = TimeTableDAO.getInstance().findtimeTableNO(movieNo,picktime);
		/*자리 중복 확인하는 함수
		for(int i=0;i<seatArr.length;i++) {
			dupl = BookingDAO.getInstance().duplicateFilm(picktimeTableNo,seatArr[i]);
			if(dupl!=null) {
				JOptionPane.showMessageDialog(null, seatArr[i]+"좌석이 이미 예매되어 있습니다.");
			}
		}//for문 종료
		if(dupl!=null) {
			request.setAttribute("picktime", picktime);
			request.setAttribute("filmNO", movieNo);
			request.setAttribute("url", "booking/pickSeat.jsp");
			return "layout.jsp";	
		}
		*/
		//예매하는 함수
		for(int i=0;i<seatArr.length;i++) {
			BookingDAO.getInstance().booking(picktimeTableNo,id,seatArr[i]);
		}
		//영화이름 확인
		movieName = FilmDAO.getInstance().findPostByNo(movieNo).getFilmName();
		request.setAttribute("picktime", picktime);
		request.setAttribute("movieNo", movieNo);
		request.setAttribute("pickseat", pickseat);
		request.setAttribute("movieName", movieName);
		request.setAttribute("userName", userName);
		request.setAttribute("url", "booking/booking-ok.jsp");
		return "layout.jsp";		
	}

}
