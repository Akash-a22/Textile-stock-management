package com.tyss.textilemanagement.TestileStockManagement.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.textilemanagement.TestileStockManagement.dto.Address;
import com.tyss.textilemanagement.TestileStockManagement.exception.AddressWithGivenDetailsNotFoundException;
import com.tyss.textilemanagement.TestileStockManagement.repository.AddressRepository;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepository repository;

	public Address saveAddress(Address address) {
		repository.save(address);
		return address;
	}

	public Address getAddressById(int id) {
		Optional<Address> dbAddress = repository.findById(id);

		if (dbAddress.isPresent()) {
			return dbAddress.get();
		}

		throw new AddressWithGivenDetailsNotFoundException();
	}
	
	public Address updateAddress(Address address) {
		int id=address.getId();
		Optional<Address> dbAddress = repository.findById(id);
		if (dbAddress.isPresent()) {
			repository.save(address);
			return address;
		}
		throw new AddressWithGivenDetailsNotFoundException();
	}
	
	public boolean removeAddress(int id) {
		Optional<Address> dbAddress= repository.findById(id);

		if (dbAddress.isPresent()) {
			repository.delete(dbAddress.get());
			return true;
		}

		throw new AddressWithGivenDetailsNotFoundException();
	}

}
