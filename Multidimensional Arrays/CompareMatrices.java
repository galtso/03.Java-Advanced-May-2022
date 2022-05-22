package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstMatrixRows = dimensions[0];
        int firstMatrixCols = dimensions[1];
        int[][] firstMatrix = new int[firstMatrixRows][firstMatrixCols];
        for (int row = 0; row < firstMatrixRows; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            firstMatrix[row] = arr;
        }
        dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int secondMatrixRows = dimensions[0];
        int secondMatrixCols = dimensions[1];
        int[][] secondMatrix = new int[secondMatrixRows][secondMatrixCols];
        for (int row = 0; row < secondMatrixRows; row++) {
            int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            secondMatrix[row] = arr;
        }
        boolean areEqual = compareMatrices(firstMatrix, secondMatrix);
        if (areEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}
