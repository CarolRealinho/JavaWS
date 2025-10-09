package bank;

import java.util.ArrayList;

public class BankAccount {
    private String id;
    private double balance;
    private ArrayList<Transaction> transactions;

    public BankAccount(String id, double initialBalance){
        this.id = id;
        this.balance = initialBalance;
        this.transactions = new ArrayList<Transaction>();
    }

    public String getId(){
        return this.id;
    }

    public double getBalance(){
        return this.balance;
    }

    public void addTransaction(Transaction t){
        this.transactions.add(t);
    }

    public void updateBalance(double amountChange) {
        this.balance += amountChange;
    }

    public String toString(){
        return "Account: " + id + ", Balance: " + balance + ", Transactions: " + transactions;
    }
}
