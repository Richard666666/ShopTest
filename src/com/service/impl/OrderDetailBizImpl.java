package com.service.impl;

import com.dao.IOrderDetailDao;
import com.dao.impl.OrderDetailDaoImpl;
import com.service.IOrderDetailBiz;
import com.vo.OrderDetail;

public class OrderDetailBizImpl implements IOrderDetailBiz{

	private IOrderDetailDao orderDetailDao = new OrderDetailDaoImpl(); 
	
	@Override
	public int add(OrderDetail orderDetail) {
		return orderDetailDao.add(orderDetail);
	}


}
