package com.vo;

public class OrderDetail {

	private Integer id;
	private Integer oOrderId;
	private Integer goodsId;
	private String goodsName;
	private Double goodsPrice;
	private String goodsDescription;
	private Integer goodsNum;
	private String goodsPic;
	private Double goodsTotalPrice;
	private String goodsDate;
	
	public OrderDetail() {
		super();
	}

	public OrderDetail(Integer id, Integer oOrderId, Integer goodsId, String goodsName, Double goodsPrice,
			String goodsDescription, Integer goodsNum, String goodsPic, Double goodsTotalPrice, String goodsDate) {
		super();
		this.id = id;
		this.oOrderId = oOrderId;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsDescription = goodsDescription;
		this.goodsNum = goodsNum;
		this.goodsPic = goodsPic;
		this.goodsTotalPrice = goodsTotalPrice;
		this.goodsDate = goodsDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getoOrderId() {
		return oOrderId;
	}

	public void setoOrderId(Integer oOrderId) {
		this.oOrderId = oOrderId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsDescription() {
		return goodsDescription;
	}

	public void setGoodsDescription(String goodsDescription) {
		this.goodsDescription = goodsDescription;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getGoodsPic() {
		return goodsPic;
	}

	public void setGoodsPic(String goodsPic) {
		this.goodsPic = goodsPic;
	}

	public Double getGoodsTotalPrice() {
		return goodsTotalPrice;
	}

	public void setGoodsTotalPrice(Double goodsTotalPrice) {
		this.goodsTotalPrice = goodsTotalPrice;
	}

	public String getGoodsDate() {
		return goodsDate;
	}

	public void setGoodsDate(String goodsDate) {
		this.goodsDate = goodsDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsDate == null) ? 0 : goodsDate.hashCode());
		result = prime * result + ((goodsDescription == null) ? 0 : goodsDescription.hashCode());
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		result = prime * result + ((goodsNum == null) ? 0 : goodsNum.hashCode());
		result = prime * result + ((goodsPic == null) ? 0 : goodsPic.hashCode());
		result = prime * result + ((goodsPrice == null) ? 0 : goodsPrice.hashCode());
		result = prime * result + ((goodsTotalPrice == null) ? 0 : goodsTotalPrice.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((oOrderId == null) ? 0 : oOrderId.hashCode());
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
		OrderDetail other = (OrderDetail) obj;
		if (goodsDate == null) {
			if (other.goodsDate != null)
				return false;
		} else if (!goodsDate.equals(other.goodsDate))
			return false;
		if (goodsDescription == null) {
			if (other.goodsDescription != null)
				return false;
		} else if (!goodsDescription.equals(other.goodsDescription))
			return false;
		if (goodsId == null) {
			if (other.goodsId != null)
				return false;
		} else if (!goodsId.equals(other.goodsId))
			return false;
		if (goodsName == null) {
			if (other.goodsName != null)
				return false;
		} else if (!goodsName.equals(other.goodsName))
			return false;
		if (goodsNum == null) {
			if (other.goodsNum != null)
				return false;
		} else if (!goodsNum.equals(other.goodsNum))
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
		if (goodsTotalPrice == null) {
			if (other.goodsTotalPrice != null)
				return false;
		} else if (!goodsTotalPrice.equals(other.goodsTotalPrice))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (oOrderId == null) {
			if (other.oOrderId != null)
				return false;
		} else if (!oOrderId.equals(other.oOrderId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", oOrderId=" + oOrderId + ", goodsId=" + goodsId + ", goodsName=" + goodsName
				+ ", goodsPrice=" + goodsPrice + ", goodsDescription=" + goodsDescription + ", goodsNum=" + goodsNum
				+ ", goodsPic=" + goodsPic + ", goodsTotalPrice=" + goodsTotalPrice + ", goodsDate=" + goodsDate + "]";
	}
}
