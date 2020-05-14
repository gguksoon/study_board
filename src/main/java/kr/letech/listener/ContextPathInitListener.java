package kr.letech.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextPathInitListener implements ServletContextListener{

	// application객체가 생성될 때 호출
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		sc.setAttribute("cp", sc.getContextPath());
		
//		sc.setAttribute("S_USERVO_LIST", new ArrayList<User>());
		
//		logger.debug("contextPathInitListener ==> cp: {}", sc.getAttribute("cp"));
	}

	// application객체가 소멸될 때 호출
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
