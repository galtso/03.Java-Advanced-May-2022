package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[rows][];
        int[][] newMatrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
            newMatrix[row] = arr;
        }
        String[] index = scan.nextLine().split("\\s+");
        int wrongNumber = matrix[Integer.parseInt(index[0])][Integer.parseInt(index[1])];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongNumber) {
                    newMatrix[row][col] = newNumber(row, col, matrix, wrongNumber);
                }
            }
        }

        for (int[] r : newMatrix) {
            for (int i : r) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static int newNumber(int row, int col, int[][] matrix, int wrongNumber) {
        int sum = 0;
        if (row - 1 >= 0) {
            if (matrix[row - 1][col] != wrongNumber) {
                sum += matrix[row - 1][col];
            }
        }
        if (row + 1 < matrix.length) {
            if (matrix[row + 1][col] != wrongNumber) {
                sum += matrix[row + 1][col];
            }
        }
        if (col - 1 >= 0) {
            if (matrix[row][col - 1] != wrongNumber) {
                sum += matrix[row][col - 1];
            }
        }
        if (col + 1 < matrix[row].length) {
            if (matrix[row][col + 1] != wrongNumber) {
                sum += matrix[row][col + 1];
            }
        }

        return sum;
    }
}
