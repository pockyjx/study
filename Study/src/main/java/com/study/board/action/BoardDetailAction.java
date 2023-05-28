package com.study.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.board.db.BoardDAO;
import com.study.board.db.BoardDTO;
import com.study.commons.Action;
import com.study.commons.ActionForward;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : BoardDetailAction_execute() 실행");
		
		// 전달 정보 저장
		String pageNum = request.getParameter("pageNum");
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// 글 상세 정보 조회
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.getBoardDetail(bno);
		
		// request 영역에 정보 전달
		request.setAttribute("dto", dto);
		request.setAttribute("pageNum", pageNum);

		// 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./board/boardDetail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
