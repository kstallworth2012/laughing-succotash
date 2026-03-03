package com.pay.process.PaymentProcessingService.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
		 @GetMapping(path = "/{merchant_id}")
	     public ResponseEntity<MerchantDTO> getMerchant(@PathVariable("activity_id") UUID id){
	    	 Optional<MerchantEntity> foundMerchant = _merchantService.findOne(id);
	    	 return foundMerchant.map(merchantEntity ->{
	    		 MerchantDTO merchantDTO = _merchantMapper.mapTo(merchantEntity);
	    		 return new ResponseEntity<>(merchantDTO, HttpStatus.OK);
	    	 
	    	 }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	     }
	     
	    
	     
	    //PAGEABLE
//	@GetMapping(path="/")
//	public Page<MerchantDTO> listMerchants(Pageable page){
//		Page<MerchantEntity> merchants = _merchantService.findAll(page);
//		return merchants.map(_merchantMapper::mapTo);
//	}
	   
	    @PostMapping(path = "/new-merchant")
	     public ResponseEntity<MerchantDTO> createMerchant(@RequestBody MerchantDTO _merchantDTO){
	          
	     			MerchantEntity merchantEntity = _merchantMapper.mapFrom(_merchantDTO);
	     	     	MerchantEntity savedMerchantEntity = _merchantService.create(merchantEntity);
	     	     	return new ResponseEntity<>(_merchantMapper.mapTo(savedMerchantEntity), HttpStatus.CREATED);
	     }
	 
	 
	@PutMapping(path="/{id}")
	public ResponseEntity<MerchantDTO> fullUpdateMerchant(@PathVariable("id") UUID id, @RequestBody MerchantDTO merchantDto){
		
		if(!_merchantService.isExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		merchantDto.setMerchant_id(id);
		MerchantEntity merchantEntity = _merchantMapper.mapFrom(merchantDto);
		MerchantEntity savedMerchantEntity = _merchantService.save(merchantEntity);
		
		return new ResponseEntity<>(_merchantMapper.mapTo(savedMerchantEntity), HttpStatus.OK); 
		
	}	
	
	
	
	@PatchMapping(path ="/{id}")
	public ResponseEntity<MerchantDTO> partialUpdate(@PathVariable("id") UUID id, @RequestBody MerchantDTO appDto){
		
		if(!_merchantService.isExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		MerchantEntity merchantEntity = _merchantMapper.mapFrom(appDto);
		MerchantEntity updatedMerchant = _merchantService.partialUpdate(id, merchantEntity);
		
		return new ResponseEntity<>(_merchantMapper.mapTo(updatedMerchant), HttpStatus.OK);
		
		
		
	}
	
	     
	     
	     
	     
	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<MerchantDTO> deleteMerchant(@PathVariable("id") UUID id) {
		
		_merchantService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
