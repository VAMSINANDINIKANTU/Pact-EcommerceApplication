package com.test.provider1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.provider1.model.po.ManufacturerPO;
import com.test.provider1.model.po.ProductsPO;
import com.test.provider1.model.vo.ManufacturerJson;
import com.test.provider1.model.vo.ManufacturerVO;
import com.test.provider1.model.vo.ProductsVO;
import com.test.provider1.service.EcommerceService;

@RestController
@RequestMapping("/app")
public class EcommerceController {

	@Autowired
	private EcommerceService ecommerceService;

	@RequestMapping(method = RequestMethod.POST, path = "/products")
	public void addProducts(@RequestBody List<ProductsPO> products) {
		ecommerceService.postadd(products);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/product")
	public void addProduct(@RequestBody ProductsVO productVO) {
		ecommerceService.saveProduct(productVO);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/sampleproduct")
	public ProductsVO getSampleProduct() {
		ProductsVO productVO = new ProductsVO();
		productVO.setProductId("111");
		productVO.setProductName("product_name");
		productVO.setProductType("product_type");
		productVO.setPrice(123.22);
		productVO.setManufacturerId("991");
		return productVO;
	}

	@RequestMapping("/products")
	public List<ProductsVO> getAllProducts() {

		List<ProductsVO> productsList = ecommerceService.getAllProducts();
		return productsList;

	}

	@RequestMapping("/products/{prodid}")
	public ProductsVO getProductDetailsByID(@PathVariable String prodid) {

		ProductsVO productVO = ecommerceService.getProductDetailsByID(prodid);
		return productVO;

	}

	@GetMapping("/products/type/{prodtype}")
	public List<ProductsVO> getProductDetailsByType(@PathVariable String prodtype) {

		List<ProductsVO> productsList = ecommerceService.getProductDetailsByType(prodtype);
		return productsList;

	}

	@RequestMapping("/products/name/{prodname}")
	public List<ProductsVO> getProductDetailsByName(@PathVariable String prodname) {

		List<ProductsVO> productsList = ecommerceService.getProductDetailsByName(prodname);
		return productsList;

	}

	@RequestMapping(method = RequestMethod.POST, path = "/manufacturers")
	public void addManfacture(@RequestBody List<ManufacturerPO> manufacturer) {
		ecommerceService.postaddManu(manufacturer);

	}

	@RequestMapping("/manufacturers")
	public List<ManufacturerVO> getAllManufacturers() {

		List<ManufacturerVO> manufacturerList = ecommerceService.getAllManufactures();
		return manufacturerList;

	}

	@GetMapping("/manufacturers/{manufacturerid}")
	public ManufacturerVO getManufacturerDetailsByID(@PathVariable String manufacturerid) {

		ManufacturerVO manufacturerVO = ecommerceService.getManufacturerDetailsByID(manufacturerid);
		return manufacturerVO;
	}

	@RequestMapping("/manufacturers/name/{manufacturername}")
	public ManufacturerJson getManufacturerDetailsByName(@PathVariable String manufacturername) {
		List<ManufacturerVO> manufacturerList = ecommerceService.getManufacturerDetailsByName(manufacturername);
		ManufacturerJson manufacturerJson = new ManufacturerJson();
		manufacturerJson.setManufacturerVOs(manufacturerList);
		return manufacturerJson;
	}

}
