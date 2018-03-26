package com.neusoft.entity;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable{ 
     
	/**
	 * 
	 */
	private static final long serialVersionUID = -6611017316814413651L;
	//每一页数据集合
	private List<T> data;
	//总共多少页
	private int totalpage;
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "PageModel [data=" + data + ", totalpage=" + totalpage + "]";
	}
	
	
	
}
