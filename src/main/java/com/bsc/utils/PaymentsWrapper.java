package com.bsc.utils;

import com.bsc.entities.Payment;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Ladislav
 * Date: 11/9/15
 * Time: 7:55 AM
 */
public class PaymentsWrapper {

   public volatile ArrayList<Payment> payments;

    public synchronized ArrayList<Payment> getPayments() {
        return payments;
    }

    public synchronized void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }


}
