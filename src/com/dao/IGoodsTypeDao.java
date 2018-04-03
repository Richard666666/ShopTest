package com.dao;
import java.util.ArrayList;

import com.vo.GoodsType;


public interface IGoodsTypeDao {

	public int add(GoodsType goodsType);
	
	public int delete(Integer id);
	
	public int update(GoodsType goodsType);
	
	public ArrayList<GoodsType> getGoodsTypeList(int offset,int count);
	
	public GoodsType getGoodsTypebyId(Integer id);
	
	public GoodsType getGoodsTypebyName(String name);

	public ArrayList<GoodsType> getGoodsTypeListbyParentId();
	public int getAllCount();
	public ArrayList<GoodsType> getGoodsTypeList();
}
