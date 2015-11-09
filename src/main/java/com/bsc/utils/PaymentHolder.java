package com.bsc.utils;

import com.bsc.services.TaskScheduler;

import java.util.Timer;

/**
 * Created with IntelliJ IDEA.
 * User: Ladislav
 * Date: 11/9/15
 * Time: 7:41 AM
 */
public class PaymentHolder implements Runnable {
    PaymentsWrapper wrapper;

    public PaymentHolder(PaymentsWrapper wrapper) {
        this.wrapper = wrapper;
    }


    public void run() {
        ConsoleReader consoleReader = new ConsoleReader(wrapper.getPayments());
                  consoleReader.setPayments(wrapper.getPayments());
                  new Thread(consoleReader).start();

            Timer timer = new Timer();
                    timer.schedule(new TaskScheduler(wrapper.getPayments()), 0, 10000);

    }
}
