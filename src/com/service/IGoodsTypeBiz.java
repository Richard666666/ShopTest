package com.service;

import java.util.ArrayList;

import com.vo.GoodsType;


public interface IGoodsTypeBiz {

	public int add(GoodsType goodsType);
	
	public int delete(Integer id);
	
	public int update(GoodsType goodsType);
	
	public ArrayList<GoodsType> getGoodsTypeList(int currentPage, int count);
	
	public GoodsType getGoodsTypebyId(Integer id);
	
	public GoodsType getGoodsTypebyName(String name);

	public ArrayList<GoodsType> getGoodsTypeListbyParentId();
	public int getAllPage(int count);

	ArrayList<GoodsType> getGoodsTypeList();
}
