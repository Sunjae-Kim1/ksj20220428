package org.kosta.myproject.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.myproject.model.FilmDAO;
import org.kosta.myproject.model.FilmVO;
import org.kosta.myproject.model.Pagination;

public class ListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<FilmVO> list = new ArrayList<FilmVO>();
		//클라이언트로부터 페이지번호를 전달받는다. Pagination(dao.getTotalPostCount(),nowPage);
		String pageNo = request.getParameter("pageNo");
		Pagination pagination = null;
		if(pageNo==null) {
			pagination = new Pagination(FilmDAO.getInstance().getTotalPostCount());
		}else {
			pagination=new Pagination(FilmDAO.getInstance().getTotalPostCount(),Integer.parseInt(pageNo));
		}
		//list.jsp에서 페이징처리를 하기위해 Pagination객체를 공유한다.
		list = FilmDAO.getInstance().findPostList(pagination);
		request.setAttribute("pagination", pagination);
		request.setAttribute("list", list);
		request.setAttribute("url", "board/list.jsp");
		return "layout.jsp";
	}

}
