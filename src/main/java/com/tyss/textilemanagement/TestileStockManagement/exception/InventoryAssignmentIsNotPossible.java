package com.tyss.textilemanagement.TestileStockManagement.exception;

public class InventoryAssignmentIsNotPossible extends RuntimeException {
	String message = "";

	public InventoryAssignmentIsNotPossible() {
		message = "cannot assgin multiple inventory to same user";
	}

	@Override
	public String getMessage() {
		return message;
	}
	


}
