package com.tyss.textilemanagement.TestileStockManagement.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tyss.textilemanagement.TestileStockManagement.entity.ResponseStructure;


@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {
	@Autowired
	private ResponseStructure<String> structure;

//	@ExceptionHandler(UserWithGivenEmailIsAlreadyExist.class)
//	public ResponseEntity<ResponseStructure<String>> email(UserWithGivenEmailIsAlreadyExist exist) {
//		structure.setData(null);
//		structure.setMessage(exist.getMessage());
//		structure.setStatusCode(HttpStatus.NO_CONTENT.value());
//		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NO_CONTENT);
//	}

}
