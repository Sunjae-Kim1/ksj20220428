// 
// Decompiled by Procyon v0.5.36
// 

package org.kosta.myproject.controller;

import javax.servlet.http.HttpSession;
import org.kosta.myproject.model.ReviewDAO;
import org.kosta.myproject.model.MemberVO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class DeleteReviewController implements Controller
{
    public String execute(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        MemberVO vo = (MemberVO)session.getAttribute("mvo");
        String id = vo.getId();
        ReviewDAO.getInstance().DeleteReview(id);
        return "redirect:ListController.do";
    }
}
