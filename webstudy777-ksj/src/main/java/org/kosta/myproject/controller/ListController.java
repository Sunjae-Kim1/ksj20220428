package org.kosta.myproject.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

// import org.kosta.myproject.model.BoardDAO;
// import org.kosta.myproject.model.Pagination;

public class ListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 클라이언트로부터 페이지 번호를 전달받는다.
		String pageNo = request.getParameter("pageNo");
		
		/*
		 * Pagination pagination = null; if(pageNo==null) { // 클라이언트가 pageNo 를 전달하지 않는
		 * 경우 1 번째 페이지를 보여준다. pagination = new
		 * Pagination(BoardDAO.getInstance().getTotalPostCount()); }else { pagination =
		 * new Pagination(BoardDAO.getInstance().getTotalPostCount(),
		 * Integer.parseInt(pageNo)); }
		 */
		
		// list.jsp 에서 페이징 처리를 위해 Pagination 객체 공유
		/*
		 * request.setAttribute("pagination", pagination); request.setAttribute("list",
		 * BoardDAO.getInstance().findPostList(pagination));
		 */
		
		request.setAttribute("url", "board/list.jsp");
		return "layout.jsp";
	}

}
