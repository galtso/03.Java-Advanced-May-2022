package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }

        int firstDiagonal = getFirst(matrix, size);
        int secondDiagonal = getSecond(matrix, size);
        System.out.println(Math.abs(firstDiagonal - secondDiagonal));
    }

    private static int getSecond(int[][] matrix, int size) {
        int sum = 0;
        int row = size - 1;
        int col = 0;
        while (isInRange(row, col, matrix)) {
            for (int i = 0; i < size; i++) {
                sum += matrix[row][col];
                row--;
                col++;
            }
        }
        return sum;
    }

    private static boolean isInRange(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static int getFirst(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}
