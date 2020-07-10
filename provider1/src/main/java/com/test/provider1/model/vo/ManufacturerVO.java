package com.test.provider1.model.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ManufacturerVO {

	private String manufacturerId;

	private String manufacturerName;

	private String manufacturerAddress;
	
	private List<ProductsVO> productsList;

	public ManufacturerVO() {
	}

	public ManufacturerVO(String manufacturerId, 
			String manufacturerName, 
			
			String manufacturerAddress,
			List<ProductsVO> productVOList) {
		super();
		this.manufacturerId = manufacturerId;
		this.manufacturerName = manufacturerName;
		this.manufacturerAddress = manufacturerAddress;
		this.productsList = productVOList;
	}

	public String getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
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

	public List<ProductsVO> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<ProductsVO> productsList) {
		this.productsList = productsList;
	}	
	
}
