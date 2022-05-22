package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
        int number = Integer.parseInt(scan.nextLine());
        ArrayList<String> outputLine = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == number) {
                    outputLine.add(row + " " + col);
                }
            }
        }
        if (outputLine.isEmpty()) {
            System.out.println("not found");
        } else {
            for (String s : outputLine) {
                System.out.println(s);
            }
        }
    }
}
