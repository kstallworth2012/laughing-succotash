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
	
	  
	   
	   
   	 @GetMapping(path = "/{transaction_event_id}")
     public ResponseEntity<TransactionEventDTO> getTransactionEvent(@PathVariable("transaction_event_id") UUID id){
    	 Optional<TransactionEventEntity> foundTransactionEvent = _transactionEventService.findOne(id);
    	 return foundTransactionEvent.map(transactionEventEntity ->{
    		 TransactionEventDTO transactionEventDTO = _transactionEventMapper.mapTo(transactionEventEntity);
    		 return new ResponseEntity<>(transactionEventDTO, HttpStatus.OK);
    	 
    	 }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
     }
     
    
   
   
   
      
   
     
    //PAGEABLE
//@GetMapping(path="/")
//public Page<TransactionEventDTO> listTransactionEvent(Pageable page){
//	Page<TransactionEventEntity> transactionEvents = _transactionEventService.findAll(page);
//	return transactionEvents.map(_transactionEventMapper::mapTo);
//}
   
    @PostMapping(path = "/new-transaction-event")
     public ResponseEntity<TransactionEventDTO> createTransactionEvent(@RequestBody TransactionEventDTO _transactionEventDTO){
          
     			TransactionEventEntity transactionEventEntity = _transactionEventMapper.mapFrom(_transactionEventDTO);
     	     	TransactionEventEntity savedTransactionEventEntity = _transactionEventService.create(transactionEventEntity);
     	     	return new ResponseEntity<>(_transactionEventMapper.mapTo(savedTransactionEventEntity), HttpStatus.CREATED);
     }
 
 
	@PutMapping(path="/{id}")
	public ResponseEntity<TransactionEventDTO> fullUpdateTransactionEvent(@PathVariable("id") UUID id, @RequestBody TransactionEventDTO _transactionEventDTO){
	
	if(!_transactionEventService.isExists(id)) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	_transactionEventDTO.setTransactionEvent_id(id);
	TransactionEventEntity transactionEventEntity = _transactionEventMapper.mapFrom(_transactionEventDTO);
	TransactionEventEntity savedTransactionEventEntity = _transactionEventService.save(transactionEventEntity);
	
	return new ResponseEntity<>(_transactionEventMapper.mapTo(savedTransactionEventEntity), HttpStatus.OK); 
	
}	
 


@PatchMapping(path ="/{id}")
public ResponseEntity<TransactionEventDTO> partialUpdate(@PathVariable("id") UUID id, @RequestBody TransactionEventDTO appDto){
	
	if(!_transactionEventService.isExists(id)) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	TransactionEventEntity transactionEventEntity = _transactionEventMapper.mapFrom(appDto);
	TransactionEventEntity updatedTransactionEventEntity = _transactionEventService.partialUpdate(id, transactionEventEntity);
	
	return new ResponseEntity<>(_transactionEventMapper.mapTo(updatedTransactionEventEntity), HttpStatus.OK);
	
	
	
}

     
     
    
     
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<TransactionEventDTO> deleteTransactionEvent(@PathVariable("id") UUID id) {
		
		_transactionEventService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
}
