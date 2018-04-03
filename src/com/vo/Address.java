package com.vo;

public class Address {

	private Integer id;
	private String shouhuoren;
	private String phone;
	private String address;
	private Integer userid;
	private String isdefault;
	
	public Address() {
		super();
	}

	public Address(Integer id, String shouhuoren, String phone, String address, Integer userid, String isdefault) {
		super();
		this.id = id;
		this.shouhuoren = shouhuoren;
		this.phone = phone;
		this.address = address;
		this.userid = userid;
		this.isdefault = isdefault;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShouhuoren() {
		return shouhuoren;
	}

	public void setShouhuoren(String shouhuoren) {
		this.shouhuoren = shouhuoren;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isdefault == null) ? 0 : isdefault.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((shouhuoren == null) ? 0 : shouhuoren.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
		Address other = (Address) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isdefault == null) {
			if (other.isdefault != null)
				return false;
		} else if (!isdefault.equals(other.isdefault))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (shouhuoren == null) {
			if (other.shouhuoren != null)
				return false;
		} else if (!shouhuoren.equals(other.shouhuoren))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", shouhuoren=" + shouhuoren + ", phone=" + phone + ", address=" + address
				+ ", userid=" + userid + ", isdefault=" + isdefault + "]";
	}
	
}
