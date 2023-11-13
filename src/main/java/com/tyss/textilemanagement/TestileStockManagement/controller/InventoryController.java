package com.tyss.textilemanagement.TestileStockManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tyss.textilemanagement.TestileStockManagement.dto.Inventory;
import com.tyss.textilemanagement.TestileStockManagement.entity.ResponseStructure;
import com.tyss.textilemanagement.TestileStockManagement.service.InventoryService;

@RestController
public class InventoryController {
	@Autowired
	private InventoryService service;

	@PostMapping("/saveInventory")
	public ResponseEntity<ResponseStructure<Inventory>> saveInventory(@RequestBody Inventory inventory) {
		return service.saveInventory(inventory);
	}

	@PutMapping("/updateInventory")
	public ResponseEntity<ResponseStructure<Inventory>> updateInventory(@RequestBody Inventory inventory) {
		return service.updateInventory(inventory);
	}

	@DeleteMapping("/removeInventory")
	public ResponseEntity<ResponseStructure<Inventory>> removeInventory(@RequestParam int id) {
		return service.removeInventory(id);
	}

	@PostMapping("/assignInventory")
	public ResponseEntity<ResponseStructure<Inventory>> assignInventory(@RequestParam int i_id,
			@RequestParam int u_id) {
		return service.assignInventory(i_id, u_id);
	}

	@GetMapping("/getAllInventory")
	public ResponseEntity<ResponseStructure<List<Inventory>>> GetAllInventory() {
		return service.findAllInventory();
	}

	@GetMapping("/getInventoryById")
	public ResponseEntity<ResponseStructure<Inventory>> findInventoryById(@RequestParam int id) {
		return service.findInventoryById(id);
	}

}
