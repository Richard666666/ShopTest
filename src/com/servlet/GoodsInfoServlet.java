package com.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.service.IGoodsInfoBiz;
import com.service.IGoodsTypeBiz;
import com.service.impl.GoodsInfoBizImpl;
import com.service.impl.GoodsTypeBizImpl;
import com.utils.KeyOptionUtils;
import com.vo.GoodsInfo;
import com.vo.GoodsType;
import com.vo.Page;


/**
 * Servlet implementation class GoodsInfoServlet
 */
public class GoodsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IGoodsInfoBiz goodsInfoBiz = new GoodsInfoBizImpl();
	private IGoodsTypeBiz goodsTypeBiz = new GoodsTypeBizImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action");
		 String currentPageStr  = request.getParameter("currentPage");
		 String idStr = request.getParameter("idStr");
			Integer id = null;
			if(idStr != null){
				id = Integer.valueOf(idStr);
			}
		 
	
		if("getGoodsInfoList".equals(action)) {
			
			Page<GoodsInfo> page=new Page<> ("GoodsInfoServlet?action=getGoodsInfoList&currentPage=",1,goodsInfoBiz.getAllPage(5),5);
			if(currentPageStr !=null) {
				page.setCurrentPage(Integer.valueOf(currentPageStr));
			}
			
				ArrayList<GoodsInfo> goodsInfoList = goodsInfoBiz.getGoodsInfoList(page.getCurrentPage(),page.getCount());

				request.setAttribute("page", page);
			 request.setAttribute("goodsInfoList", goodsInfoList);
			 request.getRequestDispatcher("back/goods/goodsList.jsp").forward(request, response);		 	
			 
		 }else if("initAdd".equals(action)) {
			 ArrayList<GoodsType> goodsTypeList = goodsTypeBiz.getGoodsTypeList();
			 request.setAttribute("goodsTypeList", goodsTypeList);
			request.getRequestDispatcher("back/goods/goodsadd.jsp").forward(request, response);
		 }else if("add".equals(action)) {
			         GoodsInfo goodsInfo = creatGoodsInfo(request);
			        goodsInfoBiz.add(goodsInfo);
			  
				   request.getRequestDispatcher("GoodsInfoServlet?action=getGoodsInfoList").forward(request, response);
				
		 }else if("delete".equals(action)){//删除功能
					
					int result = goodsInfoBiz.delete(id);
					if(result == 1){
						request.getRequestDispatcher("GoodsInfoServlet?action=getGoodsInfoList").forward(request, response);
					}else{
						response.getWriter().println("<script type='text/javascript'>alert('删除失败'); window.location='GoodsInfoServlet?action=getGoodsInfoList'</script>");
					}
				}else if("initUpdate".equals(action)) {//修改初始化
					GoodsInfo goodsInfo = goodsInfoBiz.getGoodsInfobyId(id);
					request.setAttribute("goodsInfo",goodsInfo);
					ArrayList<GoodsType> goodsTypeList = goodsTypeBiz.getGoodsTypeList();
					request.setAttribute("goodsTypeList", goodsTypeList);
					request.getRequestDispatcher("back/goods/goodupdate.jsp").forward(request, response);
					
				}else if("update".equals(action)) {//修改功能
					GoodsInfo goodsInfo = creatGoodsInfo(request);
					
					if(goodsInfo.getGoodsPic()==null) {
					GoodsInfo gi = goodsInfoBiz.getGoodsInfobyId(goodsInfo.getId());		
					goodsInfo.setGoodsPic(gi.getGoodsPic());
				    }
			       int result=goodsInfoBiz.update(goodsInfo);
					if(result==1) {
					request.getRequestDispatcher("GoodsInfoServlet?action=getGoodsInfoList").forward(request, response);
				   }else {
					   
					   response.getWriter().println("<script type='text/javascript'>alert('修改失败');window.location='GoodsInfoServlet?action=getGoodsInfoList'</script>");
				   }
			
				} else if("getGoodsInfobyId".equals(action)){					

					//创建key
					String key = KeyOptionUtils.createKey();
					//把key添加到一次性钥匙对象中
					KeyOptionUtils.addKey(request,key);
					
					GoodsInfo goodsInfo = goodsInfoBiz.getGoodsInfobyId(id);
					request.setAttribute("goodsInfo", goodsInfo);
					request.setAttribute("key", key);
					request.getRequestDispatcher("introduction.jsp").forward(request, response);
				}      
	
	}

	private GoodsInfo creatGoodsInfo(HttpServletRequest request)
			throws UnsupportedEncodingException, FileNotFoundException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		 ServletFileUpload upload = new ServletFileUpload(factory);
		 HashMap<String, Object> map = new HashMap<>();
		 try {
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem fileItem : list) {
				if(fileItem.isFormField()) {
					String name = fileItem.getFieldName();
					String value = fileItem.getString("UTF-8");
					
					map.put(name, value);
				}else {
					String fileName = fileItem.getName();
					if(fileName != null && !"".equals(fileName)) {
						map.put("goodsPic", fileName);
					String path = this.getServletContext().getRealPath("/images");
					FileOutputStream out = new FileOutputStream(path+File.separator+fileName);
					IOUtils.copy(fileItem.getInputStream(), out);
					}
				}
			}
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		 GoodsInfo goodsInfo = new GoodsInfo();
		 try {
			BeanUtils.populate(goodsInfo, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		 return goodsInfo;
	}
	
}
	