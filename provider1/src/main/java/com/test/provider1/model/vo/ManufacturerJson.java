package com.test.provider1.model.vo;
import java.io.Serializable;
import java.util.List;
public class ManufacturerJson implements Serializable {
	private static final long serialVersionUID = 1L;
    private List<ManufacturerVO> manufacturerVOs;
    public List<ManufacturerVO> getManufacturerVOs() {
		return manufacturerVOs;
	}
    public void setManufacturerVOs(List<ManufacturerVO> manufacturerVOs) {
		this.manufacturerVOs = manufacturerVOs;
	}
}