package com.mfoumgroup.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mfoumgroup.orderservice.common.TransactionRequest;
import com.mfoumgroup.orderservice.common.TransactionResponse;
import com.mfoumgroup.orderservice.entities.Order;
import com.mfoumgroup.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request) throws JsonProcessingException {
		return service.saveOrder(request);
	}

	@GetMapping("/all")
	public List<Order> getOrders() {
		return service.getOrders();
	}

}
