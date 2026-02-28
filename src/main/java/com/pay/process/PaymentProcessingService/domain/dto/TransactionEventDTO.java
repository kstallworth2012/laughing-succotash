package com.pay.process.PaymentProcessingService.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.pay.process.PaymentProcessingService.domain.entities.TransactionEntity;
import com.pay.process.PaymentProcessingService.enums.TransactionEventType;

import jakarta.persistence.JoinColumn;

public class TransactionEventDTO {

	  private UUID transactionEvent_id;
	  
	  private TransactionEntity transaction_id;
	  private TransactionEventType  event_type;
	  private String gateway_event_id; //?
	  private Integer amount_cents;
	  private LocalDateTime timestamp; 
	  private String metadata;
	public UUID getTransactionEvent_id() {
		return transactionEvent_id;
	}
	public void setTransactionEvent_id(UUID transactionEvent_id) {
		this.transactionEvent_id = transactionEvent_id;
	}
	public TransactionEntity getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(TransactionEntity transaction_id) {
		this.transaction_id = transaction_id;
	}
	public TransactionEventType getEvent_type() {
		return event_type;
	}
	public void setEvent_type(TransactionEventType event_type) {
		this.event_type = event_type;
	}
	public String getGateway_event_id() {
		return gateway_event_id;
	}
	public void setGateway_event_id(String gateway_event_id) {
		this.gateway_event_id = gateway_event_id;
	}
	public Integer getAmount_cents() {
		return amount_cents;
	}
	public void setAmount_cents(Integer amount_cents) {
		this.amount_cents = amount_cents;
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
