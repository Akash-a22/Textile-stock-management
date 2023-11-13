package com.tyss.textilemanagement.TestileStockManagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.textilemanagement.TestileStockManagement.dto.Product;
import com.tyss.textilemanagement.TestileStockManagement.exception.ProductWithGivenNameIsAlreadyExist;
import com.tyss.textilemanagement.TestileStockManagement.repository.ProductRepository;


@Repository
public class ProductDao {
	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		Product dbProduct = repository.findByName(product.getName());
		if (dbProduct == null) {
			repository.save(product);
			return product;
		}
		throw new ProductWithGivenNameIsAlreadyExist();

	}

}
