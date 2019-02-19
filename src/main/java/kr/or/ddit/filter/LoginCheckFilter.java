package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVo;

@WebFilter("/*")
public class LoginCheckFilter implements Filter {
	// 로그인 필터. implements Filter.
	// doFilter메서드에 로직 작성. webapp - WEB-INF(Web Information) - web.xml(xml : ml(markup
	// language)로 작성한 문서.
	// ** web.xml에서 <servlet> 위에 <filter>를 작성해야함 -> 서블릿 이전에 필터를 거쳐야 하기
	// 때문에.

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		System.out.println("LoginCheckFilter doFilter");
		// 전처리. session에 userVo(LoginServlet에서 정상 로그인 처리 되었을시 저장한 속성)가
		// 있는지 확인(정상적으로 로그인한 상태인지 확인)
		HttpServletRequest hsr = (HttpServletRequest) request;
		HttpServletResponse hsresp = (HttpServletResponse) response;
		
		HttpSession session = hsr.getSession();
		UserVo userVo = (UserVo) session.getAttribute("userVo");
		
		// 1. 정상 로그인 상태이면 -> chain.doFilter 호출
		if(userVo != null)
			chain.doFilter(request, response);
		
		// 2. 로그인 상태가 아니라면 -> 로그인 화면으로 이동 (/login get)
		// *** 모든 페이지에 대해 적용해야 하나?
		// 세션이 필요한 페이지랑 필요 없는 페이지를 구분해야 함.
		// ** login 페이지 화면요청(/login get). session 검증이 필요 없음.
		// ** login 요청 처리(/login post). session 검증이 필요 없음.
		// ** /js/*  하위 모든 파일, /css/* (/img/*) 
		// 그 외의 대다수는 검증이 필요함.
		// ex) localhost/login
		else{
			String uri = hsr.getRequestURI(); // /login ?
			
			// 요청 처리. /js/CookieUtil.js, /js/jsCookie.js ...
			if(uri.equals("/board/login") || uri.endsWith(".js") || uri.endsWith(".css")
					 || uri.startsWith("/img") || uri.endsWith(".jpg") || uri.endsWith(".jpeg")
					 || uri.endsWith(".gif") || uri.endsWith(".png"))
				chain.doFilter(request, response);
			else
				hsresp.sendRedirect("/board/login");
		}
		
		// 후처리.
		
		
	}
	
	
	
	
	
	
    public LoginCheckFilter() {
    	
    }

	public void destroy() {
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
















