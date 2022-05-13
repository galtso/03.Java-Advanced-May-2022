package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> textState = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandLine = scan.nextLine().split("\\s+");
            int command = Integer.parseInt(commandLine[0]);
            switch (command) {
                case 1:
                    textState.push(builder.toString());
                    String textToAppend = commandLine[1];
                    builder.append(textToAppend);
                    break;
                case 2:
                    int count = Integer.parseInt(commandLine[1]);
                    textState.push(builder.toString());
                    int startIndex = builder.length() - count;
                    builder.delete(startIndex, builder.length());
                    break;
                case 3:
                    int position = Integer.parseInt(commandLine[1]);
                    System.out.println(builder.charAt(position - 1));
                    break;
                case 4:
                    if (!textState.isEmpty()) {
                        builder = new StringBuilder(textState.pop());
                    } else {
                        break;
                    }
                    break;
            }
        }
    }
}
