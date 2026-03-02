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


import com.pay.process.PaymentProcessingService.domain.dto.TransactionEventDTO;
import com.pay.process.PaymentProcessingService.domain.entities.TransactionEventEntity;
import com.pay.process.PaymentProcessingService.mappers.Mapper;
import com.pay.process.PaymentProcessingService.services.TransactionEventService;

@RestController
@RequestMapping("/api/transaction-events")
public class TransactionEventController {

	
	
  	private TransactionEventService _transactionEventService;
	private Mapper<TransactionEventEntity,TransactionEventDTO> _transactionEventMapper;
	
	public TransactionEventController(TransactionEventService _transactionEventService,
			Mapper<TransactionEventEntity, TransactionEventDTO> _transactionEventMapper) {
		this._transactionEventService = _transactionEventService;
		this._transactionEventMapper = _transactionEventMapper;
	}
	
	
	
	
	
	 @GetMapping(path = "/")
	 public List<TransactionEventDTO> listTransactionEvents(){
	    	 List<TransactionEventEntity> transactionEvents = _transactionEventService.findAll();
	    	 return transactionEvents.stream().map(_transactionEventMapper::mapTo).collect(Collectors.toList());
	    			 }
	
	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<TransactionEventDTO> deleteTransactionEvent(@PathVariable("id") UUID id) {
		
		_transactionEventService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
