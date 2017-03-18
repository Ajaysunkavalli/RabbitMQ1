package com.test.rabbitmq.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EProduct {
	private String productId;
	private String productName;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public EProduct() {
		super();
	}
	public EProduct(String productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}
	

}
