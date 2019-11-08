package com.example.zivame.services;

import com.example.zivame.entity.Otp;
import com.example.zivame.repo.OtpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by dprabhu on 2019-11-05
 */

@Service
public class OtpService {

    @Autowired
    OtpRepo otpRepo;

    public Otp saveOtp(Otp otp){
        return otpRepo.save(otp);
    }

    public Otp getOtp(int otpNum){
        Optional<Otp> otp = otpRepo.findById(otpNum);
        if(otp.isPresent()){
            return otp.get();
        }
        else
            return null;
    }

}
