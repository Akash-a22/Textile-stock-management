package com.tyss.textilemanagement.TestileStockManagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.textilemanagement.TestileStockManagement.dto.Inventory;
import com.tyss.textilemanagement.TestileStockManagement.dto.User;
import com.tyss.textilemanagement.TestileStockManagement.exception.InventoryAssignmentIsNotPossible;
import com.tyss.textilemanagement.TestileStockManagement.exception.NoDataFoundException;
import com.tyss.textilemanagement.TestileStockManagement.repository.InventoryRepository;
import com.tyss.textilemanagement.TestileStockManagement.repository.UserRepository;

@Repository
public class InventoryDao {
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private UserRepository userRepository;

	public Inventory saveInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	public Inventory assignInventory(int inventory_id, int user_id) {

		Optional<Inventory> inventory = inventoryRepository.findById(inventory_id);
		Optional<User> user = userRepository.findById(user_id);
		if (inventory.isPresent() && user.isPresent()) {
			if (user.get().getRole().equals("manager")) {
				throw new InventoryAssignmentIsNotPossible();
			} else if (inventory.get().getUser() == null && user.get().getInventory() == null) {
				inventory.get().setUser(user.get());
				user.get().setInventory(inventory.get());

				inventoryRepository.save(inventory.get());
				userRepository.save(user.get());

				return inventory.get();
			} else {
				throw new InventoryAssignmentIsNotPossible();
			}
		}
		throw new NoDataFoundException();
	}

	public Inventory updateInventory(Inventory inventory) {
		int id = inventory.getId();
		Optional<Inventory> dbInventory = inventoryRepository.findById(id);
		if (dbInventory.isPresent()) {
			return inventoryRepository.save(inventory);

		}
		throw new NoDataFoundException();
	}

	public boolean removeInventory(int id) {

		Optional<Inventory> inventory = inventoryRepository.findById(id);
		if (inventory.isPresent()) {
			inventoryRepository.delete(inventory.get());
			return true;
		}
		throw new NoDataFoundException();

	}

	public Inventory findInventoryById(int id) {

		Optional<Inventory> inventory = inventoryRepository.findById(id);
		if (inventory.isPresent()) {
			return inventory.get();
		}
		throw new NoDataFoundException();

	}

	public List<Inventory> findAllInventory() {

		List<Inventory> inventory = inventoryRepository.findAll();
		if (!inventory.isEmpty() && inventory != null) {
			return inventory;
		}
		throw new NoDataFoundException();

	}

}
