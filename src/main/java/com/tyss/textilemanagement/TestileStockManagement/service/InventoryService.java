package com.tyss.textilemanagement.TestileStockManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.textilemanagement.TestileStockManagement.dao.InventoryDao;
import com.tyss.textilemanagement.TestileStockManagement.dto.Inventory;
import com.tyss.textilemanagement.TestileStockManagement.dto.User;
import com.tyss.textilemanagement.TestileStockManagement.entity.ResponseStructure;
import com.tyss.textilemanagement.TestileStockManagement.exception.InventoryAssignmentIsNotPossible;
import com.tyss.textilemanagement.TestileStockManagement.exception.NoDataFoundException;

@Service
public class InventoryService {
	@Autowired
	private InventoryDao dao;
	@Autowired
	private ResponseStructure<Inventory> structure;
	@Autowired
	private ResponseStructure<List<Inventory>> listStructure;

	public ResponseEntity<ResponseStructure<Inventory>> saveInventory(Inventory inventory) {
		Inventory dbInventory = dao.saveInventory(inventory);
		structure.setData(inventory);
		structure.setMessage("saved");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Inventory>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Inventory>> assignInventory(int inventory_id, int user_id) {
		Inventory dbInventory = dao.assignInventory(inventory_id, user_id);
		structure.setData(dbInventory);
		structure.setMessage("assigned");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Inventory>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Inventory>> updateInventory(Inventory inventory) {
		dao.updateInventory(inventory);
		structure.setData(inventory);
		structure.setMessage("updated");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Inventory>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Inventory>> removeInventory(int id) {
		dao.removeInventory(id);
		structure.setData(null);
		structure.setMessage("removed");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Inventory>>(structure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<Inventory>> findInventoryById(int id) {
		Inventory dbInventory = dao.findInventoryById(id);
		structure.setData(dbInventory);
		structure.setMessage("found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Inventory>>(structure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<List<Inventory>>> findAllInventory() {

		List<Inventory> dbInventory = dao.findAllInventory();
		listStructure.setData(dbInventory);
		listStructure.setMessage("found");
		listStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Inventory>>>(listStructure, HttpStatus.FOUND);

	}

}
