package com.mfoumgroup.orderservice.common;

import com.mfoumgroup.orderservice.entities.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
	private Order order;
	private Payment payment;
}
