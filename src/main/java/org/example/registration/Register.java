package org.example.registration;

import org.example.Main;
import org.example.bean.Account;
import org.example.bean.Balance;
import org.example.bean.User;

import javax.swing.plaf.ProgressBarUI;
import java.util.Random;
import java.util.Scanner;

public class Register {

    boolean running = true;

    public Register(){
        Scanner scan = new Scanner(System.in);
        int ramdomAccNumber = generateRandom4DigitNumber();
        while(running){
            boolean checking = true;
            boolean exists = false;
            while (checking) {
                for (User user : Main.USERS) {
                    if (user.getAccount_number() == ramdomAccNumber) {
                        exists = true;
                        break;
                    }
                }
                if (exists){
                    ramdomAccNumber = generateRandom4DigitNumber();
                }else{
                    checking = false;
                }
            }
            System.out.println("Welcome to register");
            System.out.println("Here is your account Number : " + ramdomAccNumber);
            running = false;

            System.out.print("Please enter your name : ");
            String name = scan.next();
            System.out.print("Please enter your email : ");
            String email = scan.next();
            System.out.print("Please enter your password : ");
            String pass = scan.next();

            User user = new User(ramdomAccNumber, pass);
            Account account = new Account(ramdomAccNumber,name, email);
            Balance balance = new Balance(ramdomAccNumber, 0);
            Main.USERS.add(user);
            Main.ACCOUNTS.add(account);
            Main.BALANCE.add(balance);
            System.out.println("New registration done");
            Main.accountNumber = ramdomAccNumber;
        }


    }

    public static int generateRandom4DigitNumber() {
        Random rand = new Random();
        // Generate a random integer between 1000 and 9999 (inclusive)
        int randomNumber = rand.nextInt(9000) + 1000;
        return randomNumber;
    }
}
