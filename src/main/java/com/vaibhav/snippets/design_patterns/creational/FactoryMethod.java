package com.vaibhav.snippets.design_patterns.creational;

import java.util.Scanner;
import java.util.StringJoiner;

public class FactoryMethod {
    private static int accountCount=0;
    /*
    A Factory Pattern or Factory Method Pattern says that just define an interface or abstract class for creating an object but
     let the subclasses decide which class to instantiate. In other words, subclasses are responsible to create the instance of
      the class.
     */
    public static void main(String[] args) {
        driverMethod();
    }

    public static void driverMethod() {
        AccountFactory accountFactory = new AccountManager();
        Scanner sc = new Scanner(System.in);
        int input = 1;
        while(input != 0) {
            System.out.println("Press\n1 for saving account\n2 for current account\n3 for demat account\n0 to exit");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    Account account1 = accountFactory.createAccount(AccountType.SAVING);
                    account1.getInfo();
                    break;
                case 2:
                    Account account2 = accountFactory.createAccount(AccountType.CURRENT);
                    account2.getInfo();
                    break;
                case 3:
                    Account account3 = accountFactory.createAccount(AccountType.DEMAT);
                    account3.getInfo();
                    break;
                default: continue;
            }
        }
        System.out.println("exiting........");
    }
}

interface AccountFactory {
    Account createAccount(AccountType accountType);
}

class AccountManager implements AccountFactory {

    @Override
    public Account createAccount(AccountType accountType) {
        if (accountType.equals(AccountType.CURRENT)) {
            return new CurrentAccount("4%");
        } else if(accountType.equals(AccountType.SAVING)) {
            return new SavingAccount("5%");
        } else  if (accountType.equals(AccountType.DEMAT)){
            return new DematAccount("0%");
        } else {
            return null;
        }
    }
}

abstract class Account {
    String accountNumber;
    String holderName;
    String branchName;
    String IFSC;

    public Account() {}

    public String getAccountNumber() {
        return accountNumber;
    }

    public Account setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public String getHolderName() {
        return holderName;
    }

    public Account setHolderName(String holderName) {
        this.holderName = holderName;
        return this;
    }

    public String getBranchName() {
        return branchName;
    }

    public Account setBranchName(String branchName) {
        this.branchName = branchName;
        return this;
    }

    public String getIFSC() {
        return IFSC;
    }

    public Account setIFSC(String IFSC) {
        this.IFSC = IFSC;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Account.class.getSimpleName() + "[", "]")
                .add("accountNumber='" + accountNumber + "'")
                .add("holderName='" + holderName + "'")
                .add("branchName='" + branchName + "'")
                .add("IFSC='" + IFSC + "'")
                .toString();
    }

    public abstract void getInfo();
}

class SavingAccount extends Account {

    final String rate;



    public SavingAccount(String rate) {
        this.rate = rate;
    }

    @Override
    public void getInfo() {
        System.out.println("Saving account | interest rate : 5%");
        System.out.println(super.toString());
        System.out.println();
    }
}

class CurrentAccount extends Account {

    final String rate;

    public void getInfo() {
        System.out.println("Current account | interest rate : 4%");
        System.out.println(super.toString());
        System.out.println();
    }
    public CurrentAccount(String rate) {
        this.rate = rate;
    }
}

class DematAccount extends Account {

    public void getInfo() {
        System.out.println("Demat account | interest rate : 0%");
        System.out.println(super.toString());
        System.out.println();
    }
    final String rate;

    public DematAccount(String rate) {
        this.rate = rate;
    }
}

enum AccountType {
    SAVING,CURRENT,DEMAT
}
