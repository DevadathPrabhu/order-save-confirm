package com.example.zivame.services;

import com.example.zivame.entity.Order;
import com.example.zivame.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by dprabhu on 2019-11-05
 */

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    public Order saveOrder(Order order){
        return orderRepo.save(order);
    }

    public Order getOrder(int orderId){
        Optional<Order> order = orderRepo.findById(orderId);
        if(order.isPresent()){
            return order.get();
        }
        else
            return null;

    }

}
