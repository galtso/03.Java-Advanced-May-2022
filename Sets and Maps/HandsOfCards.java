package SetsAndMaps;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Set<String>> playerCards = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("JOKER")) {
            String name = input.split(": ")[0];
            String[] cards = (input.split(": ")[1]).split(", ");
            for (String card : cards) {
                playerCards.putIfAbsent(name, new LinkedHashSet<>());
                playerCards.get(name).add(card);
            }
            input = scan.nextLine();
        }
        playerCards.forEach((key, value) -> {
            System.out.printf("%s: ", key);
            int sumOfHand = calculateSum(value);
            System.out.printf("%d%n", sumOfHand);
        });
    }

    private static int calculateSum(Set<String> value) {
        int sum = 0;
        for (String s : value) {
            String firstSymbol = s.substring(0, s.length() - 1);
            int firstNumber = getFirstNumber(firstSymbol);
            char secondSymbol = s.charAt(s.length() - 1);
            int secondNumber = getSecondNumber(secondSymbol);
            sum += firstNumber * secondNumber;
        }
        return sum;
    }

    private static int getSecondNumber(char secondSymbol) {
        int number = 0;
        switch (secondSymbol) {
            case 'S':
                number = 4;
                break;
            case 'H':
                number = 3;
                break;
            case 'D':
                number = 2;
                break;
            case 'C':
                number = 1;
                break;
        }
        return number;
    }

    private static int getFirstNumber(String firstSymbol) {
        switch (firstSymbol) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(firstSymbol);
        }
    }
}
