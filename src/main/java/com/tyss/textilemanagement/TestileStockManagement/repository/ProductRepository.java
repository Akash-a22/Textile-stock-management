package com.tyss.textilemanagement.TestileStockManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.tyss.textilemanagement.TestileStockManagement.dto.Product;


@Component
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	
	Product findByProductType(String type);

}
