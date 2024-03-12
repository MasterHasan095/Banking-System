package org.example.bean;

public class Account {
    private int account_number;
    private String name;
    private String email;

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account(int account_number, String name, String email) {
        this.account_number = account_number;
        this.name = name;
        this.email = email;
    }
}
