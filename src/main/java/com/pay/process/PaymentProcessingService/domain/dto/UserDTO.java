package com.pay.process.PaymentProcessingService.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserDTO {

	
	  private UUID user_id; //PRIMARY KEY,
	  private String email; // VARCHAR NOT NULL,
	  private String phone; // VARCHAR,
	  private LocalDateTime created_at; // TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	  private Integer balance_cents; // INTEGER DEFAULT 0
	public UUID getUser_id() {
		return user_id;
	}
	public void setUser_id(UUID user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public Integer getBalance_cents() {
		return balance_cents;
	}
	public void setBalance_cents(Integer balance_cents) {
		this.balance_cents = balance_cents;
	}
	  
	  
}
