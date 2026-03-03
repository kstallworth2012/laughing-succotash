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
	
	  
	   
	   
   	 @GetMapping(path = "/{log_id}")
     public ResponseEntity<TransactionLogDTO> getTransactionLog(@PathVariable("log_id") UUID id){
    	 Optional<TransactionLogEntity> foundTransactionLog = _transactionLogService.findOne(id);
    	 return foundTransactionLog.map(transactionLogEntity ->{
    		 TransactionLogDTO TransactionLogDTO = _transactionLogMapper.mapTo(transactionLogEntity);
    		 return new ResponseEntity<>(TransactionLogDTO, HttpStatus.OK);
    	 
    	 }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
     }
     
   
   
   
	
   
      
   
     
    //PAGEABLE
//@GetMapping(path="/")
//public Page<TransactionLogDTO> list_TransactionLogs(Pageable page){
//	Page<TransactionLogEntity> _transactionLogs = _transactionLogService.findAll(page);
//	return _transactionLogs.map(_transactionLogMapper::mapTo);
//}
   
   	 @PostMapping(path = "/new-transaction-log")
     public ResponseEntity<TransactionLogDTO> createTransactionLog(@RequestBody TransactionLogDTO _transactionLogDTO){
          
     			TransactionLogEntity TransactionLogEntity = _transactionLogMapper.mapFrom(_transactionLogDTO);
     	     	TransactionLogEntity savedTransactionLogEntity = _transactionLogService.create(TransactionLogEntity);
     	     	return new ResponseEntity<>(_transactionLogMapper.mapTo(savedTransactionLogEntity), HttpStatus.CREATED);
     }
    
 
@PutMapping(path="/{id}")
public ResponseEntity<TransactionLogDTO> fullUpdatesavedTransactionLogs(@PathVariable("id") UUID id, @RequestBody TransactionLogDTO _transactionLogDTO){
	
	if(!_transactionLogService.isExists(id)) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	_transactionLogDTO.setTransaction_log_id(id);
	TransactionLogEntity TransactionLogEntity = _transactionLogMapper.mapFrom(_transactionLogDTO);
	TransactionLogEntity savedTransactionLogEntity = _transactionLogService.save(TransactionLogEntity);
	
	return new ResponseEntity<>(_transactionLogMapper.mapTo(savedTransactionLogEntity), HttpStatus.OK); 
	
}	



@PatchMapping(path ="/{id}")
public ResponseEntity<TransactionLogDTO> partialUpdate(@PathVariable("id") UUID id, @RequestBody TransactionLogDTO appDto){
	
	if(!_transactionLogService.isExists(id)) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	TransactionLogEntity transactionLogEntity = _transactionLogMapper.mapFrom(appDto);
	TransactionLogEntity updatedTransactionLog = _transactionLogService.partialUpdate(id, transactionLogEntity);
	
	return new ResponseEntity<>(_transactionLogMapper.mapTo(updatedTransactionLog), HttpStatus.OK);
	
	
	
}

     
     
    
     
	
	
	
	
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<TransactionLogDTO> deleteTransactionLog(@PathVariable("id") UUID id) {
		
		_transactionLogService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
