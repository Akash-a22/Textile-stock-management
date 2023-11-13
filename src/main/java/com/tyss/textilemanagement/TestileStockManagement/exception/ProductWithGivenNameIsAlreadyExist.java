package com.tyss.textilemanagement.TestileStockManagement.exception;

public class ProductWithGivenNameIsAlreadyExist extends RuntimeException {
	String message = "";

	public ProductWithGivenNameIsAlreadyExist() {

		message = "product with given type is already exist";
	}

	@Override
	public String getMessage() {
		return message;
	}
}
