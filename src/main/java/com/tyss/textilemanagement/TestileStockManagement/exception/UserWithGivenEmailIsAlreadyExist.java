package com.tyss.textilemanagement.TestileStockManagement.exception;

public class UserWithGivenEmailIsAlreadyExist extends RuntimeException {
	String message;

	public UserWithGivenEmailIsAlreadyExist() {
		message = "User with given email is already exist";

	}

	public String getMessage() {
		return message;
	}

}
