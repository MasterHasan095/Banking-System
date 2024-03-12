package org.example.Functionalities;

import org.example.Main;
import org.example.bean.Balance;
import org.example.bean.Transaction;

import java.util.Scanner;

public class Pay {
    public Pay(int accountNumber){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome " + accountNumber);
        int amountToWithdraw = 0;


        for (Balance balance: Main.BALANCE){
            if (balance.getAccount_number() == accountNumber){
                int existingBalance = balance.getBalance();
                System.out.println("Existing Amount : " + existingBalance);
                System.out.print("Please enter the amount you would like to pay in the bill : ");
                amountToWithdraw = scan.nextInt();
                balance.setBalance(existingBalance - amountToWithdraw);
            }
        }

        Main.TRANSACTIONS.add((new Transaction(accountNumber,accountNumber,-amountToWithdraw)));
    }
}
