package com.dao.impl;

import com.dao.IOrderDetailDao;
import com.utils.DBUtils;
import com.vo.OrderDetail;

public class OrderDetailDaoImpl implements IOrderDetailDao {

	@Override
	public int add(OrderDetail orderDetail) {
		String sql = "insert into t_order_detail(o_orderid,goodsid,goodsname,goodsprice,goods_description,goodsnum,goodspic,goods_total_price,goods_date) values(?,?,?,?,?,?,?,?,?)";
		return DBUtils.commonUpdate(sql, orderDetail.getoOrderId(), orderDetail.getGoodsId(),
				orderDetail.getGoodsName(), orderDetail.getGoodsPrice(), orderDetail.getGoodsDescription(),
				orderDetail.getGoodsNum(), orderDetail.getGoodsPic(), orderDetail.getGoodsTotalPrice(),
				orderDetail.getGoodsDate());
	}

}
