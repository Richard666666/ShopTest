package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.IGoodsTypeBiz;
import com.service.impl.GoodsTypeBizImpl;
import com.vo.GoodsInfo;
import com.vo.GoodsType;
import com.vo.Page;

/**
 * Servlet implementation class GoodsTypeServlet
 */
public class GoodsTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IGoodsTypeBiz goodsTypeBiz = new GoodsTypeBizImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		       String action = request.getParameter("action");
		   	String idStr = request.getParameter("idStr");
			String name = request.getParameter("name");
			String parentIdStr = request.getParameter("parentIdStr");
			 String currentPageStr  = request.getParameter("currentPage");
			Integer parentId = null;
			if(parentIdStr != null){
				parentId = Integer.valueOf(parentIdStr);
			}
			Integer id = null;
			if(idStr != null){
				id = Integer.valueOf(idStr);
			}
		       if("getGoodsTypeList".equals(action)) {//获取商品类别列表
		    	   Page<GoodsType> page=new Page<> ("GoodsTypeServlet?action=getGoodsTypeList&currentPage=",1,goodsTypeBiz.getAllPage(3),3);
					if(currentPageStr !=null) {
						page.setCurrentPage(Integer.valueOf(currentPageStr));
					}
					
						ArrayList<GoodsType> goodsTypeList = goodsTypeBiz.getGoodsTypeList(page.getCurrentPage(),page.getCount());	 
		    	
		    	  request.setAttribute("page", page);
		    	   request.setAttribute("goodsTypeList", goodsTypeList);
		    	   request.getRequestDispatcher("back/goodstype/goodstype.jsp").forward(request, response);	    	   
		       }else if("initAdd".equals(action)) {//初始化添加功能
		    	   ArrayList<GoodsType> goodsTypeParentList = goodsTypeBiz.getGoodsTypeListbyParentId();
					request.setAttribute("goodsTypeParentList", goodsTypeParentList);
					request.getRequestDispatcher("back/goodstype/goodsadd.jsp").forward(request, response);		    	   	    	   
		    	   
		       }else if("add".equals(action)){//添加功能
					int result = goodsTypeBiz.add(new GoodsType(null, name, parentId, null));
					if(result == 1){
						request.getRequestDispatcher("GoodsTypeServlet?action=getGoodsTypeList").forward(request, response);
					}else{
						response.getWriter().println("<script type='text/javascript'>alert('添加失败'); window.location='GoodsTypeServlet?action=initAdd'</script>");
					}
					
		       }else  if("initUpdate".equals(action)) {
		    	 //获取GoodsType对象并存入request中
					GoodsType goodsType = goodsTypeBiz.getGoodsTypebyId(id);
					request.setAttribute("goodsType", goodsType);
					
					//获取所有父类别集合并存入request中
					ArrayList<GoodsType> goodsTypeParentList = goodsTypeBiz.getGoodsTypeListbyParentId();
					request.setAttribute("goodsTypeParentList", goodsTypeParentList);
					
					request.getRequestDispatcher("back/goodstype/goodstypeupdate.jsp").forward(request, response);
						
					}else  if("update".equals(action)) {
						GoodsType goodsType = goodsTypeBiz.getGoodsTypebyId(id);
						goodsType.setGoodsTypeName(name);
						goodsType.setGoodsTypeParentId(parentId);
						
						int result = goodsTypeBiz.update(goodsType);
						if(result == 1){
							request.getRequestDispatcher("GoodsTypeServlet?action=getGoodsTypeList").forward(request, response);
						}else{
//							response.getWriter().println("<script type='text/javascript'>alert('修改失败'); window.location='GoodsTypeServlet?action=initUpdate'</script>");
						    response.getWriter().println("<script type='text/javascript'>alert('修改失败');window.location='GoodsTypeServlet?action=initUpdate'</script>");
						}
					}else if("delete".equals(action)){//删除功能
						
						int result = goodsTypeBiz.delete(id);
						if(result == 1){
							request.getRequestDispatcher("GoodsTypeServlet?action=getGoodsTypeList").forward(request, response);
						}else{
							response.getWriter().println("<script type='text/javascript'>alert('删除失败'); window.location='GoodsTypeServlet?action=getGoodsTypeList'</script>");
						}
					}
		       }
	}

