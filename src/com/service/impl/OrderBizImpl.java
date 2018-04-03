package com.service.impl;

import com.dao.IOrderDao;
import com.dao.impl.OrderDaoImpl;
import com.service.IOrderBiz;
import com.vo.Order;

public class OrderBizImpl implements IOrderBiz{

	private IOrderDao orderDao = new OrderDaoImpl();
	
	@Override
	public int add(Order order) {
		return orderDao.add(order);
	}
}
