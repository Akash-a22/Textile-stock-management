package com.tyss.textilemanagement.TestileStockManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.tyss.textilemanagement.TestileStockManagement.dto.Inventory;

@Component
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

}
