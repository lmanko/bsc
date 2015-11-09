package com.bsc.main;

import com.bsc.entities.Payment;
import com.bsc.utils.FileLoader;
import com.bsc.utils.PaymentHolder;
import com.bsc.utils.PaymentProcessor;
import com.bsc.utils.PaymentsWrapper;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Ladislav
 * Date: 11/6/15
 * Time: 9:16 PM
 */
public class Starter {

    public static void main(String[] args) {
        String flag = "";
        final PaymentsWrapper wrapper = new PaymentsWrapper();
        ArrayList<Payment> payments = new ArrayList<Payment>();
        try {
            ArrayList<Payment> paymentsFromFile = FileLoader.loadFromFile();
            PaymentProcessor paymentProcessor = PaymentProcessor.getInstance();
            payments = paymentProcessor.processPayments(paymentsFromFile);
        } catch (Exception e) {
            System.out.println("Error while reading specified file");
        }
        // read from console
        wrapper.setPayments(payments);
        System.out.println("You can enter transactions now.");
        PaymentHolder holder = new PaymentHolder(wrapper);
        new Thread(holder).start();

    }
}