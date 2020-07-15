package com.test.provider1.model.vo;
import java.io.Serializable;
import java.util.List;

public class ProductsJson implements Serializable {
        private static final long serialVersionUID = 1L;
        private List<ProductsVO> productsVOs;
        public List<ProductsVO> getProductsVOs() {
		return productsVOs;
	}
        public void setProductsVOs(List<ProductsVO> productsVOs) {
		this.productsVOs = productsVOs;
	}
}
