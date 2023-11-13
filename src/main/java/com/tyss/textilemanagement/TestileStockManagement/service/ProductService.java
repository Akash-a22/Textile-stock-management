package com.tyss.textilemanagement.TestileStockManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.textilemanagement.TestileStockManagement.dao.ProductDao;
import com.tyss.textilemanagement.TestileStockManagement.dto.Product;
import com.tyss.textilemanagement.TestileStockManagement.entity.ResponseStructure;

@Service
public class ProductService {
	@Autowired
	private ResponseStructure<Product> structure;
	
	@Autowired
	private ResponseStructure<List<Product>> listStructure;
	
	@Autowired
	private ProductDao dao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		Product dbProduct = dao.saveProduct(product);
		structure.setData(dbProduct);
		structure.setMessage("Saved");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Product>> getProductById(int id) {

		Product dbProduct = dao.getProductById(id);
		structure.setData(dbProduct);
		structure.setMessage("Found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product) {
		Product dbProduct = dao.updateProduct(product);
		structure.setData(dbProduct);
		structure.setMessage("Updated");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Product>> removeProduct(int id) {
	    dao.removeProduct(id);
		structure.setData(null);
		structure.setMessage("Removed");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);
	
	}

	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts() {
		List<Product> dbProduct = dao.getAllProducts();
		
		listStructure.setData(dbProduct);
		listStructure.setMessage("Found");
		listStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Product>>>(listStructure, HttpStatus.OK);
		
	}

}
