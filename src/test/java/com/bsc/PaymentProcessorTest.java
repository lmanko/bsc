package com.bsc;

import com.bsc.entities.Payment;

import com.bsc.utils.PaymentProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * Created with IntelliJ IDEA.
 * User: Ladislav
 * Date: 11/9/15
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class PaymentProcessorTest {

    ArrayList<Payment> payments;

    @Before
    public void setUp() throws Exception {
        payments = new ArrayList<Payment>();
        Payment payment = new Payment();
        payment.setAmount(2);
        payment.setCurrency("USD");
        payments.add(payment);

        Payment payment2 = new Payment();
        payment2.setAmount(3);
        payment2.setCurrency("USD");
        payments.add(payment2);

        Payment payment3 = new Payment();
        payment3.setAmount(10);
        payment3.setCurrency("EUR");
        payments.add(payment3);

        Payment payment4 = new Payment();
        payment4.setAmount(10);
        payment4.setCurrency("EUR");
        payments.add(payment4);
    }


    @Test
    public void processPayments() {
        // process payments and return ArrayList<Payment>
        payments = PaymentProcessor.getInstance().processPayments(payments);
        Assert.assertTrue(payments.size() != 0);
        for (Payment payment : payments) {
            if (payment.getCurrency().equals("USD")) {
                Assert.assertEquals(payment.getAmount(), 5);
            }
            if (payment.getCurrency().equals("EUR")) {
                Assert.assertEquals(payment.getAmount(), 20);
            }
        }
    }

    @Test
    public void findCurrencies() {
        //Hashset currencies
        HashSet<String> currencies = PaymentProcessor.findCurrencies(payments);
        Assert.assertTrue(currencies.size() != 0);
        Assert.assertTrue(currencies.size() == 2);
        for(String currency: currencies){
            Assert.assertTrue(currency.equals("USD") || currency.equals("EUR"));
        }
    }
}