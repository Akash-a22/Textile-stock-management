package com.tyss.textilemanagement.TestileStockManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.textilemanagement.TestileStockManagement.dao.AddressDao;
import com.tyss.textilemanagement.TestileStockManagement.dto.Address;
import com.tyss.textilemanagement.TestileStockManagement.entity.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private ResponseStructure<Address> structure;
	@Autowired
	private AddressDao dao;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		Address dbAddress = dao.saveAddress(address);
		structure.setData(dbAddress);
		structure.setMessage("Saved");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Address>> getAddressById(int id) {

		Address dbAddress = dao.getAddressById(id);
		structure.setData(dbAddress);
		structure.setMessage("Found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address) {
		Address dbAddress = dao.updateAddress(address);
		structure.setData(address);
		structure.setMessage("Updated");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Address>> removeAddress(int id) {
	    dao.removeAddress(id);
		structure.setData(null);
		structure.setMessage("Removed");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.OK);
	
	}

}
