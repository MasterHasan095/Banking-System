package org.example;

import com.sun.security.jgss.GSSUtil;
import org.example.Functionalities.Deposit;
import org.example.Functionalities.Pay;
import org.example.Functionalities.Transfer;
import org.example.Functionalities.Withdraw;
import org.example.bean.Account;
import org.example.bean.Balance;
import org.example.bean.Transaction;
import org.example.bean.User;
import org.example.registration.Login;
import org.example.registration.Register;

import java.io.*;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static boolean isLoggedIN = false;
    public static int accountNumber = 0;
    public static ArrayList<User> USERS = new ArrayList<User>();
    public static ArrayList<Account> ACCOUNTS = new ArrayList<Account>();
    public static ArrayList<Balance> BALANCE = new ArrayList<Balance>();
    public static ArrayList<Transaction> TRANSACTIONS = new ArrayList<Transaction>();


    public static void main(String[] args) throws IOException {
        boolean running = true;
        Scanner scan = new Scanner(System.in);
        load();

        System.out.println("Welcome to our Banking System");
        System.out.println("What would you like to do? \nPress 1 to register \nPress 2 to Login\nEnter your choice : ");
        int choice = scan.nextInt();
        if (choice == 2){
            Login login = new Login();
            isLoggedIN = true;
        }else if (choice == 1){
            Register register = new Register();
            isLoggedIN = true;
        }

        while (running) {
            System.out.println("Congratulations on getting in, Please choose what you want to do with our software ");
            System.out.println("Press 1 to Deposit");
            System.out.println("Press 2 to Withdraw");
            System.out.println("Press 3 to Transfer Money");
            System.out.println("Press 4 to Pay Bills");
            System.out.println("Press 0 to exit");
            System.out.print("enter your choice : ");

            int choice2 = scan.nextInt();

            switch (choice2){
                case 0:
                    write();
                    running = false;
                    break;
                case 1:
                    Deposit deposit = new Deposit(accountNumber);
                    break;
                case 2:
                    Withdraw withdraw = new Withdraw(accountNumber);
                    break;
                case 3:
                    Transfer transfer = new Transfer(accountNumber);
                    break;
                case 4:
                    Pay pay = new Pay(accountNumber);
                    break;
            }


//        for (User user : USERS){
//            System.out.println(user.getPassword());
//        }
//        for (Account account : ACCOUNTS){
//            System.out.println(account.getName());
//        }
//
//        for (Balance balance : BALANCE){
//            System.out.println(balance.getBalance());
//        }
//        for (Transaction transaction: TRANSACTIONS){
//            System.out.println(transaction.getFrom_account_number() + " and " + transaction.getTo_account_number() +
//                    "dealt for this amount : " + transaction.getAmount());
//        }
        }
    }

    public static void load() throws IOException {
         String users = "users.txt";
         String accounts = "accounts.txt";
         String balance = "balance.txt";
         String transaction_history = "transactions.txt";

         File users1 = new File(users);
         File accounts1 = new File(accounts);
         File balance1 = new File(balance);
         File transaction_history1 = new File(transaction_history);

        BufferedReader users2 = new BufferedReader(new FileReader(users1));
        BufferedReader accounts2 = new BufferedReader(new FileReader(accounts1));
        BufferedReader balance2 = new BufferedReader(new FileReader(balance1));
        BufferedReader transactions2 = new BufferedReader(new FileReader(transaction_history1));

        String line = "not empty";

        while (line!= null){
            line = users2.readLine();
            if (line != null) {

                String[] usersArray = line.split(",");
                int acc_number = Integer.parseInt(usersArray[0]);
                USERS.add(new User(acc_number, usersArray[1]));
            }
        }
        line = "not empty";

        while (line!= null){
            line = accounts2.readLine();
            if (line!=null) {
                String[] accountsArray = line.split(",");
                int acc_number = Integer.parseInt(accountsArray[0]);
                ACCOUNTS.add(new Account(acc_number, accountsArray[1], accountsArray[2]));
            }
        }
        line = "not empty";

        while (line!= null){
            line = balance2.readLine();
            if (line != null) {
                String[] balanceArray = line.split(",");
                int acc_number = Integer.parseInt(balanceArray[0]);
                int balance_amt = Integer.parseInt(balanceArray[1]);
                BALANCE.add(new Balance(acc_number, balance_amt));
            }
        }
        line = "not empty";
        while (line!= null){
            line = transactions2.readLine();
            if (line != null) {
                String[] transactionsArray = line.split(",");
                int from_acc_number = Integer.parseInt(transactionsArray[0]);
                int to_acc_number = Integer.parseInt(transactionsArray[1]);
                int amount = Integer.parseInt(transactionsArray[2]);
                TRANSACTIONS.add(new Transaction(from_acc_number, to_acc_number, amount));
            }
        }


        }
    public static void write() throws IOException {
        String users = "users.txt";
        String accounts = "accounts.txt";
        String balance = "balance.txt";
        String transaction_history = "transactions.txt";

        File users1 = new File(users);
        File accounts1 = new File(accounts);
        File balance1 = new File(balance);
        File transaction_history1 = new File(transaction_history);

        BufferedWriter users2 = new BufferedWriter(new FileWriter(users1));
        BufferedWriter accounts2 = new BufferedWriter(new FileWriter(accounts1));
        BufferedWriter balance2 = new BufferedWriter(new FileWriter(balance1));
        BufferedWriter transactions2 = new BufferedWriter(new FileWriter(transaction_history1));

        for(User user : USERS){
            users2.write(user.getAccount_number()+","+user.getPassword()+"\n");
        }
        for(Account account : ACCOUNTS){
            accounts2.write(account.getAccount_number()+","+account.getName()+","+account.getEmail()+"\n");
        }
        for(Balance balanced : BALANCE){
            balance2.write(balanced.getAccount_number()+","+balanced.getBalance()+"\n");
        }
        for(Transaction transactions : TRANSACTIONS){
            transactions2.write(transactions.getFrom_account_number()+","+transactions.getTo_account_number()+","+transactions.getAmount()+"\n");
        }

        users2.flush();
        users2.close();
        accounts2.flush();
        accounts2.close();
        transactions2.flush();
        transactions2.close();
        balance2.flush();
        balance2.close();
    }
}