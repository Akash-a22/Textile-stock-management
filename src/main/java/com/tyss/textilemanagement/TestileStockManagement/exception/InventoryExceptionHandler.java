package com.tyss.textilemanagement.TestileStockManagement.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tyss.textilemanagement.TestileStockManagement.entity.ResponseStructure;
@ControllerAdvice
public class InventoryExceptionHandler extends ResponseEntityExceptionHandler {
	@Autowired
	private ResponseStructure<String> structure;
	
	@ExceptionHandler(InventoryAssignmentIsNotPossible.class)
	public ResponseEntity<ResponseStructure<String>> assginInventory(InventoryAssignmentIsNotPossible exception) {
		structure.setData(null);
		structure.setMessage(exception.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

}
