package kr.letech.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.letech.member.model.Member;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(LoginCheckInterceptor.class);
	
	// session에 S_MEM이 없으면 login페이지로 강제 이동
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// session에서 "S_MEM" 꺼내기
		HttpSession session = request.getSession();
		Object member = session.getAttribute("S_MEM");
		
		// 1. session에 member가 없으면 ==> login
		if(member == null) {
			// controller에 login 페이지 요청
			response.sendRedirect(request.getContextPath() + "/login"); 
			return false;
		}
		
		// 2. session에 member가 있으면 ==> 통과
//		saveDestination(request); // 요청한 URI 저장
		return true;
	}
	
	// 컨트롤러 후 실행
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		
//		HttpSession session = request.getSession();
//		Member member = (Member) session.getAttribute("S_MEM");
//		
//		if(member == null) {
//			Object destination = session.getAttribute("destination");
//			logger.info("postHandle: {}", destination);
//			if(destination != null) {
//				response.sendRedirect((String) destination);
//			} else {
//				logger.info("postHandle의 else로 와버림");
//				response.sendRedirect(request.getContextPath() + "/");
//			}
//		}
//	}



	// 페이지 요청 정보 저장
//	private void saveDestination(HttpServletRequest request) {
//		String uri = request.getRequestURI();
//		String query = request.getQueryString();
//		if(query == null || query.equals("null")) {
//			query = "";
//		} else {
//			query = "?" + query;
//		}
//		
//		if(request.getMethod().equals("GET")) {
//			logger.info("request.getMethod(): " + request.getMethod());
//			logger.info("destination: " + uri + query);
//			request.getSession().setAttribute("destination", uri + query);
//		}
//	}
	
}
