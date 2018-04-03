package com.vo;

import java.util.ArrayList;

public class ShopCart {

	private ArrayList<ShopCartItem> shopCartItemList = new ArrayList<>();
	private Double allMoney;
	
	public ShopCart() {
		super();
	}

	public ShopCart(ArrayList<ShopCartItem> shopCartItemList, Double allMoney) {
		super();
		this.shopCartItemList = shopCartItemList;
		this.allMoney = allMoney;
	}

	public ArrayList<ShopCartItem> getShopCartItemList() {
		return shopCartItemList;
	}

	public void setShopCartItemList(ArrayList<ShopCartItem> shopCartItemList) {
		this.shopCartItemList = shopCartItemList;
	}

	public Double getAllMoney() {
		return allMoney;
	}

	public void setAllMoney(Double allMoney) {
		this.allMoney = allMoney;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allMoney == null) ? 0 : allMoney.hashCode());
		result = prime * result + ((shopCartItemList == null) ? 0 : shopCartItemList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShopCart other = (ShopCart) obj;
		if (allMoney == null) {
			if (other.allMoney != null)
				return false;
		} else if (!allMoney.equals(other.allMoney))
			return false;
		if (shopCartItemList == null) {
			if (other.shopCartItemList != null)
				return false;
		} else if (!shopCartItemList.equals(other.shopCartItemList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShopCart [shopCartItemList=" + shopCartItemList + ", allMoney=" + allMoney + "]";
	}
}
