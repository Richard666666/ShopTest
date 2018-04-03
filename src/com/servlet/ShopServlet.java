package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.IAddressBiz;
import com.service.IGoodsInfoBiz;
import com.service.IGoodsTypeBiz;
import com.service.IOrderBiz;
import com.service.IOrderDetailBiz;
import com.service.impl.AddressBizImpl;
import com.service.impl.GoodsInfoBizImpl;
import com.service.impl.GoodsTypeBizImpl;
import com.service.impl.OrderBizImpl;
import com.service.impl.OrderDetailBizImpl;
import com.utils.KeyOptionUtils;
import com.utils.ShopCartUtils;
import com.vo.Address;
import com.vo.GoodsInfo;
import com.vo.GoodsType;
import com.vo.Order;
import com.vo.OrderDetail;
import com.vo.ShopCart;
import com.vo.ShopCartItem;
import com.vo.User;


/**
 * Servlet implementation class ShopServlet
 */
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  private IGoodsTypeBiz  goodsTypeBiz=new GoodsTypeBizImpl();
  private IGoodsInfoBiz  goodsInfoBiz=new GoodsInfoBizImpl();
  private IAddressBiz    addressBiz=new AddressBizImpl();
  private IOrderBiz orderBiz = new OrderBizImpl();
  private IOrderDetailBiz orderDetailBiz = new OrderDetailBizImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       String action = request.getParameter("action");
	       String goodsInfoIdStr = request.getParameter("goodsInfoIdStr");
	       String countStr = request.getParameter("countStr");
	       
	       Integer goodsInfoId = null;
			if(goodsInfoIdStr != null){
				goodsInfoId = Integer.valueOf(goodsInfoIdStr);
			}
			
			Integer count= null;
			if(countStr != null){
				count = Integer.valueOf(countStr);
			}
			
	       if("initIndex".equals(action)) {
	    	   
	    	   ArrayList<GoodsType> goodsTypeList = goodsTypeBiz.getGoodsTypeList();
	    	   ArrayList<GoodsInfo> goodsInfoList = goodsInfoBiz.getGoodsInfoList();
	    		request.setAttribute("goodsTypeList", goodsTypeList);
				request.setAttribute("goodsInfoList", goodsInfoList);
				
				request.getRequestDispatcher("index.jsp").forward(request, response);
	       }else if("add".equals(action)){
	    	   GoodsInfo goodsInfo = goodsInfoBiz.getGoodsInfobyId(goodsInfoId);
	    	   ShopCartUtils.add(request, goodsInfo, count);
	    	   request.getRequestDispatcher("GoodsInfoServlet?action=getGoodsInfobyId&idStr="+goodsInfo.getId()).forward(request, response);
	    	   
	    	   
	       }else if("update".equals(action)) {
	    	   GoodsInfo goodsInfo = goodsInfoBiz.getGoodsInfobyId(goodsInfoId);
	    	   ShopCartUtils.add(request, goodsInfo, count);
	    	   request.getRequestDispatcher("shopcat.jsp").forward(request, response);
	       }else if("delete".equals(action)) {
	    	   ShopCartUtils.delete(request, goodsInfoId);
	    	   request.getRequestDispatcher("shopcat.jsp").forward(request, response);
	    	   
	       }else if("pay".equals(action)) {
	    	   User user = (User) request.getSession().getAttribute("user");
	    	  
	    	   if(user!=null) {
	    		   ArrayList<Address> addressList = addressBiz.getAddressList(user.getId());//获取用户地址表
	    		   ShopCart shopCart = (ShopCart) request.getSession().getAttribute("shopCart");
	    		   if(shopCart==null||shopCart.getShopCartItemList().isEmpty())  { //购物车没有商品
	    			   response.getWriter().println("<script type='text/javascript'>alert('购物车没有商品'); window.location='home.jsp'</script>");
	    		   }else {
	    		         request.setAttribute("shopCart", shopCart);
	    		         request.setAttribute("addressList", addressList);
	    		       
	    		   request.getRequestDispatcher("pay.jsp").forward(request, response);
	    		   }
	    	   }else {
	    		   request.getRequestDispatcher("login.jsp").forward(request, response);
	    	   }
	    	   
	    	   
	       }else if("updateAjax".equals(action)) {
	    	   
	    	   GoodsInfo goodsInfo = goodsInfoBiz.getGoodsInfobyId(goodsInfoId);
				ShopCartItem add = ShopCartUtils.add(request, goodsInfo, count);
				
				ShopCart shopCart = ShopCartUtils.getShopCart(request);
				
				//数量、当个商品总金额、购物车总金额,一定是数组格式注意
				String json = "[{count:'"+add.getCount()+"',money:'"+add.getMoney()+"',allMoney:'"+shopCart.getAllMoney()+"'}]";
				response.getWriter().print(json);
       }
	       else if("buynow".equals(action)){//立即支付
			
				String key = request.getParameter("key");
				boolean bool = KeyOptionUtils.isExist(request,key);
				if(bool){
					           //把商品添加到购物车
					GoodsInfo goodsInfo = goodsInfoBiz.getGoodsInfobyId(goodsInfoId);
					ShopCartUtils.add(request, goodsInfo, count);
					         //销毁key
					KeyOptionUtils.deleteKey(request, key);
				}
				//支付
				request.getRequestDispatcher("ShopServlet?action=pay").forward(request, response);
			}else if("submitOrder".equals(action)){//提交订单
				
				           //获取表单的信息
				String shouhuoren = request.getParameter("shouhuoren");
				String phone = request.getParameter("phone");
				String address = request.getParameter("address");
				String express = request.getParameter("express");
				String bank = request.getParameter("bank");
				
				User user = (User) request.getSession().getAttribute("user");
				ShopCart shopCart = (ShopCart) request.getSession().getAttribute("shopCart");
				
				         //1.插入订单表并返回主键
				String oOrderDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				Order order = new Order(null, express, bank, shopCart.getAllMoney(), oOrderDate , user.getId(), shouhuoren, phone, address);
				int orderId = orderBiz.add(order);
		
				
				               //2.插入订单详情表
				ArrayList<ShopCartItem> shopCartItemList = shopCart.getShopCartItemList();
				for (ShopCartItem shopCartItem : shopCartItemList) {
					GoodsInfo goodsInfo = shopCartItem.getGoodsInfo();
					orderDetailBiz.add(new OrderDetail(null, orderId, goodsInfo.getId(), goodsInfo.getGoodsName(), goodsInfo.getGoodsPrice(), goodsInfo.getGoodsDescription(), shopCartItem.getCount(), goodsInfo.getGoodsPic(), shopCartItem.getMoney(), null));
					//修改原有商品的库存（GoodsInfo更新）
				
				}
				   
				//3.跳转到支付成功页面
				request.setAttribute("order", order);
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}
	}
}
