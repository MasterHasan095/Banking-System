package org.example.Functionalities;

import org.example.Main;
import org.example.bean.Balance;
import org.example.bean.Transaction;

import java.util.Scanner;

public class Deposit {

    public Deposit(){};
    public Deposit(int accountNumber){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome " + accountNumber);
        System.out.print("Please enter the amount you would like to deposit : ");
        int amountToDeposit = scan.nextInt();

        for (Balance balance: Main.BALANCE){
            if (balance.getAccount_number() == accountNumber){
                int existingBalance = balance.getBalance();
                balance.setBalance(existingBalance + amountToDeposit);
            }
        }

        Main.TRANSACTIONS.add((new Transaction(accountNumber,accountNumber,amountToDeposit)));
    }
    public void deposit(int accountNumber, int amount){
        for (Balance balance: Main.BALANCE){
            if (balance.getAccount_number() == accountNumber){
                int existingBalance = balance.getBalance();
                balance.setBalance(existingBalance + amount);
            }
        }
    }
}
