package com.study.board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.commons.Action;
import com.study.commons.ActionForward;

/**
 * 컨트롤러 : 서블릿 구현
 * Model-view 연결동작 처리
 *
 */

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// 페이지 정보 전달방식에 상관없이 한 번에 처리하는 메서드
		System.out.println("doProcess() 호출");
		
		/********************** 1. 가상주소 계산 ***********************/
		
		System.out.println("1. 가상주소 계산 시작!");
		
		String requestURI = request.getRequestURI(); // 프로젝트명/가상주소
		System.out.println("requestURI : " + requestURI);
		
		String ctxPath = request.getContextPath(); // 프로젝트명
		System.out.println("ctxPath : " + ctxPath);
		
		String command = requestURI.substring(ctxPath.length()); // 가상주소만 추출
		System.out.println("command : " + command);
		
		System.out.println("1. 가상주소 계산 끝!");
		
		/********************** 1. 가상주소 계산 ***********************/
		
		/********************** 2. 가상주소 매핑 ***********************/
		
		System.out.println("\n\n");
		System.out.println("2. 가상주소 매핑 시작!");
		
		ActionForward forward = null;
		Action action = null;
		
		
		
		
		System.out.println("2. 가상주소 매핑 끝!");
		System.out.println("\n\n");
		
		/********************** 2. 가상주소 매핑 ***********************/
		
		/********************** 3. 가상주소 이동 ***********************/
	
		System.out.println("3. 가상주소 이동 시작!");
		
		if(forward != null) { // 이동 정보가 있을 때
			
			if(forward.isRedirect()) {
				// 페이지 이동방식 : true
				System.out.println("C : sendRedirect 방식 : " + forward.getPath() + " 이동!");
				response.sendRedirect(forward.getPath());
			} else {
				// 페이지 이동방식 : false
				System.out.println("C : forward 방식 : " + forward.getPath() + " 이동!");
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
			
		} 
		
		System.out.println("3. 가상주소 이동 끝!");
		
		/********************** 3. 가상주소 이동 ***********************/
		
		System.out.println("doProcess 끝! (컨트롤러 종료)");
		
	} // doProcess()
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출");
		doProcess(request, response);
	}
	
	

}

