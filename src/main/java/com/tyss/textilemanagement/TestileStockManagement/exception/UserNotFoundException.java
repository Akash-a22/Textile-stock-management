package com.tyss.textilemanagement.TestileStockManagement.exception;

public class UserNotFoundException extends RuntimeException{
	private String message;
	public UserNotFoundException() {
		message="user not found";
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
