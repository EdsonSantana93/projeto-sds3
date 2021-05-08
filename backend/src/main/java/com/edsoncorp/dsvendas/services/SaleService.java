package com.edsoncorp.dsvendas.services;

  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edsoncorp.dsvendas.dto.SaleDTO;
import com.edsoncorp.dsvendas.dto.SaleSuccessDTO;
import com.edsoncorp.dsvendas.dto.SaleSumDTO;
import com.edsoncorp.dsvendas.entities.Sale;
import com.edsoncorp.dsvendas.repositories.SaleRepository;
import com.edsoncorp.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> sales = repository.findAll(pageable);
		return sales.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}
}
