package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] degrees = scan.nextLine().split("[()]");
        int rotateAngle = Integer.parseInt(degrees[1]);
        String input = scan.nextLine();
        List<String> lines = new ArrayList<>();
        int maxLength = Integer.MIN_VALUE;
        while (!input.equals("END")) {
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            lines.add(input);
            input = scan.nextLine();
        }
        int rows = lines.size();
        int cols = maxLength;
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String currentWord = lines.get(row);
            for (int col = 0; col < cols; col++) {
                if (col < currentWord.length()) {
                    char currentChar = currentWord.charAt(col);
                    matrix[row][col] = currentChar;
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        printTheMatrix(rotateAngle, matrix, rows, cols);
    }

    private static void printTheMatrix(int rotateAngle, char[][] matrix, int rows, int cols) {
        int angleOfRotation = rotateAngle % 360;
        switch (angleOfRotation) {
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = matrix.length - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = matrix.length - 1; row >= 0; row--) {
                    for (int col = matrix[row].length - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}
