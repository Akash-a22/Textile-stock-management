package com.tyss.textilemanagement.TestileStockManagement.exception;

public class StockRequestWithGivenDetailsNotFoundException extends RuntimeException {
	String message;

	public StockRequestWithGivenDetailsNotFoundException() {
		message = "Stock Request Not Found";
	}

	public String getMessage() {
		return message;
	}

}
