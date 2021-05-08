package com.edsoncorp.dsvendas.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.edsoncorp.dsvendas.entities.Sale;

public interface SaleRepository extends CrudRepository<Sale, Long>{

	Page<Sale> findAll(Pageable pageable);

}
