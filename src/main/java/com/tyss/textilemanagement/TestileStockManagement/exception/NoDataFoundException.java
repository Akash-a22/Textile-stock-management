package com.tyss.textilemanagement.TestileStockManagement.exception;

public class NoDataFoundException extends RuntimeException {

	String message;

	public NoDataFoundException() {
		message = "no data found";
	}

	public String getMessage() {
		return message;
	}

}
