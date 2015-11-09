package com.bsc;

import com.bsc.entities.Payment;
import com.bsc.utils.ConsoleReader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;


/**
 * Created with IntelliJ IDEA.
 * User: Ladislav
 * Date: 11/9/15
 * Time: 2:16 PM
 * To change this template use File | Settings | File Templates.
 */

public class ConsoleReaderTest {
    @Before
    public void setUp() throws Exception {
//        ArrayList<String> payments = new ArrayList<Payment>();
//        Payment payment = new Payment();
//        payment.setAmount(1);
//        payment.setCurrency("BLA");
//        payments.add(payment);
    }

    @Test
    public void parsePayment() {
        String paymentString = "USD 500";
        Payment payment = ConsoleReader.parsePayment(paymentString);
        Assert.assertEquals(payment.getAmount() == 500,true);
        Assert.assertEquals(payment.getCurrency().equals("USD"),true);
        String wrongPayment = "S546S";
        payment = ConsoleReader.parsePayment(wrongPayment);
        Assert.assertFalse(payment.getAmount() == 500);
    }

}