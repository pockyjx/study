package com.study.commons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
		// 상수, 추상메서드만 사용 가능!
		
		/**
		 * execute() 실행할 때 반드시 request, response 필요!
		 * execute()는 실행 결과로 ActionForward(이동 티켓) 생성
		 */
		
		public ActionForward execute(HttpServletRequest request,
									 HttpServletResponse response) throws Exception;
		
		
		

}
