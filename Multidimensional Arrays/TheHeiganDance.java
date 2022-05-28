package MultidimensionalArrays;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double damage = Double.parseDouble(scan.nextLine());
        double playerLife = 18500;
        double heiganLife = 3000000;
        int startRow = 7;
        int startCol = 7;
        String lastSpell = "";
        boolean activeCloud = false;

        while (playerLife > 0 && heiganLife > 0) {
            heiganLife -= damage;
            if (activeCloud) {
                playerLife -= 3500;
                activeCloud = false;
                if (playerLife < 0) {
                    break;
                }
            }
            if (heiganLife < 0) {
                break;
            }
            String[] input = scan.nextLine().split("\\s+");
            String spell = input[0];
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);

            boolean[][] heiganChamber = new boolean[15][15];
            for (int i = row - 1; i <= row + 1; i++) {
                if (i >= 0 && i < heiganChamber.length) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (j >= 0 && j < heiganChamber[row].length) {
                            heiganChamber[i][j] = true;
                        }
                    }
                }
            }

            if (heiganChamber[startRow][startCol]) {
                if (isValidRow(heiganChamber, startRow - 1) && !heiganChamber[startRow - 1][startCol]) {
                    startRow--;
                } else if (isValidCol(heiganChamber, startCol + 1) && !heiganChamber[startRow][startCol + 1]) {
                    startCol++;
                } else if (isValidRow(heiganChamber, startRow + 1) && !heiganChamber[startRow + 1][startCol]) {
                    startRow++;
                } else if (isValidCol(heiganChamber, startCol - 1) && !heiganChamber[startRow][startCol - 1]) {
                    startCol--;
                }

                if (heiganChamber[startRow][startCol]) {
                    switch (spell) {
                        case "Cloud":
                            playerLife -= 3500;
                            activeCloud = true;
                            lastSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playerLife -= 6000;
                            lastSpell = spell;
                            break;
                    }
                }
            }
        }
        if (heiganLife > 0) {
            System.out.printf("Heigan: %.2f%n", heiganLife);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerLife > 0) {
            System.out.printf("Player: %d%n", (int)playerLife);
        } else {
            System.out.printf("Player: Killed by %s%n", lastSpell);
        }
        System.out.printf("Final position: %d, %d", startRow, startCol);
    }

    private static boolean isValidCol(boolean[][] heiganChamber, int i) {
        return i >= 0 && i < heiganChamber.length;
    }

    private static boolean isValidRow(boolean[][] heiganChamber, int i) {
        return i >= 0 && i < heiganChamber[i].length;
    }
}
