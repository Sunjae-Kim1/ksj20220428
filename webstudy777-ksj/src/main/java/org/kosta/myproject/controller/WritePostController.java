package org.kosta.myproject.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.FilmVO;
import org.kosta.myproject.model.MemberVO;
import org.kosta.myproject.model.ReviewDAO;
import org.kosta.myproject.model.ReviewVO;

public class WritePostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equals("POST")==false) {
			throw new ServletException(getClass().getName()+"POST 방식만 서비스 가능합니다.");
		}
		/*write.jsp 에서 전송한 title과 content를 받아온 뒤 세션에 저장된 MemberVO를 받아온다
		 * 이를 이용해 PostVO를 생성 후 BoardDAO의 posting 메서드를 이용해 DB에 등록한다.
		 * 게시판 리스트 화면으로 응답한다.
		 */
		ReviewVO vo = new ReviewVO();
		int star =Integer.parseInt(request.getParameter("star"));
		System.out.println("hello"+star);
		String review = request.getParameter("review");
		vo.setReview(review);
		vo.setStar(star);
		FilmVO fvo = new FilmVO();
		fvo.setFilmNO(Integer.parseInt(request.getParameter("MovieNo")));
		vo.setFilmVO(fvo);
		MemberVO mvo =new MemberVO();
		HttpSession session = request.getSession(false);
		mvo =(MemberVO) session.getAttribute("mvo");
		vo.setMemberVO(mvo);
		ReviewDAO.getInstance().posting(vo);
		return "redirect:ListController.do";
	}

}
