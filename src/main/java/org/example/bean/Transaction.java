package org.example.bean;

public class Transaction {
    private int from_account_number;
    private int to_account_number;
    private int amount;

    public int getFrom_account_number() {
        return from_account_number;
    }

    public void setFrom_account_number(int from_account_number) {
        this.from_account_number = from_account_number;
    }

    public int getTo_account_number() {
        return to_account_number;
    }

    public void setTo_account_number(int to_account_number) {
        this.to_account_number = to_account_number;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Transaction(int from_account_number, int to_account_number, int amount) {
        this.from_account_number = from_account_number;
        this.to_account_number = to_account_number;
        this.amount = amount;
    }
}
