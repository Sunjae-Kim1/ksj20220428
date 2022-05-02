package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.FilmDAO;
import org.kosta.myproject.model.FilmVO;

public class PickFilmController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String filmNo = request.getParameter("filmNo");
		FilmVO fvo = FilmDAO.getInstance().filmDetail(filmNo);
		request.setAttribute("FilmVO", fvo);
		request.setAttribute("url", "film/detail.jsp");
		return "layout.jsp";	
	}

}
