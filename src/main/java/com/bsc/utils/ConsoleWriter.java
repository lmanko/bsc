package com.bsc.utils;

import com.bsc.entities.Payment;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Ladislav
 * Date: 11/8/15
 * Time: 11:14 AM
 */
public class ConsoleWriter {

    public static void writePayments(ArrayList<Payment> payments) {
        payments = PaymentProcessor.getInstance().processPayments(payments);
        System.out.println("Current balance:");
        for (Payment payment : payments) {
            if(payment.getAmount()!=0){
                System.out.println(payment.getCurrency() + " " + payment.getAmount());
            }
        }
        System.out.println("\n");
    }
}
