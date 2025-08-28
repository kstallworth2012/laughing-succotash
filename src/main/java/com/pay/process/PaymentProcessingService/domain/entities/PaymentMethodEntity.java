package com.pay.process.PaymentProcessingService.domain.entities;

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
@Table(name = "paymentmethod") 
public class PaymentMethodEntity {

	
	
	 private UUID payment_method_id; // PRIMARY KEY,
	  user_id UUID REFERENCES User(id),
	  method_type VARCHAR NOT NULL,     -- 'card', 'bank_account'
	  details JSONB NOT NULL,           -- encrypted or tokenized
	  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
}
