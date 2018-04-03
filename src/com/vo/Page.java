package com.vo;

import java.util.ArrayList;

public class Page<E> {
      private String url;//分页地址
      private Integer currentPage;//当前页
      private Integer allPage;//总页数
      private Integer count;//每次显示多少行
      private ArrayList<E> list;//数据
	public Page() {
		super();
	}
	public Page(String url, Integer currentPage, Integer allPage, Integer count) {
		super();
		this.url = url;
		this.currentPage = currentPage;
		this.allPage = allPage;
		this.count = count;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getAllPage() {
		return allPage;
	}
	public void setAllPage(Integer allPage) {
		this.allPage = allPage;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public ArrayList<E> getList() {
		return list;
	}
	public void setList(ArrayList<E> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Page [url=" + url + ", currentPage=" + currentPage + ", allPage=" + allPage + ", count=" + count
				+ ", list=" + list + "]";
	}
      
}
