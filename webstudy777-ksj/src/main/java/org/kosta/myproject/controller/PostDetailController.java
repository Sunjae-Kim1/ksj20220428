package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.FilmDAO;
import org.kosta.myproject.model.FilmVO;

public class PostDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FilmVO fvo = new FilmVO();
		String filmNO = request.getParameter("filmNO");
		fvo = FilmDAO.getInstance().findPostByNo(filmNO);
		request.setAttribute("fvo", fvo);
		request.setAttribute("url","board/post-detail.jsp" );
		return "layout.jsp";
	}
}
