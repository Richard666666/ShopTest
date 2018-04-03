package com.service.impl;

import java.util.ArrayList;

import com.dao.IGoodsInfoDao;
import com.dao.impl.GoodsInfoDaoImpl;
import com.service.IGoodsInfoBiz;
import com.vo.GoodsInfo;

public class GoodsInfoBizImpl implements IGoodsInfoBiz {

	private IGoodsInfoDao goodsInfoDao = new GoodsInfoDaoImpl();

	@Override
	public int add(GoodsInfo goodsInfo) {
		return goodsInfoDao.add(goodsInfo);
	}

	@Override
	public int delete(Integer id) {
		return goodsInfoDao.delete(id);
	}

	@Override
	public int update(GoodsInfo goodsInfo) {
		return goodsInfoDao.update(goodsInfo);
	}



	@Override
	public GoodsInfo getGoodsInfobyId(Integer id) {
		return goodsInfoDao.getGoodsInfobyId(id);
	}

	@Override
	public GoodsInfo getGoodsInfobyName(String name) {
		return goodsInfoDao.getGoodsInfobyName(name);
	}

	@Override
	public ArrayList<GoodsInfo> getGoodsInfoList(int currentPage, int count) {
		int offset = (currentPage-1)*count;
	return	goodsInfoDao.getGoodsInfoList(offset, count);
	}

	@Override
	public int getAllPage(int count) {
		// TODO Auto-generated method stub
		int allCount = goodsInfoDao.getAllCount();
		return  (allCount%count==0)?(allCount/count):(allCount/count+1);
	}
	@Override
	public ArrayList<GoodsInfo> getGoodsInfoList() {
		return goodsInfoDao.getGoodsInfoList();
	}
	
}
