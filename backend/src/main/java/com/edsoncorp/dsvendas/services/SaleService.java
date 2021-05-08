package com.edsoncorp.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edsoncorp.dsvendas.entities.Sale;
import com.edsoncorp.dsvendas.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	public List<Sale> findAll(){
		return (List<Sale>) repository.findAll();
	}
}
