package com.edsoncorp.dsvendas.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.edsoncorp.dsvendas.dto.SaleSuccessDTO;
import com.edsoncorp.dsvendas.dto.SaleSumDTO;
import com.edsoncorp.dsvendas.entities.Sale;

public interface SaleRepository extends CrudRepository<Sale, Long>{

	Page<Sale> findAll(Pageable pageable);
	
	@Query("SELECT new com.edsoncorp.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.edsoncorp.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), Sum(obj.deals)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
}
