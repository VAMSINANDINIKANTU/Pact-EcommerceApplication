package com.test.provider1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.test.provider1.model.po.ManufacturerPO;

public interface ManufacturerRepository extends CrudRepository<ManufacturerPO,String> {

	public Optional<List<ManufacturerPO>> findAllByManufacturerName(String manufacturername);
}
