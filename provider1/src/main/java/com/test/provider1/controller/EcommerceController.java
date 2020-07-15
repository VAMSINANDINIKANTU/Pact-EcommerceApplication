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
import com.test.provider1.model.vo.ProductsJson;
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

	@GetMapping("/products/type/{prodtype}")
	public List<ProductsVO> getProductDetailsByType(@PathVariable String prodtype) {
		List<ProductsVO> productsList = ecommerceService.getProductDetailsByType(prodtype);
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

	@RequestMapping("/products/name/{prodname}")
	public ProductsJson getProductDetailsByName(@PathVariable String prodname) {
		List<ProductsVO> productsList = ecommerceService.getProductDetailsByName(prodname);

		ProductsJson productsJson = new ProductsJson();
		productsJson.setProductsVOs(productsList);
		return productsJson;

		// return productsList;
	}

	@RequestMapping("/products/{prodid}")
	public ProductsJson getProductDetailsByID(@PathVariable String prodid) {
		List<ProductsVO> productsList = ecommerceService.getProductDetailsByID(prodid);
		ProductsJson productsJson = new ProductsJson();
		productsJson.setProductsVOs(productsList);
		return productsJson;

		// return productVO;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/product")
	public void addProducts(@RequestBody ProductsPO productsPO) {
		ecommerceService.addProduct(productsPO);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/manufacturer")
	public void addManfacture(@RequestBody ManufacturerPO manufacturerPO) {
		ecommerceService.addManufacturer(manufacturerPO);

	}
}
