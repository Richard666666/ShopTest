package com.dao.impl;

import com.dao.IOrderDao;
import com.utils.DBUtils;
import com.vo.Order;

public class OrderDaoImpl implements IOrderDao {

	@Override
	public int add(Order order) {
		String sql = "insert into t_order(o_sendtype,o_paytype,o_paycount,o_orderdate,userid,o_shperson,o_shphone,o_shaddress) values(?,?,?,?,?,?,?,?)";
		return DBUtils.commonInsert(sql, order.getoSendType(), order.getoPayType(), order.getoPayCount(),
				order.getoOrderDate(), order.getUserId(), order.getoShPerson(), order.getoShPhone(),
				order.getoShAddress());
	}
}
