package com.tyss.textilemanagement.TestileStockManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.textilemanagement.TestileStockManagement.dto.StockRequest;
import com.tyss.textilemanagement.TestileStockManagement.entity.ResponseStructure;
import com.tyss.textilemanagement.TestileStockManagement.service.StockRequestService;

@RestController
public class StockRequestController {
	@Autowired
	private StockRequestService service;

	@PostMapping("/saveStockRequest")
	public ResponseEntity<ResponseStructure<StockRequest>> saveStockRequest(@RequestBody StockRequest stockRequest) {
		return service.saveStockRequest(stockRequest);
	}

	@GetMapping("/getStockRequest")
	public ResponseEntity<ResponseStructure<StockRequest>> getStockRequestById(@RequestParam int id) {
		return service.getStockRequestById(id);

	}

	@PutMapping("/updateStockRequest")
	public ResponseEntity<ResponseStructure<StockRequest>> updateStockRequest(@RequestBody StockRequest stockRequest) {
		return service.updateStockRequest(stockRequest);
	}

	@DeleteMapping("/removeStockRequest")
	public ResponseEntity<ResponseStructure<StockRequest>> removeStockRequest(@RequestParam int id) {
		return service.removeStockRequest(id);

	}

	@GetMapping("/getAllStockRequest")
	public ResponseEntity<ResponseStructure<List<StockRequest>>> getAllStockRequest() {
		return service.getAllStockRequest();

	}

}
