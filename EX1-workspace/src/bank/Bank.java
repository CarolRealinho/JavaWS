package bank;

import java.util.HashMap;
import java.time.LocalDate;

public class Bank {
    private HashMap<String,BankAccount> accounts;

    public Bank(){
        this.accounts = new HashMap<String,BankAccount>();
    }

    public void createAccount(String id, double initialBalance){
        BankAccount acc = new BankAccount(id, initialBalance);
        this.accounts.put(id, acc);
    }

    

    public void performTransaction(String accountId, double amount, String type) {
        BankAccount acc = accounts.get(accountId);
        if (acc == null) {
            System.out.println("No bank account found.");
            return;
        }

        Transaction t = new Transaction(amount, type, LocalDate.now().toString());

        if (type.equalsIgnoreCase("withdraw")) {
            if (acc.getBalance() < amount) {
                System.out.println("Operation not possible: insufficient funds.");
                return;
            }
            acc.updateBalance(-amount);
        } else if (type.equalsIgnoreCase("deposit")) {
            acc.updateBalance(amount);
        } else {
            System.out.println("Unknown transaction type.");
            return;
        }

        acc.addTransaction(t);
    }


    public void showAllAccounts(){
        for(String acc: this.accounts.keySet()){
            System.out.println(this.accounts.get(acc));
        }
    }
}
