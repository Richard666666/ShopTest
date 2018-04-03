package com.vo;

public class GoodsType {
	
	private Integer id;
	private String goodsTypeName;
	private Integer goodsTypeParentId;
	private String goodsTypePic;
	
	public GoodsType() {
		super();
	}

	public GoodsType(Integer id, String goodsTypeName, Integer goodsTypeParentId, String goodsTypePic) {
		this.id = id;
		this.goodsTypeName = goodsTypeName;
		this.goodsTypeParentId = goodsTypeParentId;
		this.goodsTypePic = goodsTypePic;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsTypeName() {
		return goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}

	public Integer getGoodsTypeParentId() {
		return goodsTypeParentId;
	}

	public void setGoodsTypeParentId(Integer goodsTypeParentId) {
		this.goodsTypeParentId = goodsTypeParentId;
	}

	public String getGoodsTypePic() {
		return goodsTypePic;
	}

	public void setGoodsTypePic(String goodsTypePic) {
		this.goodsTypePic = goodsTypePic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsTypeName == null) ? 0 : goodsTypeName.hashCode());
		result = prime * result + ((goodsTypeParentId == null) ? 0 : goodsTypeParentId.hashCode());
		result = prime * result + ((goodsTypePic == null) ? 0 : goodsTypePic.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		GoodsType other = (GoodsType) obj;
		if (goodsTypeName == null) {
			if (other.goodsTypeName != null)
				return false;
		} else if (!goodsTypeName.equals(other.goodsTypeName))
			return false;
		if (goodsTypeParentId == null) {
			if (other.goodsTypeParentId != null)
				return false;
		} else if (!goodsTypeParentId.equals(other.goodsTypeParentId))
			return false;
		if (goodsTypePic == null) {
			if (other.goodsTypePic != null)
				return false;
		} else if (!goodsTypePic.equals(other.goodsTypePic))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GoodsType [id=" + id + ", goodsTypeName=" + goodsTypeName + ", goodsTypeParentId=" + goodsTypeParentId
				+ ", goodsTypePic=" + goodsTypePic + "]";
	}

}
