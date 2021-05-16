package com.cit.member.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MemberFilter
 */
@WebFilter(urlPatterns= {"/MemberUpdateController.do", "/JoinController.do"})
public class MemberFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Map<String, String> job = new HashMap<String, String>();
		Map<String, String> path = new HashMap<String, String>();
		
		job.put("학생", "student");
		job.put("취준생", "predeveloper");
		job.put("IT 관련 종사자", "developer");
		
		path.put("광고","ads");
		path.put("타 사이트","site");
		path.put("지인 추천","rec");
		
		request.setAttribute("job", job);
		request.setAttribute("path", path);
		chain.doFilter(request, response);
	}

}
