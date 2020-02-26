package com.pop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final String LOGIN = "login";
	
	/*
	 * preHandle : 컨트롤러가 호출 되기 전에 실행 
	 * postHandle : 컨트롤러가 실행 된 후에 실행 
	 * afterComplete : 뷰에서 최종 결과가 생성하는 일을 포함한 모든 일이 완료 되었을 때 실행.
	 */
	
	// login한 후(postHandle)
	@Override
	public void postHandle(HttpServletRequest request, 
						   HttpServletResponse response,
						   Object handler, ModelAndView mv) throws Exception {
		HttpSession session = request.getSession();
		Object UserVO = mv.getModelMap().get("userVO");
		System.out.println("interceptor postHandle="+UserVO);
		
		if(UserVO != null) {	// 사용자가 회원가입을 했으면,
			session.setAttribute(LOGIN, UserVO);	// 로그인 처리(session 회원정보 저장)
			response.sendRedirect("/pop");				//로그인 성공한 후 메인페이지로 이동.
		}
	}
	// login하기 전(preHandle)
	@Override
	public boolean preHandle(HttpServletRequest request, 
							 HttpServletResponse response,
							 Object handler) throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute(LOGIN)!=null) {		// 기존에 로그인이 되어있다면,
			session.removeAttribute(LOGIN);			// 로그아웃.
			
		}
		return true;
	}
}
