package com.bsc.services;

import com.bsc.entities.Payment;
import com.bsc.utils.ConsoleWriter;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: Ladislav
 * Date: 11/8/15
 * Time: 4:18 PM
 */
public class TaskScheduler extends TimerTask {

    private volatile ArrayList<Payment> paymentList;

    public TaskScheduler(ArrayList paymentList) {
        this.paymentList = paymentList;
    }

    public void run() {
        ConsoleWriter.writePayments(paymentList);
        try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   System.out.println("Interrupted exception occured");
               }
    }

    public synchronized ArrayList<Payment>  getPaymentList() {
        return paymentList;
    }

    public synchronized void setPaymentList(ArrayList<Payment> paymentList) {
        this.paymentList = paymentList;
    }
}

