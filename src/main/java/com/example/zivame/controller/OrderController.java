package com.example.zivame.controller;

import com.example.zivame.entity.Order;
import com.example.zivame.entity.Otp;
import com.example.zivame.services.OrderService;
import com.example.zivame.services.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Created by dprabhu on 2019-11-05
 */

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OtpService otpService;

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value="/order", method= RequestMethod.GET)
    public Order getOrder(@RequestParam(required = true) int orderId) {

        return orderService.getOrder(orderId);

    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value="/order", method= RequestMethod.POST)
    public Order saveOrder(@RequestBody Order order) {

        Order savedOrder = orderService.saveOrder(order);

        Random random = new Random();

        // To be changed to 4 digit
        int otp = random.nextInt();

        Otp newOtp = new Otp(otp, savedOrder.getOrderId(), true);

        otpService.saveOtp(newOtp);

        System.out.print("Otp " + otp + " sent to mobile number " + order.getPhNum() + " for order " + order.getOrderId());

        return savedOrder;

    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(value="/confirm", method= RequestMethod.POST)
    public Order confirmOrder(@RequestParam(required = false, defaultValue = "false") int orderId,
                              @RequestParam(required = false, defaultValue = "false") int otpReceived) throws Exception {

        Order order = getOrder(orderId);

        Otp otp = otpService.getOtp(otpReceived);

        if(otp!=null && order!=null && otp.getOrderId()==orderId && otp.getOtp()==otpReceived) {

            return orderService.saveOrder(order);

        }

        throw new Exception("Invalid OTP");

    }

}
