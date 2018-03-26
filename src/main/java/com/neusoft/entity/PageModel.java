package com.neusoft.entity;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable{ 
     
	/**
	 * 
	 */
	private static final long serialVersionUID = -6611017316814413651L;
	//ÿһҳ���ݼ���
	private List<T> data;
	//�ܹ�����ҳ
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
