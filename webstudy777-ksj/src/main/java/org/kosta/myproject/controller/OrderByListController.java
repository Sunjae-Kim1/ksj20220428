package org.kosta.myproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.FilmDAO;
import org.kosta.myproject.model.Pagination;
import org.kosta.myproject.model.ReviewVO;

public class OrderByListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		//클라이언트로부터 페이지번호를 전달받는다. Pagination(dao.getTotalPostCount(),nowPage);
		String pageNo = request.getParameter("pageNo");
		Pagination pagination = null;
		if(pageNo==null) {
			pagination = new Pagination(FilmDAO.getInstance().getTotalPostCount());
		}else {
			pagination=new Pagination(FilmDAO.getInstance().getTotalPostCount(),Integer.parseInt(pageNo));
		}
		//list.jsp에서 페이징처리를 하기위해 Pagination객체를 공유한다.
		String filmName = request.getParameter("filmName");
		String openDate = request.getParameter("openDate");
		if(filmName==null) {
			list = FilmDAO.getInstance().orderByOpenDate(pagination);
		}else if(openDate==null) {
			list = FilmDAO.getInstance().orderByFilmName(pagination);
		}
		request.setAttribute("pagination", pagination);
		request.setAttribute("list", list);
		request.setAttribute("url", "board/list.jsp");
		return "layout.jsp";
	}

}
