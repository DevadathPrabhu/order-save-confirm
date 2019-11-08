package com.example.zivame.controller;

import com.example.zivame.entity.Order;
import com.example.zivame.entity.Otp;
import com.example.zivame.services.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by dprabhu on 2019-11-05
 */

public class OtpController {

    @Autowired
    OtpService otpService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/otp", method= RequestMethod.GET)
    public Otp getOtp(@RequestParam(required = true) int otpNum) {

        return otpService.getOtp(otpNum);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/otp", method= RequestMethod.POST)
    public Otp saveOtp(@RequestBody Otp otp) {

        return otpService.saveOtp(otp);

    }

}
