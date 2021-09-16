package com.mfoumgroup.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mfoumgroup.orderservice.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
