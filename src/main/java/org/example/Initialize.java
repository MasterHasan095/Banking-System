package org.example;

import java.io.File;
import java.io.IOException;

public class Initialize {

    static String users = "users.txt";
    static String accounts = "accounts.txt";
    static String balance = "balance.txt";
    static String transaction_history = "transactions.txt";

    static File users1 = new File(users);
    static File accounts1 = new File(accounts);
    static File balance1 = new File(balance);
    static File transaction_history1 = new File(transaction_history);

    public static void main(String[] args) throws IOException {
        users1.createNewFile();
        accounts1.createNewFile();
        balance1.createNewFile();
        transaction_history1.createNewFile();


    }


}
