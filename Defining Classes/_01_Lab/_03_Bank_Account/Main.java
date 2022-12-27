package _06_Defining_Classes._01_Defining_Classes_Lab._03_Bank_Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, BankAccount> bankAccountMap = new HashMap<>();
        String input = scan.nextLine();

        while (!input.equals("End")) {
            String command = input.split(" ")[0];
            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    System.out.printf("Account ID%d created%n", bankAccount.getId());
                    bankAccountMap.put(bankAccount.getId(), bankAccount);
                    break;
                case "Deposit":
                    int id = Integer.parseInt(input.split(" ")[1]);
                    double amount = Double.parseDouble(input.split(" ")[2]);

                    if (bankAccountMap.containsKey(id)) {
                        BankAccount tempAcc = bankAccountMap.get(id);
                        tempAcc.deposit(amount);
                        bankAccountMap.put(id, tempAcc);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                    }else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double newInterestRate = Double.parseDouble(input.split(" ")[1]);
                    BankAccount.setInterestRate(newInterestRate);
                    break;
                case "GetInterest":
                    int id1 = Integer.parseInt(input.split(" ")[1]);
                    int years = Integer.parseInt(input.split(" ")[2]);
                    if (bankAccountMap.containsKey(id1)){
                        double totalInterest = bankAccountMap.get(id1).getInterest(years);
                        System.out.printf("%.2f%n", totalInterest);
                    }else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
            input = scan.nextLine();
        }
    }
}
