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
	
	
	
	
    @DeleteMapping(path="/{id}")
	public ResponseEntity<PaymentMethodDTO> deletePaymentMethods(@PathVariable("id") UUID id) {
		
		_paymentMethodService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	

}
