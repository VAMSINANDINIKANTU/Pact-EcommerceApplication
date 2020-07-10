package com.test.provider1.model.po;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class ProductsPO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String productId;

	private String productName;

	private String productType;

	private double price;
	
	private String manufacturerId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manufacturerId", referencedColumnName ="manufacturerId", insertable = false, updatable = false)
	private ManufacturerPO manufacturer;

	public ProductsPO() {}

	public ProductsPO(String productId, String productName, String productType, String manufacturerId, double price,
			ManufacturerPO manufacturer) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.manufacturerId = manufacturerId;
		this.price = price;
		this.manufacturer = manufacturer;
	}

	public String getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ManufacturerPO getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ManufacturerPO manufacturer) {
		this.manufacturer = manufacturer;
	}

}