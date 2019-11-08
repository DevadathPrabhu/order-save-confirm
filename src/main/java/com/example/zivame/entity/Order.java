package com.example.zivame.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by dprabhu on 2019-11-05
 */

@Entity
@Table(name = "order_table")
public class Order {

    @Id
    private int orderId;

    private String productId;

    private String custName;

    private String phNum;

    private String address;

    private double orderTotal;

    private boolean confirm;

    public Order(){

    }

    public Order(int orderId, String productId, String custName, String phNum, String address, double orderTotal){
        super();
        this.orderId = orderId;
        this.productId = productId;
        this.custName = custName;
        this.phNum = phNum;
        this.address = address;
        this.orderTotal = orderTotal;
        this.confirm = false;
    }

    @JsonProperty(value = "OrderId")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @JsonProperty(value = "ProductId")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @JsonProperty(value = "CustName")
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @JsonProperty(value = "PhNum")
    public String getPhNum() {
        return phNum;
    }

    public void setPhNum(String phNum) {
        this.phNum = phNum;
    }

    @JsonProperty(value = "Address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty(value = "OrderTotal")
    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    @JsonProperty(value = "Confirm")
    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    @Override
    public String toString(){
        return "OrderId: " + orderId + "\nProductId: " + productId + "\nPhone Num: " + phNum ;
    }
}
