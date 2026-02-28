package com.pay.process.PaymentProcessingService.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.pay.process.PaymentProcessingService.domain.entities.TransactionEntity;

public class TransactionLogDTO {

	
	
	  private UUID transaction_log_id; //PRIMARY KEY,
	  private TransactionEntity transaction_id; // UUID REFERENCES Transaction(id),
	  //event VARCHAR NOT NULL,           -- 'initiated', 'authorized', 'captured', 'refunded'
	  private LocalDateTime timestamp; // TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	  private String metadata;// JSONB
	public UUID getTransaction_log_id() {
		return transaction_log_id;
	}
	public void setTransaction_log_id(UUID transaction_log_id) {
		this.transaction_log_id = transaction_log_id;
	}
	public TransactionEntity getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(TransactionEntity transaction_id) {
		this.transaction_id = transaction_id;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMetadata() {
		return metadata;
	}
	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	  
	  
	  
	  
}
