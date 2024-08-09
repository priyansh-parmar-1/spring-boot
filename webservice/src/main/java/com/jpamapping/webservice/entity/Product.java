package com.jpamapping.webservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer pid;
	private String productName;
	private Integer qty;
	private Float price;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Product(String productName, Integer qty, Float price) {
		super();
		this.productName = productName;
		this.qty = qty;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", productName=" + productName + ", qty=" + qty + ", price=" + price + "]";
	}

	
}
