package com.test.consumer1.controller.dto;
import java.io.Serializable;
import java.util.List;

public class Products implements Serializable {
        private static final long serialVersionUID = 1L;
	private List<ProductsVO> products;
        public List<ProductsVO> getProductsVOs() {
		return products;
	}
        public void setProductsVOs(List<ProductsVO> products) {
		this.products = products;
	}
}
