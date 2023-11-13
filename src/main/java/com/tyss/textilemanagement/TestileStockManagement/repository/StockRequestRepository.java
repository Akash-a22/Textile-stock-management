package com.tyss.textilemanagement.TestileStockManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.tyss.textilemanagement.TestileStockManagement.dto.StockRequest;

@Component
public interface StockRequestRepository extends JpaRepository<StockRequest,Integer>{
	

}
