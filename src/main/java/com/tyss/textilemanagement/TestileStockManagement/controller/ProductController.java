package com.tyss.textilemanagement.TestileStockManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.textilemanagement.TestileStockManagement.dto.Product;
import com.tyss.textilemanagement.TestileStockManagement.entity.ResponseStructure;
import com.tyss.textilemanagement.TestileStockManagement.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/saveProduct")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}

	@GetMapping("/getProduct")
	public ResponseEntity<ResponseStructure<Product>> getProductById(@RequestParam int id) {
		ResponseEntity<ResponseStructure<Product>> opt = service.getProductById(id);
		return opt;

	}

	@PostMapping("/updateProduct")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	@DeleteMapping("/removeProduct")
	public ResponseEntity<ResponseStructure<Product>> removeProduct(@RequestParam int id) {
		ResponseEntity<ResponseStructure<Product>> opt = service.removeProduct(id);
		return opt;

	}

	@GetMapping("/getAllProducts")
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts() {
		return service.getAllProducts();

	}

}
