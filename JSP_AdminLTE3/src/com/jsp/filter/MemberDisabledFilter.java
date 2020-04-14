package com.jsp.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;
import com.jsp.utils.ViewResolver;

public class MemberDisabledFilter implements Filter {

	private List<String> checkURLs = new ArrayList<String>();
	
	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		
		//제외할 url 확인
		//들어오는 uri가 고정적이면 Set을 사용한다
		String reqUrl = httpReq.getRequestURI().substring(httpReq.getContextPath().length());
		
		if(excludeCheck(reqUrl)) {
			chain.doFilter(request, response);
			return;
		}
		
		HttpSession session = httpReq.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		// enabled 확인
		if(loginUser.getEnabled() != 1) {	//비활성화 상태
			String url = "commons/disabled";
			ViewResolver.view(httpReq, httpResp, url);
		} else {
			chain.doFilter(request, response);			
		}
	}
	
	private boolean excludeCheck(String url) {
		for(String URL : checkURLs) {
			if(url.contains(URL)) {
				return false;
			}
		}
		return true;
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String excludeURLNames=fConfig.getInitParameter("disabled");
		StringTokenizer st= new StringTokenizer(excludeURLNames,",");
		while(st.hasMoreTokens()){
			String urlKey = st.nextToken();
			checkURLs.add(urlKey);
		}	
	}

}
