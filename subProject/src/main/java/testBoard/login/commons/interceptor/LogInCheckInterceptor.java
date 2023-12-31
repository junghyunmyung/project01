package testBoard.login.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import testBoard.login.commons.session.SessionConst;

public class LogInCheckInterceptor implements HandlerInterceptor{
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String requestURI = request.getRequestURI();
		
		log.info("인증 체크 인터셉터 실행 {}", requestURI);
		
		HttpSession session = request.getSession(false);

		if(session==null 
				|| session.getAttribute(SessionConst.LOGIN_MEMBER)==null 
				|| session.getAttribute(SessionConst.LOGIN_KAKAO)==null 
				|| session.getAttribute(SessionConst.LOGIN_ADMIN)==null) {
			
			log.info("미인증 사용자 요청");
			
			
			response.sendRedirect("/login?redirectURL="+ requestURI);
			
			return false;
		}
	
		return true;
		
	}

 
	
	
}
