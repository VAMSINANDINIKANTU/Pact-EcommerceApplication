package com.test.provider1.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductsVO {

	private String productId;

	private String productName;

	private String productType;

	private double price;
	
	private String manufacturerId;
	
	private String manufacturerName;
	
	private String manufacturerAddress;

	public ProductsVO() {
	}

	public ProductsVO(String productId, 
			String productName, 
			String productType, 
			String manufacturerId, 
			double price,
			String manufacturerName,
			String manufacturerAddress) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.manufacturerId = manufacturerId;
		this.price = price;
		this.manufacturerName = manufacturerName;
		this.manufacturerAddress = manufacturerAddress;
	}

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

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getManufacturerAddress() {
		return manufacturerAddress;
	}

	public void setManufacturerAddress(String manufacturerAddress) {
		this.manufacturerAddress = manufacturerAddress;
	}
	
}
