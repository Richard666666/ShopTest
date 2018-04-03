package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.IUserBiz;
import com.service.impl.UserBizImpl;
import com.vo.User;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   private IUserBiz   userBiz= new UserBizImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String action=request.getParameter("action");
	        String name = request.getParameter("name");
	     	String password = request.getParameter("password");
	     	String role = request.getParameter("role");
	     	String sex = request.getParameter("sex");
	     	String idStr = request.getParameter("idStr");
	     	Integer id=null;
	     	if(idStr!=null) {
	     		 id = Integer.valueOf(idStr);
	     	}
	         if("getUserList".equals(action)) {//获取用户列表
	        	 ArrayList<User> userList = userBiz.getUserList();
	        	 request.setAttribute("userList", userList);
	        	 request.getRequestDispatcher("\\back\\user\\userinfo.jsp").forward(request, response);       	 	        	         	 
	        	 
	         }else if("add".equals(action)) {//添加功能
	        	 
	        	 int result= userBiz.add(new User(null, name, password, sex, null, null, role));
	        	 if(result==1) {
	        		 request.getRequestDispatcher("UserServlet?action=getUserList").forward(request, response);
	        	 }else {
	        		 response.getWriter().println("<script type='text/javaScript'>alert('用户已经存在');window.location='back/user/adduser.jsp'</script>");	    	   
	        	 }
	        	 
	        	 
	        	 
	         }else if("initUpdate".equals(action)) {//初始化修改页面
	        	 User user = userBiz.getUserById(id);
	        	 request.setAttribute("user", user);
	        	 request.getRequestDispatcher("back/user/updateuser.jsp").forward(request, response);
	        	 
	         }else if("update".equals(action)) {//修改用户
	        	 User user = userBiz.getUserById(id);
	        	 int result = userBiz.update(new User(id, name, password, sex, user.getPhone(), user.getEmail(),role));
	        	 if(result==1){
	        		 request.getRequestDispatcher("UserServlet?action=getUserList").forward(request, response);
	        	 }else {
	        		 response.getWriter().println("<script type='text/javaScript'>alert('修改失败');window.location='UserServlet?action=getUserList'</script>");	    	   
	        	 }
	         }else if("delete".equals(action)) {//删除用户
	        	 User user = userBiz.getUserById(id);
	        	  int result = userBiz.delete(user.getId());
	        	  if(result==1){
		        		 request.getRequestDispatcher("UserServlet?action=getUserList").forward(request, response);
		        	 }else {
		        		 response.getWriter().println("<script type='text/javaScript'>alert('删除用户失败');window.location='UserServlet?action=getUserList'</script>");	    	   
		        	 }
	         }else if("backLogin".equals(action)) {
	        	 
	        	 User user = userBiz.forLogin(name,password);
	        	 if(user!=null) {
	        		if("是".equals(user.getIsAdmin())) {
	        			request.getSession().setAttribute("user", user);
	        			response.sendRedirect("back/main.jsp");
	        			
	        		}else {
	        			response.getWriter().println("<script type='text/javascript'>alert('没有登录权限');window.location='backLogin.jsp'</script>");
	        		}
	        	 }else {
	        		 response.getWriter().println("<script type='text/javascript'>alert('登录失败');window.location='backLogin.jsp'</script>");
	        	 }
	         }else if("login".equals(action)) {
	        	 
	        	 User user = userBiz.forLogin(name, password);
	        	 if(user!=null) {
	        	 request.getSession().setAttribute("user", user);
	        	 response.sendRedirect("home.jsp");
	        	 }else {
	        		 response.getWriter().println("<script type='text/javascript'>alert('登录失败');window.location='login.jsp'</script>");
	        	 }
	        	 
	        	 
	         }else if("register".equals(action)) {
	        	 User user = userBiz.getUserByName(name);
	        	 if(user==null) {
	        		 
	        	int result	=userBiz.add(new User(null, name, password, null, null, null, "否"));
	        	if(result==1) {
	        		request.getRequestDispatcher("login.jsp").forward(request, response);
	        	}else {
	        		response.getWriter().println("<script type='text/javascript'>alert('注册失败，重新试试');window.location='register.jsp'</script>");
	        	}
	        		 
	        	 }else {
	        		 response.getWriter().println("<script type='text/javascript'>alert('注册失败，用户名已经存在');window.location='register.jsp'</script>");
	        	 }
        		 
        		 
        	 }
	}

}
