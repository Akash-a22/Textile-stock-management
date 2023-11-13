package com.tyss.textilemanagement.TestileStockManagement.exception;

public class ProductWithGivenDetailsNotFoundException extends RuntimeException{
	String message = "";

	public ProductWithGivenDetailsNotFoundException() {

		message = "product with given detail not found";
	}

	@Override
	public String getMessage() {
		return message;
	}
}
