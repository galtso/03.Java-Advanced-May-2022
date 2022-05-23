package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        System.out.printf("%d%n%d%n", rows, cols);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
        int sum = 0;
        for (int[] row : matrix) {
            for (int i : row) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
