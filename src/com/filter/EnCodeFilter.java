package com.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class EnCodeFilter
 */
public class EnCodeFilter implements Filter {


    public EnCodeFilter() {
    }

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		    request.setCharacterEncoding("UTF-8");
		    response.setContentType("text/html;charset=UTF-8");
		   HttpServletRequest   req= (HttpServletRequest) request;
		   
		   HttpServletResponse  resp=(HttpServletResponse) response; 
		   
		    EnCodeHttpServletRequestWrapper wrapper = new EnCodeHttpServletRequestWrapper(req);
		    	    
				chain.doFilter(wrapper, resp);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

class EnCodeHttpServletRequestWrapper extends  HttpServletRequestWrapper{

	public EnCodeHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	   @Override
	public String getParameter(String name) {
		
		   String value = super.getParameter(name);
		   if(value!=null) {
			   String method = super.getMethod();
			   if("GET".equals(method)) {
				   
				   try {
				value=new String(value.getBytes("ISO-8859-1"),"UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			   }
		   }
		   
		return value;
	}
	
	
	
	
}



