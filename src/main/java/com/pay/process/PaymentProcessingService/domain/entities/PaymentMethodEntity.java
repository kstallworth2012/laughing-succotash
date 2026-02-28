package com.pay.process.PaymentProcessingService.domain.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Table(name = "paymentmethod") 
public class PaymentMethodEntity {

	
	 @Id
	 private UUID payment_method_id; // PRIMARY KEY,
	 @OneToMany
	 @JoinColumn
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
