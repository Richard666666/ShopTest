package com.service.impl;

import java.util.ArrayList;

import com.dao.IGoodsTypeDao;
import com.dao.impl.GoodsTypeDaoImpl;
import com.service.IGoodsTypeBiz;
import com.vo.GoodsType;


public class GoodsTypeBizImpl implements IGoodsTypeBiz{

	private IGoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
	
	@Override
	public int add(GoodsType goodsType) {
		
		GoodsType gt = goodsTypeDao.getGoodsTypebyName(goodsType.getGoodsTypeName());
		if(gt == null){
			return goodsTypeDao.add(goodsType);
		}
		return 0;
	}

	@Override
	public int delete(Integer id) {
		return goodsTypeDao.delete(id);
	}

	@Override
	public int update(GoodsType goodsType) {
		return goodsTypeDao.update(goodsType);
	}


	@Override
	public GoodsType getGoodsTypebyId(Integer id) {
		return goodsTypeDao.getGoodsTypebyId(id);
	}

	@Override
	public GoodsType getGoodsTypebyName(String name) {
		return goodsTypeDao.getGoodsTypebyName(name);
	}

	@Override
	public ArrayList<GoodsType> getGoodsTypeListbyParentId() {
		return goodsTypeDao.getGoodsTypeListbyParentId();
	}

	@Override
	public ArrayList<GoodsType> getGoodsTypeList(int currentPage, int count) {
		int offset = (currentPage-1)*count;
		return	goodsTypeDao.getGoodsTypeList(offset, count);
	}

	@Override
	public int getAllPage(int count) {
		// TODO Auto-generated method stub
		
		int allCount = goodsTypeDao.getAllCount();
		return  (allCount%count==0)?(allCount/count):(allCount/count+1);
	}
	@Override
	public ArrayList<GoodsType> getGoodsTypeList() {
		return goodsTypeDao.getGoodsTypeList();
	}
}
