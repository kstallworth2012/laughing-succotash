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


import com.pay.process.PaymentProcessingService.domain.dto.PaymentMethodDTO;
import com.pay.process.PaymentProcessingService.domain.entities.PaymentMethodEntity;
import com.pay.process.PaymentProcessingService.mappers.Mapper;
import com.pay.process.PaymentProcessingService.services.PaymentMethodService;

@RestController
@RequestMapping("/api/payment-methods")
public class PaymentMethodController {
	
	
	
  	private PaymentMethodService _paymentMethodService;
	private Mapper<PaymentMethodEntity,PaymentMethodDTO> _paymentMethodMapper;
	
	
	public PaymentMethodController(PaymentMethodService _paymentMethodService,
			Mapper<PaymentMethodEntity, PaymentMethodDTO> _paymentMethodMapper) {
		this._paymentMethodService = _paymentMethodService;
		this._paymentMethodMapper = _paymentMethodMapper;
	}
	
	
	
	
	 @GetMapping(path = "/")
	 public List<PaymentMethodDTO> listPaymentMethods(){
	    	 List<PaymentMethodEntity> paymentMethods = _paymentMethodService.findAll();
	    	 return paymentMethods.stream().map(_paymentMethodMapper::mapTo).collect(Collectors.toList());
	    			 }
	
	
     
	   
	   
	   
	   	 @GetMapping(path = "/{payment-method_id}")
	     public ResponseEntity<PaymentMethodDTO> getPaymentMethod(@PathVariable("paymentMethod_id") UUID id){
	    	 Optional<PaymentMethodEntity> foundPaymentMethod = _paymentMethodService.findOne(id);
	    	 return foundPaymentMethod.map(paymentMethodEntity ->{
	    		 PaymentMethodDTO paymentMethodDTO = _paymentMethodMapper.mapTo(paymentMethodEntity);
	    		 return new ResponseEntity<>(paymentMethodDTO, HttpStatus.OK);
	    	 
	    	 }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	     }
	       
	   
	   
	   
	   
	      
	   
	     
	    //PAGEABLE
//	@GetMapping(path="/")
//	public Page<PaymentMethodDTO> listPaymentMethods(Pageable page){
//		Page<PaymentMethodEntity> paymentMethods = _paymentMethodService.findAll(page);
//		return paymentMethods.map(_paymentMethodMapper::mapTo);
//	}
	   
	    @PostMapping(path = "/new-payment-method")
	     public ResponseEntity<PaymentMethodDTO> createPaymentMethod(@RequestBody PaymentMethodDTO _paymentMethodDTO){
	          
	     			PaymentMethodEntity paymentMethodEntity = _paymentMethodMapper.mapFrom(_paymentMethodDTO);
	     	     	PaymentMethodEntity savedPaymentMethodEntity = _paymentMethodService.create(paymentMethodEntity);
	     	     	return new ResponseEntity<>(_paymentMethodMapper.mapTo(savedPaymentMethodEntity), HttpStatus.CREATED);
	     }
	 
	 
	@PutMapping(path="/{id}")
	public ResponseEntity<PaymentMethodDTO> fullUpdatePaymentMethod(@PathVariable("id") UUID id, @RequestBody PaymentMethodDTO paymentMethodDto){
		
		if(!_paymentMethodService.isExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		paymentMethodDto.setPayment_method_id(id);
		PaymentMethodEntity paymentMethodEntity = _paymentMethodMapper.mapFrom(paymentMethodDto);
		PaymentMethodEntity savedPaymentMethodEntity = _paymentMethodService.save(paymentMethodEntity);
		
		return new ResponseEntity<>(_paymentMethodMapper.mapTo(savedPaymentMethodEntity), HttpStatus.OK); 
		
	}	
	
	
	
	@PatchMapping(path ="/{id}")
	public ResponseEntity<PaymentMethodDTO> partialUpdate(@PathVariable("id") UUID id, @RequestBody PaymentMethodDTO appDto){
		
		if(!_paymentMethodService.isExists(id)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		PaymentMethodEntity paymentMethodEntity = _paymentMethodMapper.mapFrom(appDto);
		PaymentMethodEntity updatedPaymentMethod = _paymentMethodService.partialUpdate(id, paymentMethodEntity);
		
		return new ResponseEntity<>(_paymentMethodMapper.mapTo(updatedPaymentMethod), HttpStatus.OK);
		
		
		
	}
	
	     
	     
     
	     
	
	
	 
	 
	 
	 
	 
    @DeleteMapping(path="/{id}")
	public ResponseEntity<PaymentMethodDTO> deletePaymentMethods(@PathVariable("id") UUID id) {
		
		_paymentMethodService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	

}
