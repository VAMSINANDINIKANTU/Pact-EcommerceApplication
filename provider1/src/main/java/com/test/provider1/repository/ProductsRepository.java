package com.test.provider1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.provider1.model.po.ManufacturerPO;
import com.test.provider1.model.po.ProductsPO;

@Repository
public interface ProductsRepository  extends  CrudRepository<ProductsPO, String> {

	public Optional<List<ProductsPO>> findAllByManufacturer(ManufacturerPO manufacturer);
	
	public Optional<List<ProductsPO>> findAllByProductName(String prodname);
	
	public Optional<List<ProductsPO>> findAllByProductType(String prodtype);
	
	
}