package com.dao.impl;

import java.util.ArrayList;

import com.dao.IAddressDao;
import com.utils.DBUtils;
import com.vo.Address;

public class AddressDaoImpl implements IAddressDao {

	DBUtils<Address> dbUtils = new DBUtils<>();

	@Override
	public ArrayList<Address> getAddressList(Integer userId) {
		String sql = "select * from t_address where userid=?";
		return dbUtils.commonQuery(sql, Address.class, userId);
	}

	@Override
	public int updateAddress(Address address) {
		String sql = "update t_address set shouhuoren=?,phone=?,address=?,userid=?,isdefault=? where id=?";
		return DBUtils.commonUpdate(sql, address.getShouhuoren(), address.getPhone(), address.getAddress(),
				address.getUserid(), address.getIsdefault(), address.getId());
	}

	@Override
	public int addAddress(Address address) {
		String sql = "insert into t_address(shouhuoren,phone,address,userid,isdefault) values(?,?,?,?,?)";
		return DBUtils.commonUpdate(sql, address.getShouhuoren(), address.getPhone(), address.getAddress(),
				address.getUserid(), address.getIsdefault());
	}

	@Override
	public int deleteAddress(Integer id) {
		String sql = "delete from t_address where id=?";
		return DBUtils.commonUpdate(sql, id);

	}

	@Override
	public Address getAddressById(Integer id) {
		String sql = "select * from t_address where id=?";
		ArrayList<Address> arrayList = dbUtils.commonQuery(sql, Address.class, id);
		if (!arrayList.isEmpty()) {
			Address address = arrayList.get(0);

			return address;

		}
		return null;
	}
}
