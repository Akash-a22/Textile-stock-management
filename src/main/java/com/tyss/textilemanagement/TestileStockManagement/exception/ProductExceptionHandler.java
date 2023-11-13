package com.tyss.textilemanagement.TestileStockManagement.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tyss.textilemanagement.TestileStockManagement.entity.ResponseStructure;


@ControllerAdvice
public class ProductExceptionHandler {
	@Autowired
	private ResponseStructure<String> structure;

	@ExceptionHandler(ProductWithGivenNameIsAlreadyExist.class)
	public ResponseEntity<ResponseStructure<String>> saveProduct(ProductWithGivenNameIsAlreadyExist exist) {
		structure.setData(null);
		structure.setMessage(exist.getMessage());
		structure.setStatusCode(HttpStatus.NO_CONTENT.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(ProductWithGivenDetailsNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> getProduct(ProductWithGivenDetailsNotFoundException exist) {
		structure.setData(null);
		structure.setMessage(exist.getMessage());
		structure.setStatusCode(HttpStatus.NO_CONTENT.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NO_CONTENT);
	}

	

}
