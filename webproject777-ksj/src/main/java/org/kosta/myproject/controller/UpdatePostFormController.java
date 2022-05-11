package org.kosta.myproject.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.FilmDAO;
import org.kosta.myproject.model.FilmVO;

public class UpdatePostFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request method 확인
		if(request.getMethod().equals("POST")==false) {
			throw new ServletException(getClass().getName()+"POST 방식만 서비스 가능합니다.");
		}
		String no = request.getParameter("no");
		FilmVO fvo = new FilmVO();
		fvo = FilmDAO.getInstance().findPostByNo(no);
		request.setAttribute("fvo",fvo);
		request.setAttribute("url", "board/update.jsp");
		return "layout.jsp";
	}

}
