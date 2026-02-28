package com.pay.process.PaymentProcessingService.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.pay.process.PaymentProcessingService.domain.entities.UserEntity;


public class PaymentMethodDTO {

	
	
	
	 
	 private UUID payment_method_id; // PRIMARY KEY,

	 private UserEntity user_id; // UUID REFERENCES User(id),
	 // method_type //VARCHAR NOT NULL,     -- 'card', 'bank_account'
	 private String JSONB; // NOT NULL,           -- encrypted or tokenized
	 private LocalDateTime created_at; //TIMESTAMP DEFAULT CURRENT_TIMESTAMP
	 
	 
	public UUID getPayment_method_id() {
		return payment_method_id;
	}
	public void setPayment_method_id(UUID payment_method_id) {
		this.payment_method_id = payment_method_id;
	}
	public UserEntity getUser_id() {
		return user_id;
	}
	public void setUser_id(UserEntity user_id) {
		this.user_id = user_id;
	}
	public String getJSONB() {
		return JSONB;
	}
	public void setJSONB(String jSONB) {
		JSONB = jSONB;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	 
	 
	 
	 
}
