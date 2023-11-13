package com.tyss.textilemanagement.TestileStockManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.textilemanagement.TestileStockManagement.dao.StockRequestDao;
import com.tyss.textilemanagement.TestileStockManagement.dto.StockRequest;
import com.tyss.textilemanagement.TestileStockManagement.entity.ResponseStructure;

@Service
public class StockRequestService {
	@Autowired
	private ResponseStructure<StockRequest> structure;
	@Autowired
	private StockRequestDao dao;
	@Autowired
	private ResponseStructure<List<StockRequest>> listStructure;

	public ResponseEntity<ResponseStructure<StockRequest>> saveStockRequest(StockRequest stockRequest) {
		StockRequest dbstockRequest = dao.saveStockRequest(stockRequest);
		structure.setData(dbstockRequest);
		structure.setMessage("Saved");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<StockRequest>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<StockRequest>> getStockRequestById(int id) {

		StockRequest dbstockRequest = dao.getStockRequestById(id);
		structure.setData(dbstockRequest);
		structure.setMessage("Found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<StockRequest>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<StockRequest>> updateStockRequest(StockRequest stockRequest) {
		StockRequest dbstockRequest = dao.updateStockRequest(stockRequest);
		structure.setData(dbstockRequest);
		structure.setMessage("Updated");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<StockRequest>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<StockRequest>> removeStockRequest(int id) {
	    dao.removeStockRequest(id);
		structure.setData(null);
		structure.setMessage("Removed");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<StockRequest>>(structure, HttpStatus.OK);
	
	}
	
	public ResponseEntity<ResponseStructure<List<StockRequest>>> getAllStockRequest() {
		List<StockRequest> dbStockRequests= dao.getAllStockRequest();
		
		listStructure.setData(dbStockRequests);
		listStructure.setMessage("Found");
		listStructure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<StockRequest>>>(listStructure, HttpStatus.OK);
		
	}

}
