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
@Table(name = "user")
public class UserEntity {
	  private UUID user_id; //PRIMARY KEY,
	  private String email; // VARCHAR NOT NULL,
	  private String phone; // VARCHAR,
	  private LocalDateTime created_at; // TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	  private Integer balance_cents; // INTEGER DEFAULT 0
}
