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
}
