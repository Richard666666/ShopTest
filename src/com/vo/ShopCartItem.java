package com.vo;

public class ShopCartItem {

	private GoodsInfo goodsInfo;
	private Integer count;
	private Double money;
	
	public ShopCartItem() {
		super();
	}

	public ShopCartItem(GoodsInfo goodsInfo, Integer count, Double money) {
		super();
		this.goodsInfo = goodsInfo;
		this.count = count;
		this.money = money;
	}

	public ShopCartItem(GoodsInfo goodsInfo, Integer count) {
		this.goodsInfo = goodsInfo;
		this.count = count;
	}

	public GoodsInfo getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(GoodsInfo goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((goodsInfo == null) ? 0 : goodsInfo.hashCode());
		result = prime * result + ((money == null) ? 0 : money.hashCode());
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
		ShopCartItem other = (ShopCartItem) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (goodsInfo == null) {
			if (other.goodsInfo != null)
				return false;
		} else if (!goodsInfo.equals(other.goodsInfo))
			return false;
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShopCartItem [goodsInfo=" + goodsInfo + ", count=" + count + ", money=" + money + "]";
	}
}
