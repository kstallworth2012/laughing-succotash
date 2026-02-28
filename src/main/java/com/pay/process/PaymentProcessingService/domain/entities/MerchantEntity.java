package com.pay.process.PaymentProcessingService.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "merchant") 
public class MerchantEntity {

	
	  private UUID merchant_id; //PRIMARY KEY,
	  private String name; //VARCHAR NOT NULL,
	  private String email; //VARCHAR,
	  private LocalDateTime created_at; //TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	  private Integer balance_cents; //INTEGER DEFAULT 0
	public UUID getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(UUID merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
