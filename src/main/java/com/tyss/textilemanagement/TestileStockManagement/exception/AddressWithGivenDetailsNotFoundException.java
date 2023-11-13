package com.tyss.textilemanagement.TestileStockManagement.exception;

public class AddressWithGivenDetailsNotFoundException extends RuntimeException {
	String message = "";

	public AddressWithGivenDetailsNotFoundException() {

		message = "Address with given detail not found";
	}

	@Override
	public String getMessage() {
		return message;
	}

}
