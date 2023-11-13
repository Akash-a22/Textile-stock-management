package com.tyss.textilemanagement.TestileStockManagement.exception;

public class OneUserWithGivenRoleIsAlreadyPresentException extends RuntimeException {

	String message;

	public OneUserWithGivenRoleIsAlreadyPresentException() {
		message = "user with given role is already exist";
	}

	public String getMessage() {
		return message;
	}

}
