package com.dao;

import java.util.ArrayList;

import com.vo.GoodsInfo;



public interface IGoodsInfoDao {

	public int add(GoodsInfo goodsInfo);
	
	public int delete(Integer id);
	
	public int update(GoodsInfo goodsInfo);
	
	public ArrayList<GoodsInfo> getGoodsInfoList(int offset,int count);
	
	public GoodsInfo getGoodsInfobyId(Integer id);
	
	public GoodsInfo getGoodsInfobyName(String name);
	public int getAllCount();
	public ArrayList<GoodsInfo> getGoodsInfoList();
}
