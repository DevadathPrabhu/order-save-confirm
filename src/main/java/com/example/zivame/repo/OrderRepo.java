package com.example.zivame.repo;

import com.example.zivame.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Integer> {
}
