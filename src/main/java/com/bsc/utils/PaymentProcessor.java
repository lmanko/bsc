package com.bsc.utils;

import com.bsc.entities.Payment;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: Ladislav
 * Date: 11/7/15
 * Time: 6:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class PaymentProcessor {

    private static PaymentProcessor instance = null;
      protected PaymentProcessor() {
      }
      public synchronized static PaymentProcessor getInstance() {
         if(instance == null) {
            instance = new PaymentProcessor();
         }
         return instance;
      }


    public synchronized ArrayList<Payment> processPayments(ArrayList<Payment> payments) {
        HashSet<String> currencies = findCurrencies(payments);
        ArrayList<Payment> ballance = new ArrayList<Payment>();
        //for every currency do sum
        for (String currency : currencies) {
            long sum = 0;
            // walk over payments to sum
            for (Payment singlePayment : payments) {
                if (singlePayment.getCurrency().equals(currency)) {
                    sum = sum + singlePayment.getAmount();
                }
            }
            Payment ballanceForCurrency = new Payment();
            ballanceForCurrency.setAmount(sum);
            ballanceForCurrency.setCurrency(currency);
            ballance.add(ballanceForCurrency);
        }
        return ballance;
    }

    public static HashSet<String> findCurrencies(ArrayList<Payment> payments) {
        HashSet<String> currencies = new HashSet<String>();
        for (Payment p : payments) {
            currencies.add(p.getCurrency());
        }
        return currencies;
    }
}
