package MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[size][size];
        if (pattern.equals("A")) {
            patternA(matrix);
        } else {
            patternB(matrix);
        }
        printTheMatrix(matrix);
    }

    private static void printTheMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void patternB(int[][] matrix) {
        int currentElement = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = currentElement;
                    currentElement++;
                }
            } else {
                for (int row = matrix[col].length - 1; row >= 0; row--) {
                    matrix[row][col] = currentElement;
                    currentElement++;
                }
            }
        }
    }

    private static void patternA(int[][] matrix) {
        int currentElement = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                matrix[row][col] += currentElement;
                currentElement++;
            }
        }
    }
}
