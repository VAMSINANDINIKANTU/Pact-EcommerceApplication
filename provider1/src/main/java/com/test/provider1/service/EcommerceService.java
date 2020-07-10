package com.test.provider1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.provider1.model.mapper.Mapper;
import com.test.provider1.model.po.ManufacturerPO;
import com.test.provider1.model.po.ProductsPO;
import com.test.provider1.model.vo.ManufacturerVO;
import com.test.provider1.model.vo.ProductsVO;
import com.test.provider1.repository.ManufacturerRepository;
import com.test.provider1.repository.ProductsRepository;

@Service
public class EcommerceService {

	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private ManufacturerRepository manufacturerRepository;

	// Product services

	public List<ProductsVO> getAllProducts() {
		
		List<ProductsPO> product = (List<ProductsPO>) productsRepository.findAll();
		
		List<ProductsVO> productVOList = new ArrayList<ProductsVO>();
		for (ProductsPO prod : product) {
			ManufacturerPO manufacturer = prod.getManufacturer();
			ProductsVO productVO = Mapper.toProductVO(prod, manufacturer);
			productVOList.add(productVO);
		}
		
		return productVOList;
	}
	
	

	public ProductsVO getProductDetailsByID(String id) {

		Optional<ProductsPO> product = productsRepository.findById(id);
		ManufacturerPO manufacturer = product.get().getManufacturer();
		
		ProductsVO productVO = Mapper.toProductVO(product.get(), manufacturer);
		return productVO;

	}
	
	public List<ProductsVO> getProductDetailsByType(String prodtype) {

		Optional<List<ProductsPO>> product = productsRepository.findAllByProductType(prodtype);
		
		List<ProductsVO> productVOList = new ArrayList<ProductsVO>();
		for (ProductsPO prod : product.get()) {
			ManufacturerPO manufacturer = prod.getManufacturer();
			ProductsVO productVO = Mapper.toProductVO(prod, manufacturer);
			productVOList.add(productVO);
		}
		
		return productVOList;

	}
	
	public List<ProductsVO> getProductDetailsByName(String prodname) {

		Optional<List<ProductsPO>> product = productsRepository.findAllByProductName(prodname);
		
		List<ProductsVO> productVOList = new ArrayList<ProductsVO>();
		for (ProductsPO prod : product.get()) {
			ManufacturerPO manufacturer = prod.getManufacturer();
			ProductsVO productVO = Mapper.toProductVO(prod, manufacturer);
			productVOList.add(productVO);
		}
		
		return productVOList;

	}
	
	public void postadd(List<ProductsPO> products) {
		productsRepository.saveAll(products);
	}

	public void saveProduct(ProductsVO productVO) {

		Optional<ManufacturerPO> manufacturerOptional = manufacturerRepository
				.findById(productVO.getManufacturerId());

		ManufacturerPO manufacturer = manufacturerOptional.get();

		ProductsPO product = new ProductsPO();
		product.setProductId(productVO.getProductId());
		product.setProductName(productVO.getProductName());
		product.setProductType(productVO.getProductType());
		product.setPrice(productVO.getPrice());
		product.setManufacturer(manufacturer);

		productsRepository.save(product);
	}

	// Manufactures services

	public List<ManufacturerVO> getAllManufactures() {
		List<ManufacturerPO> manufacturerList = (List<ManufacturerPO>) manufacturerRepository.findAll();
		
		List<ManufacturerVO> manufacturerVOList = new ArrayList<ManufacturerVO>();
		for (ManufacturerPO manufacturer : manufacturerList) {
			List<ProductsPO> products = manufacturer.getProducts();
			ManufacturerVO manufacturerVO = Mapper.toManufacturerVO(manufacturer, products);
			manufacturerVOList.add(manufacturerVO);
		}
		
		return manufacturerVOList;
	}
	
	public ManufacturerVO getManufacturerDetailsByID(String manufacturerid) {

		Optional<ManufacturerPO> manufacturer = manufacturerRepository.findById(manufacturerid);
		List<ProductsPO> products = manufacturer.get().getProducts();
		
		ManufacturerVO manufacturerVO = Mapper.toManufacturerVO(manufacturer.get(), products);
		return manufacturerVO;

	}
	
	public List<ManufacturerVO> getManufacturerDetailsByName(String manufacturername) {

		Optional<List<ManufacturerPO>> manufacturerList = manufacturerRepository.findAllByManufacturerName(manufacturername);
		
		List<ManufacturerVO> manufacturerVOList = new ArrayList<ManufacturerVO>();
		for (ManufacturerPO manufacturer : manufacturerList.get()) {
			List<ProductsPO> products = manufacturer.getProducts();
			ManufacturerVO manufacturerVO = Mapper.toManufacturerVO(manufacturer, products);
			manufacturerVOList.add(manufacturerVO);
		}
		
		return manufacturerVOList;

	}

	public void postaddManu(List<ManufacturerPO> manufacturer) {

		manufacturerRepository.saveAll(manufacturer);

	}


}
