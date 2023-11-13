package com.tyss.textilemanagement.TestileStockManagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.textilemanagement.TestileStockManagement.dto.StockRequest;
import com.tyss.textilemanagement.TestileStockManagement.exception.StockRequestWithGivenDetailsNotFoundException;
import com.tyss.textilemanagement.TestileStockManagement.repository.StockRequestRepository;

@Repository
public class StockRequestDao {
	@Autowired
	private StockRequestRepository repository;

	public StockRequest saveStockRequest(StockRequest stockRequest) {
		repository.save(stockRequest);
		return stockRequest;
	}

	public StockRequest getStockRequestById(int id) {
		Optional<StockRequest> dbStockRequest = repository.findById(id);

		if (dbStockRequest.isPresent()) {
			return dbStockRequest.get();
		}

		throw new StockRequestWithGivenDetailsNotFoundException();

	}

	public StockRequest updateStockRequest(StockRequest stockRequest) {
		int id = stockRequest.getId();
		Optional<StockRequest> dbStockRequest = repository.findById(id);
		if (dbStockRequest.isPresent()) {
			repository.save(stockRequest);
			return dbStockRequest.get();
		}
		throw new StockRequestWithGivenDetailsNotFoundException();
	}

	public boolean removeStockRequest(int id) {
		Optional<StockRequest> dbStockRequest = repository.findById(id);

		if (dbStockRequest.isPresent()) {
			repository.delete(dbStockRequest.get());
			return true;
		}
		throw new StockRequestWithGivenDetailsNotFoundException();
	}
	
	public List<StockRequest> getAllStockRequest() {
		List<StockRequest> list= repository.findAll();
		
		if(!list.isEmpty() && list != null) {
			return list;
		}
		throw new StockRequestWithGivenDetailsNotFoundException();
	}

}
