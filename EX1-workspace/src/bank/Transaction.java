package bank;

public class Transaction {
    private double amount;
    private String tType;
    private String date;

    public Transaction(double amount, String tType, String date){
        this.amount = amount;
        this.tType = tType;
        this.date = date;
    }

    public double getAmount(){
        return this.amount;
    }

    public String getType(){
        return this.tType;
    }

    public String getDate(){
        return this.date;
    }

    public String toString(){
        return "(" + this.tType + ", " + this.amount + ", " + this.date + ")";
    }
}
