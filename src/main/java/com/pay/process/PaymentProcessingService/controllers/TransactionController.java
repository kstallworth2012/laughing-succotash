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

import com.pay.process.PaymentProcessingService.domain.dto.TransactionDTO;
import com.pay.process.PaymentProcessingService.domain.entities.TransactionEntity;
import com.pay.process.PaymentProcessingService.mappers.Mapper;
import com.pay.process.PaymentProcessingService.services.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	
	
  	private TransactionService _transactionService;
	private Mapper<TransactionEntity,TransactionDTO> _transactionMapper;
	
	
	public TransactionController(TransactionService _transactionService,
			Mapper<TransactionEntity, TransactionDTO> _transactionMapper) {
		this._transactionService = _transactionService;
		this._transactionMapper = _transactionMapper;
	}
	
	
	
	
	 @GetMapping(path = "/")
	 public List<TransactionDTO> listTransactions(){
	    	 List<TransactionEntity> transactions = _transactionService.findAll();
	    	 return transactions.stream().map(_transactionMapper::mapTo).collect(Collectors.toList());
	    			 }
	
	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<TransactionDTO> deleteTransaction(@PathVariable("id") UUID id) {
		
		_transactionService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
}
