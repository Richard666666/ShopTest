package com.vo;

public class Order {

	private Integer id;
	private String oSendType;
	private String oPayType;
	private Double oPayCount;
	private String oOrderDate;
	private Integer userId;
	private String oShPerson;
	private String oShPhone;
	private String oShAddress;
	
	public Order() {
		super();
	}

	public Order(Integer id, String oSendType, String oPayType, Double oPayCount, String oOrderDate, Integer userId,
			String oShPerson, String oShPhone, String oShAddress) {
		super();
		this.id = id;
		this.oSendType = oSendType;
		this.oPayType = oPayType;
		this.oPayCount = oPayCount;
		this.oOrderDate = oOrderDate;
		this.userId = userId;
		this.oShPerson = oShPerson;
		this.oShPhone = oShPhone;
		this.oShAddress = oShAddress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getoSendType() {
		return oSendType;
	}

	public void setoSendType(String oSendType) {
		this.oSendType = oSendType;
	}

	public String getoPayType() {
		return oPayType;
	}

	public void setoPayType(String oPayType) {
		this.oPayType = oPayType;
	}

	public Double getoPayCount() {
		return oPayCount;
	}

	public void setoPayCount(Double oPayCount) {
		this.oPayCount = oPayCount;
	}

	public String getoOrderDate() {
		return oOrderDate;
	}

	public void setoOrderDate(String oOrderDate) {
		this.oOrderDate = oOrderDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getoShPerson() {
		return oShPerson;
	}

	public void setoShPerson(String oShPerson) {
		this.oShPerson = oShPerson;
	}

	public String getoShPhone() {
		return oShPhone;
	}

	public void setoShPhone(String oShPhone) {
		this.oShPhone = oShPhone;
	}

	public String getoShAddress() {
		return oShAddress;
	}

	public void setoShAddress(String oShAddress) {
		this.oShAddress = oShAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((oOrderDate == null) ? 0 : oOrderDate.hashCode());
		result = prime * result + ((oPayCount == null) ? 0 : oPayCount.hashCode());
		result = prime * result + ((oPayType == null) ? 0 : oPayType.hashCode());
		result = prime * result + ((oSendType == null) ? 0 : oSendType.hashCode());
		result = prime * result + ((oShAddress == null) ? 0 : oShAddress.hashCode());
		result = prime * result + ((oShPerson == null) ? 0 : oShPerson.hashCode());
		result = prime * result + ((oShPhone == null) ? 0 : oShPhone.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (oOrderDate == null) {
			if (other.oOrderDate != null)
				return false;
		} else if (!oOrderDate.equals(other.oOrderDate))
			return false;
		if (oPayCount == null) {
			if (other.oPayCount != null)
				return false;
		} else if (!oPayCount.equals(other.oPayCount))
			return false;
		if (oPayType == null) {
			if (other.oPayType != null)
				return false;
		} else if (!oPayType.equals(other.oPayType))
			return false;
		if (oSendType == null) {
			if (other.oSendType != null)
				return false;
		} else if (!oSendType.equals(other.oSendType))
			return false;
		if (oShAddress == null) {
			if (other.oShAddress != null)
				return false;
		} else if (!oShAddress.equals(other.oShAddress))
			return false;
		if (oShPerson == null) {
			if (other.oShPerson != null)
				return false;
		} else if (!oShPerson.equals(other.oShPerson))
			return false;
		if (oShPhone == null) {
			if (other.oShPhone != null)
				return false;
		} else if (!oShPhone.equals(other.oShPhone))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", oSendType=" + oSendType + ", oPayType=" + oPayType + ", oPayCount=" + oPayCount
				+ ", oOrderDate=" + oOrderDate + ", userId=" + userId + ", oShPerson=" + oShPerson + ", oShPhone="
				+ oShPhone + ", oShAddress=" + oShAddress + "]";
	}
}
