package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vo.User;

/**
 * Servlet Filter implementation class SecurityFilter
 */
public class SecurityFilter implements Filter {

 
    public SecurityFilter() {
    }


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	        HttpServletRequest req=(HttpServletRequest) request;
	        HttpServletResponse resp=(HttpServletResponse) response;
	        String uri = req.getRequestURI();
	       User user = (User) req.getSession().getAttribute("user");
	        if(user!=null) {
	        
		    chain.doFilter(req, resp);
	        }else {
	        	if(!uri.contains("/back/")) {
	        		chain.doFilter(req, resp);
	        	}else {        		
	        		resp.sendRedirect(req.getContextPath()+"/backLogin.jsp");
	        	}
	        	
	        	
	        }
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
