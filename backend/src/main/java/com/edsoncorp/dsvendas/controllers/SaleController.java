package com.edsoncorp.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edsoncorp.dsvendas.dto.SaleDTO;
import com.edsoncorp.dsvendas.dto.SaleSuccessDTO;
import com.edsoncorp.dsvendas.dto.SaleSumDTO;
import com.edsoncorp.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;

	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> sales = service.findAll(pageable);

		if (sales != null) {
			return ResponseEntity.ok(sales);
		}

		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
		List<SaleSumDTO> saleAmount = service.amountGroupedBySeller();

		if (saleAmount != null) {
			return ResponseEntity.ok(saleAmount);
		}

		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
		List<SaleSuccessDTO> saleSuccess = service.successGroupedBySeller();

		if (saleSuccess != null) {
			return ResponseEntity.ok(saleSuccess);
		}

		return ResponseEntity.badRequest().build();
	}

}
