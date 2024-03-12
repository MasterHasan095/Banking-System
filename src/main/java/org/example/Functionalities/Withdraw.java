package org.example.Functionalities;

import org.example.Main;
import org.example.bean.Balance;
import org.example.bean.Transaction;

import java.util.Scanner;

public class Withdraw {

    public Withdraw(){};
    public  Withdraw(int accountNumber){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome " + accountNumber);
        int amountToWithdraw = 0;


        for (Balance balance: Main.BALANCE){
            if (balance.getAccount_number() == accountNumber){
                int existingBalance = balance.getBalance();
                System.out.println("Existing Amount : " + existingBalance);
                System.out.print("Please enter the amount you would like to withdraw : ");
                amountToWithdraw = scan.nextInt();
                balance.setBalance(existingBalance - amountToWithdraw);
            }
        }

        Main.TRANSACTIONS.add((new Transaction(accountNumber,accountNumber,-amountToWithdraw)));
    }

    public void withdraw(int accNumber, int amount){
        for (Balance balance: Main.BALANCE){
            if (balance.getAccount_number() == accNumber){
                int existingBalance = balance.getBalance();
                balance.setBalance(existingBalance - amount);
            }
        }
    }
}
