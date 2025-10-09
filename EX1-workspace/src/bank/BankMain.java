package bank;

public class BankMain {
    public static void main(String[] args) {
    Bank bank = new Bank();
    bank.createAccount("A1", 100.0);
    bank.createAccount("A2", 0);
    bank.performTransaction("A1", 50.0, "deposit");
    bank.performTransaction("A1", 30.0, "withdraw");
    bank.performTransaction("A1", 200.0, "withdraw"); // should fail
    bank.showAllAccounts();
}

}
