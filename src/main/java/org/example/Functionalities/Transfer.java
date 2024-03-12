package org.example.Functionalities;

import org.example.Main;
import org.example.bean.Transaction;
import org.example.bean.User;

import java.util.Scanner;

public class Transfer {

    public Transfer(int accountNumber){
        Deposit dp = new Deposit();
        Withdraw ww = new Withdraw();
        Scanner scan = new Scanner(System.in);
        boolean check = true;
        System.out.println("Welcome to transfer");
        int toTransf = 0;
        System.out.println("Which account number would you like to transfer money to : ");
        while (check){
            toTransf = scan.nextInt();
            for (User user : Main.USERS){
                if (user.getAccount_number() == toTransf){
                    check = false;
                    break;
                }
            }
            if (check == true) {
                System.out.println("Account does not exist");
            }
        }
        System.out.println(toTransf);
        System.out.println("Please enter the amount you want to transfer : ");
        int amountToTransfer = scan.nextInt();
        dp.deposit(toTransf, amountToTransfer);
        ww.withdraw(accountNumber, amountToTransfer);
        Main.TRANSACTIONS.add(new Transaction(accountNumber,toTransf,-amountToTransfer));
        Main.TRANSACTIONS.add(new Transaction(toTransf,accountNumber,amountToTransfer));
    }
}
