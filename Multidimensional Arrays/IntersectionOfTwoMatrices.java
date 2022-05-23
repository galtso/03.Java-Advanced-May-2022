package MultidimensionalArrays;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());
        char[][] firstMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            char[] arr = scan.nextLine().replace(" ", "").toCharArray();
            firstMatrix[row] = arr;
        }
        char[][] secondMatrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            char[] arr = scan.nextLine().replace(" ", "").toCharArray();
            secondMatrix[row] = arr;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    firstMatrix[row][col] = firstMatrix[row][col];
                } else {
                    firstMatrix[row][col] = '*';
                }
            }
        }
        for (char[] matrix : firstMatrix) {
            for (char c : matrix) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
