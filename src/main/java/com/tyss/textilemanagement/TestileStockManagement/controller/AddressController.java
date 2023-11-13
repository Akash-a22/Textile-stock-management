package com.tyss.textilemanagement.TestileStockManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.textilemanagement.TestileStockManagement.dto.Address;
import com.tyss.textilemanagement.TestileStockManagement.entity.ResponseStructure;
import com.tyss.textilemanagement.TestileStockManagement.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	
	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return service.saveAddress(address);
	}

	@GetMapping("/getAddress")
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@RequestParam int id) {
		ResponseEntity<ResponseStructure<Address>> opt = service.getAddressById(id);
		return opt;

	}
	
	@PutMapping("/updateAddress")
	public ResponseEntity<ResponseStructure<Address>>updateAddress(@RequestBody Address address) {
		return service.updateAddress(address);
	}
	
	@DeleteMapping("/removeAddress")
	public ResponseEntity<ResponseStructure<Address>> removeAddress(@RequestParam int id) {
		ResponseEntity<ResponseStructure<Address>> opt = service.removeAddress(id);
		return opt;

	}

}
