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

import com.pay.process.PaymentProcessingService.domain.dto.TransactionLogDTO;
import com.pay.process.PaymentProcessingService.domain.entities.TransactionLogEntity;
import com.pay.process.PaymentProcessingService.mappers.Mapper;
import com.pay.process.PaymentProcessingService.services.TransactionLogService;

@RestController
@RequestMapping("/api/transaction-logs")
public class TransactionLogController {

	
	
  	private TransactionLogService _transactionLogService;
	private Mapper<TransactionLogEntity,TransactionLogDTO> _transactionLogMapper;
	
	
	public TransactionLogController(TransactionLogService _transactionLogService,
			Mapper<TransactionLogEntity, TransactionLogDTO> _transactionLogMapper) {
		this._transactionLogService = _transactionLogService;
		this._transactionLogMapper = _transactionLogMapper;
	}
	
	

	
	 @GetMapping(path = "/")
	 public List<TransactionLogDTO> listTransactionLogs(){
	    	 List<TransactionLogEntity> transactionLogs = _transactionLogService.findAll();
	    	 return transactionLogs.stream().map(_transactionLogMapper::mapTo).collect(Collectors.toList());
	    			 }
	
	
	
	
	
	
	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<TransactionLogDTO> deleteTransactionLog(@PathVariable("id") UUID id) {
		
		_transactionLogService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
