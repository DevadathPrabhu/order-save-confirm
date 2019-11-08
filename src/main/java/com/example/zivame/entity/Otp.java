package com.example.zivame.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by dprabhu on 2019-11-05
 */

@Entity
public class Otp {

    @Id
    private int otp;

    private int orderId;

    private boolean isValid;

    public Otp(){

    }

    public Otp(int otp, int orderId, boolean isValid) {
        this.otp = otp;
        this.isValid = isValid;
        this.orderId = orderId;
    }

    @JsonProperty(value = "OTP")
    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    @JsonProperty(value = "OrderId")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @JsonProperty(value = "isValid")
    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
