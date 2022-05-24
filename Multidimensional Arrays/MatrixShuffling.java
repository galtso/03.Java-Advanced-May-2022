package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] arr = scan.nextLine().split(" ");
            matrix[row] = arr;
        }
        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] command = input.split("\\s+");
            if (command.length != 5 || !command[0].equals("swap")) {
                System.out.println("Invalid input!");
            } else {
                int firstRow = Integer.parseInt(command[1]);
                int firstCol = Integer.parseInt(command[2]);
                int secondRow = Integer.parseInt(command[3]);
                int secondCol = Integer.parseInt(command[4]);
                if (!isValidIndex(firstRow, firstCol, secondRow, secondCol, rows, cols)) {
                    System.out.println("Invalid input!");
                } else {
                    String currentElement = matrix[firstRow][firstCol];
                    matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
                    matrix[secondRow][secondCol] = currentElement;
                    printTheMatrix(matrix);
                }
            }
            input = scan.nextLine();
        }
    }

    private static void printTheMatrix(String[][] matrix) {
        for (String[] r : matrix) {
            for (String i : r) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidIndex(int firstRow, int firstCol, int secondRow, int secondCol, int rows, int cols) {
        return firstRow < rows && firstCol < cols && secondRow < rows && secondCol < cols;
    }
}
