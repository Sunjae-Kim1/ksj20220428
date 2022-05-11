
package org.kosta.myproject.controller;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.FilmDAO;
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
		ReviewVO vo = new ReviewVO();
		int star =Integer.parseInt(request.getParameter("star"));
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

		String filmNO = request.getParameter("filmNO");
		fvo = FilmDAO.getInstance().findPostByNo(filmNO);
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		ArrayList<String> idlist = new ArrayList<String>();
		list=ReviewDAO.getInstance().findReview(filmNO);
		for(int i=0;i<list.size();i++) {
			idlist.add(list.get(i).getMemberVO().getId());
		}
		request.setAttribute("idlist", idlist);
		request.setAttribute("list", list);
		request.setAttribute("fvo", fvo);
		request.setAttribute("url","board/post-detail.jsp" );
		return "layout.jsp";
	}

}
