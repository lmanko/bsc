package com.bsc.utils;

import com.bsc.entities.Payment;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Ladislav
 * Date: 11/5/15
 * Time: 4:37 PM
 */
public class ConsoleReader implements Runnable {
    public volatile ArrayList<Payment> payments;

    public ConsoleReader(ArrayList<Payment> payments) {
        this.payments = payments;
    }


    public void run() {
        String command = "";

        while (true) {
            Thread.yield();
            Scanner stdin = new Scanner(new BufferedInputStream(System.in)).useDelimiter("\n");
            while (stdin.hasNextLine()) {
                String next = stdin.nextLine();
                if (next.toLowerCase().equals("quit")) {
                    command = next;
                    break;
                }
                if (next.equals("") || next.length() == 0) break;

                //if command is not quit save transaction
                if (!next.equals("quit") && !next.isEmpty()) this.payments.add(parsePayment(next));
                PaymentProcessor paymentProcessor = PaymentProcessor.getInstance();
                ArrayList<Payment> paymentsFromProcess = paymentProcessor.processPayments(this.payments);
                this.payments.clear();
                for (Payment p : paymentsFromProcess) {
                    this.payments.add(p);
                }
            }
            if (command.toLowerCase().equals("quit")) System.exit(0);
        }

    }

    public static Payment parsePayment(String paymentString) {
        String[] paymentStrings = paymentString.split(" ");
        Payment payment = new Payment();
        try {
            payment.setCurrency(paymentStrings[0].toUpperCase());
            payment.setAmount(Long.parseLong(paymentStrings[1]));
        } catch (ArrayIndexOutOfBoundsException aiou) {
            System.out.println("Wrong format of payment string ... Ending application");
            System.exit(0);
        } catch (NumberFormatException nbu) {
            System.out.println("Wrong format of payment string / Number format is wrong ... Ending application");
            System.exit(0);
        }
        return payment;
    }

    public synchronized ArrayList<Payment> getPayments() {
        if (payments != null) {
            return payments;
        } else return new ArrayList<Payment>();

    }

    public synchronized void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

}
