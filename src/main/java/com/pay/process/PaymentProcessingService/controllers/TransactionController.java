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
	
	 
	 
	  
	   
	   
   	 @GetMapping(path = "/{transaction_id}")
     public ResponseEntity<TransactionDTO> getTransaction(@PathVariable("transaction_id") UUID id){
    	 Optional<TransactionEntity> foundTransaction = _transactionService.findOne(id);
    	 return foundTransaction.map(transactionEntity ->{
    		 TransactionDTO transactionDTO = _transactionMapper.mapTo(transactionEntity);
    		 return new ResponseEntity<>(transactionDTO, HttpStatus.OK);
    	 
    	 }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
     }
     
   
   
   
   
      
   
     
    //PAGEABLE
//@GetMapping(path="/")
//public Page<TransactionDTO> listTransactions(Pageable page){
//	Page<TransactionEntity> activities = _transactionService.findAll(page);
//	return activities.map(_transactionMapper::mapTo);
//}
   
    @PostMapping(path = "/new-transaction")
     public ResponseEntity<TransactionDTO> createActivity(@RequestBody TransactionDTO _transactionDTO){
          
     			TransactionEntity transactionEntity = _transactionMapper.mapFrom(_transactionDTO);
     	     	TransactionEntity savedTransactionEntity = _transactionService.create(transactionEntity);
     	     	return new ResponseEntity<>(_transactionMapper.mapTo(savedTransactionEntity), HttpStatus.CREATED);
     }
 
 
@PutMapping(path="/{id}")
public ResponseEntity<TransactionDTO> fullUpdateTransaction(@PathVariable("id") UUID id, @RequestBody TransactionDTO transactionDTO){
	
	if(!_transactionService.isExists(id)) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	transactionDTO.setId(id);
	TransactionEntity transactionEntity = _transactionMapper.mapFrom(transactionDTO);
	TransactionEntity savedTransactionEntity = _transactionService.save(transactionEntity);
	
	return new ResponseEntity<>(_transactionMapper.mapTo(savedTransactionEntity), HttpStatus.OK); 
	
}	



@PatchMapping(path ="/{id}")
public ResponseEntity<TransactionDTO> partialUpdate(@PathVariable("id") UUID id, @RequestBody TransactionDTO appDto){
	
	if(!_transactionService.isExists(id)) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	TransactionEntity transactionEntity = _transactionMapper.mapFrom(appDto);
	TransactionEntity updatedTransaction = _transactionService.partialUpdate(id, transactionEntity);
	
	return new ResponseEntity<>(_transactionMapper.mapTo(updatedTransaction), HttpStatus.OK);
	
	
	
}

     
     
    
     
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<TransactionDTO> deleteTransaction(@PathVariable("id") UUID id) {
		
		_transactionService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
}
