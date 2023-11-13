package com.tyss.textilemanagement.TestileStockManagement.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.textilemanagement.TestileStockManagement.dto.Product;
import com.tyss.textilemanagement.TestileStockManagement.exception.ProductWithGivenDetailsNotFoundException;
import com.tyss.textilemanagement.TestileStockManagement.exception.ProductWithGivenNameIsAlreadyExist;
import com.tyss.textilemanagement.TestileStockManagement.repository.ProductRepository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		Product dbProduct = repository.findByProductType(product.getProductType());
		if (dbProduct == null) {
			repository.save(product);
			return product;
		}
		throw new ProductWithGivenNameIsAlreadyExist();

	}

	public Product getProduct(int id) {
		Optional<Product> dbProduct = repository.findById(id);

		if (dbProduct != null) {
			return dbProduct.get();
		}

		throw new ProductWithGivenDetailsNotFoundException();
	}

	public Product updateProduct(Product product) {
		Product dbProduct = repository.findByProductType(product.getProductType());
		if (dbProduct != null) {
			repository.save(product);
			return product;
		}
		throw new ProductWithGivenDetailsNotFoundException();
	}
	
	public boolean removeProduct(int id) {
		Optional<Product> dbProduct = repository.findById(id);

		if (dbProduct != null) {
			repository.delete(dbProduct.get());
			return true;
		}

		throw new ProductWithGivenDetailsNotFoundException();
	}

	


}
