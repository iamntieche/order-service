package com.mfoumgroup.orderservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mfoumgroup.orderservice.common.Payment;
import com.mfoumgroup.orderservice.common.TransactionRequest;
import com.mfoumgroup.orderservice.common.TransactionResponse;
import com.mfoumgroup.orderservice.entities.Order;
import com.mfoumgroup.orderservice.repository.OrderRepository;

@Service
//@RefreshScope
public class OrderService { 
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	@Lazy
	private WebClient.Builder webClient;
	
	private Logger log= LoggerFactory.getLogger(OrderService.class);
	


	public TransactionResponse saveOrder(TransactionRequest request) throws JsonProcessingException {
		String response ="";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());

		log.info("OrderService request : {} ",new ObjectMapper().writeValueAsString(request));
		// rest call
		Payment paymentResponse = webClient.baseUrl("http://PAYMENT-SERVICE/payment/doPayment")
				.build().post().bodyValue(payment)
				.retrieve()
				.bodyToMono(Payment.class)
				.block();

		log.info("Payment-service response from OrderService Rest call : {} ",new ObjectMapper().writeValueAsString(paymentResponse));
		response = paymentResponse.getPaymentStatus().equals("success")?"payment processing successful ":"there is a failure in payment api, order added to cart";
		repository.save(order);
		return new TransactionResponse(paymentResponse.getAmount(), order, paymentResponse.getTransactionId(),response);
	}

	public List<Order> getOrders() {
		return repository.findAll();
	}
}
