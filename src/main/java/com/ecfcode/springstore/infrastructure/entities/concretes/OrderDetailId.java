package com.ecfcode.springstore.infrastructure.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long orderId;
	private Long productId;
}
