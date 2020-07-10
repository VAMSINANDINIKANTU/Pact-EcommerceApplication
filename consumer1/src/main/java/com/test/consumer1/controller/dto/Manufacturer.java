package com.test.consumer1.controller.dto;
import java.io.Serializable;
import java.util.List;

public class Manufacturer implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ManufacturerVO> manufacturers;

	public List<ManufacturerVO> getManufacturerVOs() {
		return manufacturers;
	}

	public void setManufacturerVOs(List<ManufacturerVO> manufacturers) {
		this.manufacturers = manufacturers;
	}

}
