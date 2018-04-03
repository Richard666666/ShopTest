package com.vo;

public class GoodsInfo {

	private Integer id;
	private String goodsName;
	private String goodsDescription;
	private String goodsPic;
	private Double goodsPrice;
	private Integer goodsStock;
	private Double goodsPriceOff;
	private Double goodsDiscount;
	private Integer goodsParentid;
	private Integer goodsFatherid;
	private String isDelete;
	
	public GoodsInfo() {
		super();
	}
	
	public GoodsInfo(Integer id, String goodsName, String goodsDescription, String goodsPic, Double goodsPrice,
			Integer goodsStock, Double goodsPriceOff, Double goodsDiscount, Integer goodsParentid,
			Integer goodsFatherid, String isDelete) {
		super();
		this.id = id;
		this.goodsName = goodsName;
		this.goodsDescription = goodsDescription;
		this.goodsPic = goodsPic;
		this.goodsPrice = goodsPrice;
		this.goodsStock = goodsStock;
		this.goodsPriceOff = goodsPriceOff;
		this.goodsDiscount = goodsDiscount;
		this.goodsParentid = goodsParentid;
		this.goodsFatherid = goodsFatherid;
		this.isDelete = isDelete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsDescription() {
		return goodsDescription;
	}

	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}

	public String getGoodsPic() {
		return goodsPic;
	}

	public void setGoodsPic(String goodsPic) {
		this.goodsPic = goodsPic;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getGoodsStock() {
		return goodsStock;
	}

	public void setGoodsStock(Integer goodsStock) {
		this.goodsStock = goodsStock;
	}

	public Double getGoodsPriceOff() {
		return goodsPriceOff;
	}

	public void setGoodsPriceOff(Double goodsPriceOff) {
		this.goodsPriceOff = goodsPriceOff;
	}

	public Double getGoodsDiscount() {
		return goodsDiscount;
	}

	public void setGoodsDiscount(Double goodsDiscount) {
		this.goodsDiscount = goodsDiscount;
	}

	public Integer getGoodsParentid() {
		return goodsParentid;
	}

	public void setGoodsParentid(Integer goodsParentid) {
		this.goodsParentid = goodsParentid;
	}

	public Integer getGoodsFatherid() {
		return goodsFatherid;
	}

	public void setGoodsFatherid(Integer goodsFatherid) {
		this.goodsFatherid = goodsFatherid;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsDescription == null) ? 0 : goodsDescription.hashCode());
		result = prime * result + ((goodsDiscount == null) ? 0 : goodsDiscount.hashCode());
		result = prime * result + ((goodsFatherid == null) ? 0 : goodsFatherid.hashCode());
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		result = prime * result + ((goodsParentid == null) ? 0 : goodsParentid.hashCode());
		result = prime * result + ((goodsPic == null) ? 0 : goodsPic.hashCode());
		result = prime * result + ((goodsPrice == null) ? 0 : goodsPrice.hashCode());
		result = prime * result + ((goodsPriceOff == null) ? 0 : goodsPriceOff.hashCode());
		result = prime * result + ((goodsStock == null) ? 0 : goodsStock.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isDelete == null) ? 0 : isDelete.hashCode());
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
		GoodsInfo other = (GoodsInfo) obj;
		if (goodsDescription == null) {
			if (other.goodsDescription != null)
				return false;
		} else if (!goodsDescription.equals(other.goodsDescription))
			return false;
		if (goodsDiscount == null) {
			if (other.goodsDiscount != null)
				return false;
		} else if (!goodsDiscount.equals(other.goodsDiscount))
			return false;
		if (goodsFatherid == null) {
			if (other.goodsFatherid != null)
				return false;
		} else if (!goodsFatherid.equals(other.goodsFatherid))
			return false;
		if (goodsName == null) {
			if (other.goodsName != null)
				return false;
		} else if (!goodsName.equals(other.goodsName))
			return false;
		if (goodsParentid == null) {
			if (other.goodsParentid != null)
				return false;
		} else if (!goodsParentid.equals(other.goodsParentid))
			return false;
		if (goodsPic == null) {
			if (other.goodsPic != null)
				return false;
		} else if (!goodsPic.equals(other.goodsPic))
			return false;
		if (goodsPrice == null) {
			if (other.goodsPrice != null)
				return false;
		} else if (!goodsPrice.equals(other.goodsPrice))
			return false;
		if (goodsPriceOff == null) {
			if (other.goodsPriceOff != null)
				return false;
		} else if (!goodsPriceOff.equals(other.goodsPriceOff))
			return false;
		if (goodsStock == null) {
			if (other.goodsStock != null)
				return false;
		} else if (!goodsStock.equals(other.goodsStock))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isDelete == null) {
			if (other.isDelete != null)
				return false;
		} else if (!isDelete.equals(other.isDelete))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GoodsInfo [id=" + id + ", goodsName=" + goodsName + ", goodsDescription=" + goodsDescription
				+ ", goodsPic=" + goodsPic + ", goodsPrice=" + goodsPrice + ", goodsStock=" + goodsStock
				+ ", goodsPriceOff=" + goodsPriceOff + ", goodsDiscount=" + goodsDiscount + ", goodsParentid="
				+ goodsParentid + ", goodsFatherid=" + goodsFatherid + ", isDelete=" + isDelete + "]";
	}
}
