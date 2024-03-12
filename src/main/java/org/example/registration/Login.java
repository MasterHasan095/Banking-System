package org.example.registration;

import org.example.Main;
import org.example.bean.User;

import java.util.Scanner;

public class Login {
    Scanner scan = new Scanner(System.in);

    public Login(){

        boolean running = false;
        boolean accNumberExists = false;
        boolean correctPassword = false;

        User instanceUser = null;
        while (!running){
            System.out.print("Please enter your account Number : ");
            int account_number = scan.nextInt();
            for (User user : Main.USERS){
                if (account_number == user.getAccount_number()){
                    accNumberExists = true;
                    instanceUser = user;
                    break;
                }
            }
            if (accNumberExists == false){
                System.out.println("In correct account number, please enter again");
            }

            if (accNumberExists) {
                while (!correctPassword) {
                    System.out.print("Please enter your password : ");
                    String password = scan.next();
                    if (instanceUser.getPassword().equals(password)){
                        correctPassword = true;
                        System.out.println("Correct Password");
                        break;
                    }
                    System.out.println("Incorrect Password, Please try again");
                }
            }

            if (correctPassword = true){
                Main.accountNumber = account_number;
                running = true;
            }
        }
    }
}
