package com.java.springretry.model;

import java.util.List;

public class PaymentInfomation {

    String customerId;
    List<Payment> payments;

    public PaymentInfomation(List<Payment> payments, String customerId) {
        this.payments = payments;
        this.customerId = customerId;
    }

    public PaymentInfomation() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
