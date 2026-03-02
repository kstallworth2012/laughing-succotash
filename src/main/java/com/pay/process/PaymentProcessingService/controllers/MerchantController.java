package com.pay.process.PaymentProcessingService.controllers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.pay.process.PaymentProcessingService.domain.dto.MerchantDTO;
import com.pay.process.PaymentProcessingService.domain.entities.MerchantEntity;
import com.pay.process.PaymentProcessingService.mappers.Mapper;
import com.pay.process.PaymentProcessingService.services.MerchantService;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {
	
	
  	private MerchantService _merchantService;
	private Mapper<MerchantEntity,MerchantDTO> _merchantMapper;
	
	
	public MerchantController(MerchantService _merchantService, Mapper<MerchantEntity, MerchantDTO> _merchantMapper) {
		this._merchantService = _merchantService;
		this._merchantMapper = _merchantMapper;
	}
	
	
	
	
	
	 @GetMapping(path = "/")
	     public List<MerchantDTO> listMerchants(){
	    	 List<MerchantEntity> merchants = _merchantService.findAll();
	    	 return merchants.stream().map(_merchantMapper::mapTo).collect(Collectors.toList());
	    			 }
	
	
	
	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<MerchantDTO> deleteMerchant(@PathVariable("id") UUID id) {
		
		_merchantService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
