package com.bsc.entities;

/**
 * Created with IntelliJ IDEA.
 * User: Ladislav
 * Date: 11/5/15
 * Time: 4:23 PM
 */
 public class Payment {

    private String currency;
    private long amount;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
