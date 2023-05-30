package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findByName(String name);

    Order findById(int id);

}
