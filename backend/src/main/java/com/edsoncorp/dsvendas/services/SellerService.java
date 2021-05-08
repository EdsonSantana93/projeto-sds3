package com.edsoncorp.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edsoncorp.dsvendas.dto.SellerDTO;
import com.edsoncorp.dsvendas.entities.Seller;
import com.edsoncorp.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;

	public List<SellerDTO> findAll() {
		List<Seller> sellers = (List<Seller>) repository.findAll();
		return sellers.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
