package com.dao.impl;

import java.util.ArrayList;

import com.dao.IGoodsInfoDao;
import com.utils.DBUtils;
import com.vo.GoodsInfo;

public class GoodsInfoDaoImpl implements IGoodsInfoDao {

	private DBUtils<GoodsInfo> dbUtils = new DBUtils<>();

	@Override
	public int add(GoodsInfo goodsInfo) {
		String sql = "insert into t_goods_info(goods_name,goods_description,goods_pic,goods_price,goods_stock,goods_price_off,goods_discount,goods_parentid,goods_fatherid,isdelete) values(?,?,?,?,?,?,?,?,?,?)";
		return DBUtils.commonUpdate(sql, goodsInfo.getGoodsName(), goodsInfo.getGoodsDescription(),
				goodsInfo.getGoodsPic(), goodsInfo.getGoodsPrice(), goodsInfo.getGoodsStock(),
				goodsInfo.getGoodsPriceOff(), goodsInfo.getGoodsDiscount(), goodsInfo.getGoodsParentid(),
				goodsInfo.getGoodsFatherid(), goodsInfo.getIsDelete());
	}

	@Override
	public int delete(Integer id) {
		String sql = "delete from t_goods_info where id = ?";
		return DBUtils.commonUpdate(sql, id);
	}

	@Override
	public ArrayList<GoodsInfo> getGoodsInfoList() {
		String sql = "select * from t_goods_info";
		return dbUtils.commonQuery(sql, GoodsInfo.class);
	}

	@Override
	public int update(GoodsInfo goodsInfo) {
		String sql = "update t_goods_info set goods_name=?,goods_description=?,goods_pic=?,goods_price=?,goods_stock=?,goods_price_off=?,goods_discount=?,goods_parentid=?,goods_fatherid=?,isdelete=? where id=?";
		return DBUtils.commonUpdate(sql, goodsInfo.getGoodsName(), goodsInfo.getGoodsDescription(),
				goodsInfo.getGoodsPic(), goodsInfo.getGoodsPrice(), goodsInfo.getGoodsStock(),
				goodsInfo.getGoodsPriceOff(), goodsInfo.getGoodsDiscount(), goodsInfo.getGoodsParentid(),
				goodsInfo.getGoodsFatherid(), goodsInfo.getIsDelete(), goodsInfo.getId());
	}

	@Override
	public ArrayList<GoodsInfo> getGoodsInfoList(int offset, int count) {
		String sql = "select * from t_goods_info limit ?,?";
		return dbUtils.commonQuery(sql, GoodsInfo.class, offset, count);
	}

	@Override
	public GoodsInfo getGoodsInfobyId(Integer id) {
		String sql = "select * from t_goods_info where id=?";
		ArrayList<GoodsInfo> arrayList = dbUtils.commonQuery(sql, GoodsInfo.class, id);
		if (!arrayList.isEmpty()) {
			return arrayList.get(0);
		}
		return null;
	}

	@Override
	public GoodsInfo getGoodsInfobyName(String name) {
		String sql = "select * from t_goods_info where goods_name=?";
		ArrayList<GoodsInfo> arrayList = dbUtils.commonQuery(sql, GoodsInfo.class, name);
		if (!arrayList.isEmpty()) {
			return arrayList.get(0);
		}
		return null;
	}

	@Override
	public int getAllCount() {
		String sql = "select * from t_goods_info";
		ArrayList<GoodsInfo> arrayList = dbUtils.commonQuery(sql, GoodsInfo.class);
		int count = arrayList.size();
		return count;
	}

}
