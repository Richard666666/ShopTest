package com.service.impl;

import java.util.ArrayList;

import com.dao.IAddressDao;
import com.dao.impl.AddressDaoImpl;
import com.service.IAddressBiz;
import com.vo.Address;

public class AddressBizImpl implements IAddressBiz {
    private  IAddressDao  addressDao=new AddressDaoImpl();
	@Override
	public ArrayList<Address> getAddressList(Integer userId) {
		return addressDao.getAddressList(userId);
	}

	@Override
	public int updateAddress(Address address) {
		return addressDao.updateAddress(address);
	}

	@Override
	public int addAddress(Address address) {
		return addressDao.addAddress(address);
	}

	@Override
	public int deleteAddress(Integer id) {
		// TODO Auto-generated method stub
		return addressDao.deleteAddress(id);
	}

	@Override
	public Address getAddressById(Integer id) {
		return addressDao.getAddressById(id);
	}

}
