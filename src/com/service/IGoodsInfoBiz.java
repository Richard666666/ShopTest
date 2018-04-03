package com.service;

import java.util.ArrayList;

import com.vo.GoodsInfo;



public interface IGoodsInfoBiz {

	public int add(GoodsInfo goodsInfo);
	
	public int delete(Integer id);
	
	public int update(GoodsInfo goodsInfo);
	
	public ArrayList<GoodsInfo> getGoodsInfoList(int currentPage, int count);
	
	public GoodsInfo getGoodsInfobyId(Integer id);
	
	public GoodsInfo getGoodsInfobyName(String name);
	public int getAllPage(int count);

	ArrayList<GoodsInfo> getGoodsInfoList();

}
