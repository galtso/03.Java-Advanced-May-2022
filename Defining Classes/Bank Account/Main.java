package DefiningClasses.BancAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        Map<Integer, BankAccount> accounts = new HashMap<>();
        String command = input[0];
        while (!command.equals("End")) {
            String output = "";
            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    accounts.put(bankAccount.getId(), bankAccount);
                    output = String.format("Account ID%d created", bankAccount.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(input[1]);
                    double amount = Double.parseDouble(input[2]);
                    if (accounts.containsKey(id)) {
                        BankAccount bankAccountFromMap = accounts.get(id);
                        bankAccountFromMap.deposit(amount);
                        accounts.put(id, bankAccountFromMap);
                        output = String.format("Deposited %.0f to ID%d", amount, id);
                    } else {
                        output = "Account does not exist";
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(input[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int getInterestId = Integer.parseInt(input[1]);
                    int years = Integer.parseInt(input[2]);
                    if (accounts.containsKey(getInterestId)) {
                        BankAccount bankAccount1 = accounts.get(getInterestId);
                        double sumOfInterest = bankAccount1.getInterest(years);
                        output = String.format("%.2f", sumOfInterest);
                    } else {
                        output = "Account does not exist";
                    }
                    break;
            }
            if (!output.isEmpty()) {
                System.out.println(output);
            }
            input = scan.nextLine().split("\\s+");
            command = input[0];
        }
    }
}
