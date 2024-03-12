package org.example.bean;

public class Balance {
    private int account_number;
    private int balance;

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Balance(int account_number, int balance) {
        this.account_number = account_number;
        this.balance = balance;
    }
}
