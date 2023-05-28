package com.study.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.board.db.BoardDAO;
import com.study.board.db.BoardDTO;
import com.study.commons.Action;
import com.study.commons.ActionForward;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("M : BoardListAction_execute() 실행");
		
		// 전달정보 저장 (검색어 있는 경우)
		String search = request.getParameter("search");
		
		BoardDAO dao = new BoardDAO();
		
		//////////////////////////////////////////페이징 //////////////////////////////////////////////////
		
		// 글 개수 조회
		int count = 0;
		
		if(search == null) { // 검색어 없는 경우
			count = dao.getBoardCount();
		} else { // 검색어 있는 경우
			count = dao.getBoardCount(search);
		}

		// 현 페이지 정보가 몇페이지인지 체크
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		
		// 한 페이지에 보여줄 글의 개수
		int pageSize = 5;

		// 시작행 번호 계산 : 1 11 21 31 ...
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1) * pageSize + 1;

		// 끝행 번호 계산 - 10 20 30 40 ...
		int endRow = currentPage * pageSize;

		int pageCount = count/pageSize + (count%pageSize==0? 0:1);

		// 전체 페이지 수 계산
		// 한 화면에 보여줄 페이지 번호의 개수
		int pageBlock = 5;

		// 시작 페이지 번호 
		int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;

		// 끝 페이지 번호
		int endPage = startPage + pageBlock - 1;
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		////////////////////////////////////////// 페이징 //////////////////////////////////////////////////
		
		
		// 글 목록 생성 : getBoardList()
		List<BoardDTO> boardList = null;
		
		if(search == null) { // 검색어 없을 때
			boardList = dao.getBoardList(startRow, pageSize);
		} else { // 검색어 있을 때
			boardList = dao.getBoardList(search, startRow, pageSize);
		}
		
		
		// request 영역에 저장
		request.setAttribute("search", search);
		request.setAttribute("boardList", boardList);
		request.setAttribute("count", count);

		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		// 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./board/boardList.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
