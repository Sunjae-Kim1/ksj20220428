package org.kosta.myproject.controller;

import javax.servlet.http.HttpSession;
import org.kosta.myproject.model.ReviewDAO;
import org.kosta.myproject.model.ReviewVO;
import org.kosta.myproject.model.FilmDAO;
import org.kosta.myproject.model.FilmVO;
import org.kosta.myproject.model.MemberVO;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class DeleteReviewController implements Controller
{
    public String execute(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        MemberVO vo = (MemberVO)session.getAttribute("mvo");
        String id = vo.getId();
        ReviewDAO.getInstance().DeleteReview(id);
		FilmVO fvo = new FilmVO();
		String filmNO = request.getParameter("filmNO");
		fvo = FilmDAO.getInstance().findPostByNo(filmNO);
		//영화 리뷰 가져오기
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