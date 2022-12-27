package _06_Defining_Classes._01_Defining_Classes_Lab._03_Bank_Account;

public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;
    private int id;
    private double balance;

    public BankAccount(){
        this.id = bankAccountCount++;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static int getBankAccountCount() {
        return bankAccountCount;
    }

    public static void setBankAccountCount(int bankAccountCount) {
        BankAccount.bankAccountCount = bankAccountCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years){
        return this.balance * years * interestRate;
    }

    public void deposit(double amount){
        this.balance += amount;
    }
}
