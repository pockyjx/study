package com.study.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.board.db.BoardDAO;
import com.study.board.db.BoardDTO;
import com.study.commons.Action;
import com.study.commons.ActionForward;

public class BoardWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : BoardWriteAction_execute() 실행");
		
		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 전달정보 저장
		BoardDTO dto = new BoardDTO();
		
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setName(request.getParameter("name"));
		dto.setPw(request.getParameter("pw"));
		
		// 글 등록 : insertBoard(dto)
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(dto);
		
		// 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./BoardList.bo");
		forward.setRedirect(true);
		
		return forward;
	}

}
