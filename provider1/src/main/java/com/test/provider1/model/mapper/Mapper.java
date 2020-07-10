package com.test.provider1.model.mapper;

import java.util.ArrayList;
import java.util.List;

import com.test.provider1.model.po.ManufacturerPO;
import com.test.provider1.model.po.ProductsPO;
import com.test.provider1.model.vo.ManufacturerVO;
import com.test.provider1.model.vo.ProductsVO;

public class Mapper {

	public static ProductsVO toProductVO(ProductsPO productPO, ManufacturerPO manufacturerPO) {
		ProductsVO productVO = new ProductsVO();
		productVO.setProductId(productPO.getProductId());
		productVO.setProductName(productPO.getProductName());
		productVO.setProductType(productPO.getProductType());
		productVO.setPrice(productPO.getPrice());
		productVO.setManufacturerId(manufacturerPO.getManufacturerId());
		productVO.setManufacturerName(manufacturerPO.getManufacturerName());
		productVO.setManufacturerAddress(manufacturerPO.getManufacturerAddress());
		
		return productVO;
	}
	
	public static ManufacturerVO toManufacturerVO(ManufacturerPO manufacturerPO, List<ProductsPO> productsPO) {
		ManufacturerVO manufacturerVO = new ManufacturerVO();
		
		manufacturerVO.setManufacturerId(manufacturerPO.getManufacturerId());
		manufacturerVO.setManufacturerName(manufacturerPO.getManufacturerName());
		manufacturerVO.setManufacturerAddress(manufacturerPO.getManufacturerAddress());
		List<ProductsVO> productVOList = new ArrayList<ProductsVO>();
		for (ProductsPO product : productsPO) {
			ProductsVO productVO = new ProductsVO();
			productVO.setProductId(product.getProductId());
			productVO.setProductName(product.getProductName());
			productVO.setProductType(product.getProductType());
			productVO.setPrice(product.getPrice());
			productVOList.add(productVO);
		}
		manufacturerVO.setProductsList(productVOList);
		
		return manufacturerVO;
	}
	
}
