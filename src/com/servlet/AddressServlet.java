package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.IAddressBiz;
import com.service.impl.AddressBizImpl;
import com.vo.Address;
import com.vo.User;

/**
 * Servlet implementation class AddressServlet
 */
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     IAddressBiz  adressBiz=new AddressBizImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      String action= request.getParameter("action");
		      String shouhuoren = request.getParameter("shouhuoren");
		      String phone = request.getParameter("phone");
		      String address = request.getParameter("address");
		      String idStr = request.getParameter("idStr");
		      Integer id=null;
		      if(idStr!=null) {
		    	   id= Integer.valueOf(idStr);		    	  
		      }
		      
		      
		      
		      
		      if("addAddress".equals(action)) {
		    	
		          User user= (User)request.getSession().getAttribute("user");		    	 
		    	  adressBiz.addAddress(new Address(null, shouhuoren, phone, address, user.getId(), "否"));
		    	  request.getRequestDispatcher("ShopServlet?action=pay").forward(request, response);
		    	  
		      }else if("delete".equals(action)){
		    	    
				    int result=	adressBiz.deleteAddress(id);
				    if(result==1) {
				    	
				    	request.getRequestDispatcher("ShopServlet?action=pay").forward(request, response);
				    }else {
				    	response.getWriter().println("<script type='text/javascript'>alert('删除失败)';window.location='ShopServlet?action=pay'");
				    }
		    	  
		      }else if("initUpdate".equals(action)) {
		    	
		    	  Address address1 = adressBiz.getAddressById(id);
		    	  request.getSession().setAttribute("address1", address1);
		    	 
		    	  request.getRequestDispatcher("updateAddress.jsp").forward(request, response);
		    	  
		    	  
		      }else if("updateAddress".equals(action)) {
		    	  User user= (User)request.getSession().getAttribute("user");
		    	  adressBiz.updateAddress(new Address(id, shouhuoren, phone, address, user.getId(), "否"));
		    	  request.getRequestDispatcher("ShopServlet?action=pay").forward(request, response);
		      }		      
	}    
		      
}
