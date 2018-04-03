package com.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.vo.GoodsInfo;
import com.vo.ShopCart;
import com.vo.ShopCartItem;



public class ShopCartUtils {
	public static ShopCartItem add(HttpServletRequest request,GoodsInfo goodsInfo,Integer count){
		
		ShopCartItem item = null;
		
		boolean bool = false;
		ShopCart shopCart = getShopCart(request);
		ArrayList<ShopCartItem> shopCartItemList = shopCart.getShopCartItemList();

		for (ShopCartItem shopCartItem : shopCartItemList) {
			if(shopCartItem.getGoodsInfo().getId().equals(goodsInfo.getId())){
				bool = true;
				//判断是否超出库存
				if((shopCartItem.getCount()+count)>goodsInfo.getGoodsStock()){
					shopCartItem.setCount(goodsInfo.getGoodsStock());
					shopCartItem.setMoney(getMoney(shopCartItem));
					
					item = shopCartItem;
				}else{
					shopCartItem.setCount(shopCartItem.getCount()+count);
					shopCartItem.setMoney(getMoney(shopCartItem));
					
					item = shopCartItem;
				}
			}
		}

		if(!bool){//第一次添加此商品
			ShopCartItem shopCartItem = new ShopCartItem(goodsInfo, count);
			shopCartItem.setMoney(getMoney(shopCartItem));
			shopCartItemList.add(shopCartItem);
			
			item = shopCartItem;
		}

		request.getSession().setAttribute("shopCart", shopCart);
		getAllMoney(request);

		return item;
	}

	
	public static void getAllMoney(HttpServletRequest request) {
		
		BigDecimal result = new BigDecimal(0.0);
		ShopCart shopCart = getShopCart(request);
		ArrayList<ShopCartItem> shopCartItemList = shopCart.getShopCartItemList();
		for (ShopCartItem shopCartItem : shopCartItemList) {
			BigDecimal b1 = new BigDecimal(shopCartItem.getMoney());
			result=result.add(b1).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		
		shopCart.setAllMoney(result.doubleValue());
		request.getSession().setAttribute("shopCart", shopCart);
	}
	
	
	public static Double getMoney(ShopCartItem shopCartItem) {
		
		GoodsInfo goodsInfo = shopCartItem.getGoodsInfo();
		Double goodsPriceOff = goodsInfo.getGoodsPriceOff();
		Integer count = shopCartItem.getCount();
		
		BigDecimal b1 = new BigDecimal(count);
		BigDecimal b2 = new BigDecimal(goodsPriceOff);
		BigDecimal result = b1.multiply(b2).setScale(2, BigDecimal.ROUND_HALF_UP);
		return result.doubleValue();
		
	}
	
	public static ShopCart getShopCart(HttpServletRequest request) {
		
		ShopCart shopCart = (ShopCart) request.getSession().getAttribute("shopCart");
		if(shopCart==null) {
			return new ShopCart();
		}
		
		return shopCart;				
	}

  public static void delete(HttpServletRequest request,Integer goodsInfoId) {
	           ShopCart shopCart = getShopCart(request);
	           ArrayList<ShopCartItem> shopCartItemList = shopCart.getShopCartItemList();
	           Iterator<ShopCartItem> it = shopCartItemList.iterator();
	           while(it.hasNext()) {
	        	   ShopCartItem shopCartItem=(ShopCartItem)it.next();
	        	if  (shopCartItem.getGoodsInfo().getId().equals(goodsInfoId)){
	        		
	        		it.remove();
	        	}
	           }
	           getAllMoney(request);
	           request.getSession().setAttribute("shopCart", shopCart);
  }
}
