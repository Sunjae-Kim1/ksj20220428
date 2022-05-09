package org.kosta.myproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.FilmDAO;
import org.kosta.myproject.model.FilmVO;
import org.kosta.myproject.model.ReviewDAO;
import org.kosta.myproject.model.ReviewVO;

public class PostDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//영화 내용 가져오기
				FilmVO fvo = new FilmVO();
				String filmNO = request.getParameter("filmNO");
				fvo = FilmDAO.getInstance().findPostByNo(filmNO);
				//영화 리뷰 가져오기
				ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
				list=ReviewDAO.getInstance().findReview(filmNO);
				request.setAttribute("list", list);
				request.setAttribute("fvo", fvo);
				request.setAttribute("url","board/post-detail.jsp" );
				return "layout.jsp";
	}

}
