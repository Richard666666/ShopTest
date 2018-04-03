package com.dao.impl;

import java.util.ArrayList;

import com.dao.IGoodsTypeDao;
import com.utils.DBUtils;
import com.vo.GoodsType;

public class GoodsTypeDaoImpl implements IGoodsTypeDao {

	private DBUtils<GoodsType> dbUtils = new DBUtils<>();

	@Override
	public int add(GoodsType goodsType) {
		String sql = "insert into t_goods_type(gtype_name,gtype_parentid,gtype_pic) values(?,?,?)";
		return DBUtils.commonUpdate(sql, goodsType.getGoodsTypeName(), goodsType.getGoodsTypeParentId(),
				goodsType.getGoodsTypePic());
	}

	@Override
	public int delete(Integer id) {
		String sql = "delete from t_goods_type where id = ?";
		return DBUtils.commonUpdate(sql, id);
	}

	@Override
	public int update(GoodsType goodsType) {

		String sql = "update t_goods_type set gtype_name=?,gtype_parentid=?,gtype_pic=? where id = ?";
		return DBUtils.commonUpdate(sql, goodsType.getGoodsTypeName(), goodsType.getGoodsTypeParentId(),
				goodsType.getGoodsTypePic(), goodsType.getId());
	}

	@Override
	public ArrayList<GoodsType> getGoodsTypeList(int offset, int count) {
		String sql = "select * from t_goods_type limit ?,?";
		return dbUtils.commonQuery(sql, GoodsType.class, offset, count);
	}

	@Override
	public GoodsType getGoodsTypebyId(Integer id) {
		String sql = "select * from t_goods_type where id = ?";
		ArrayList<GoodsType> arrayList = dbUtils.commonQuery(sql, GoodsType.class, id);
		if (!arrayList.isEmpty()) {
			return arrayList.get(0);
		}
		return null;
	}

	@Override
	public GoodsType getGoodsTypebyName(String name) {
		String sql = "select * from t_goods_type where gtype_name = ?";
		ArrayList<GoodsType> arrayList = dbUtils.commonQuery(sql, GoodsType.class, name);
		if (!arrayList.isEmpty()) {
			return arrayList.get(0);
		}
		return null;
	}

	@Override
	public ArrayList<GoodsType> getGoodsTypeListbyParentId() {
		String sql = "select * from t_goods_type where gtype_parentid = 0";
		return dbUtils.commonQuery(sql, GoodsType.class);
	}

	@Override
	public int getAllCount() {
		String sql = "select * from t_goods_type";
		ArrayList<GoodsType> arrayList = dbUtils.commonQuery(sql, GoodsType.class);
		int count = arrayList.size();
		return count;
	}

	@Override
	public ArrayList<GoodsType> getGoodsTypeList() {
		String sql = "select * from t_goods_type";
		return dbUtils.commonQuery(sql, GoodsType.class);
	}
}
