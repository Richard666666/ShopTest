package com.service;

import java.util.ArrayList;

import com.vo.Address;

public interface IAddressBiz {

	public ArrayList<Address> getAddressList(Integer userId);
	public int updateAddress(Address address);
	public int addAddress(Address address);
	public int deleteAddress(Integer id);
	public Address getAddressById(Integer id);
	
	
}
