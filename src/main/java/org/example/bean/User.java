package org.example.bean;

public class User {
    private int account_number;
    private String password;

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(int account_number, String password) {
        this.account_number = account_number;
        this.password = password;
    }
}
