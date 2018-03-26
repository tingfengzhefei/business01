package com.neusoft.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



public class Product implements Serializable{
  
	/**
	 * 
	 */
	private static final long serialVersionUID = -5933599983726074005L;
	private Integer id;
	private Integer category_id;
	private String name;
	private String Subtitle;
	private String main_image;
	private String sub_images;
	private String detail;
	private BigDecimal price;
	private Integer stock ;
	private Integer status;
	private Date create_time;
	private Date update_time;
	public Product(Integer id, Integer category_id, String name, String subtitle, String main_image, String sub_images,
			String detail, BigDecimal price, Integer stock, Integer status, Date create_time, Date update_time) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.name = name;
		Subtitle = subtitle;
		this.main_image = main_image;
		this.sub_images = sub_images;
		this.detail = detail;
		this.price = price;
		this.stock = stock;
		this.status = status;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public Product() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubtitle() {
		return Subtitle;
	}
	public void setSubtitle(String subtitle) {
		Subtitle = subtitle;
	}
	public String getMain_image() {
		return main_image;
	}
	public void setMain_image(String main_image) {
		this.main_image = main_image;
	}
	public String getSub_images() {
		return sub_images;
	}
	public void setSub_images(String sub_images) {
		this.sub_images = sub_images;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", category_id=" + category_id + ", name=" + name + ", Subtitle=" + Subtitle
				+ ", main_image=" + main_image + ", sub_images=" + sub_images + ", detail=" + detail + ", price="
				+ price + ", stock=" + stock + ", status=" + status + ", create_time=" + create_time + ", update_time="
				+ update_time + "]";
	}
	
	
	
	
}
