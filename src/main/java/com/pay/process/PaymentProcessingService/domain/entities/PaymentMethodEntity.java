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
}
