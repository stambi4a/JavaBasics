package Problem03.LegoBlocks;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        playWithLegoBlocks();
    }

    private static void playWithLegoBlocks() {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] firstBlock = createLegoBlock(scanner, rows);
        int[][] secondBlock = createLegoBlock(scanner, rows);
        tryFitBlocks(firstBlock, secondBlock, rows);
    }

    private static void tryFitBlocks(int[][] firstBlock, int[][] secondBlock, int rows) {
        int columns = firstBlock[0].length + secondBlock[0].length;
        int index = 1;
        boolean blocksFit = true;
        int cellCount = columns;
        while(index < rows) {
            int nextColumns = firstBlock[index].length + secondBlock[index].length;
            if(nextColumns != columns) {
                blocksFit = false;
            }

            cellCount += nextColumns;
            index++;
        }

        if(blocksFit) {
            int[][] newBlock = fitBlocks(firstBlock, secondBlock, rows, columns);
            printNewBlock(newBlock, rows, columns);
        } else {
            System.out.printf("The total number of cells is: %d", cellCount);
        }
    }

    private static void printNewBlock(int[][] newBlock, int rows, int columns) {
        for(int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(newBlock[i]));
        }
    }

    private static void reverseArray(int[] array) {
        int length = array.length;
        for(int i = 0; i < length / 2; i++) {
            int swap = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = swap;
        }
    }

    private static int[][] fitBlocks(int[][] firstBlock, int[][] secondBlock, int rows, int columns) {
        int[][] newBlock = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            int lengthFirst = firstBlock[i].length;
            System.arraycopy(firstBlock[i], 0, newBlock[i], 0, lengthFirst);
            reverseArray(secondBlock[i]);
            System.arraycopy(secondBlock[i], 0, newBlock[i], lengthFirst, columns - lengthFirst);
        }

        return newBlock;
    }

    private static int[][] createLegoBlock(Scanner scanner, int rows) {
        int[][] legoBlock = new int[rows][];
        for(int i = 0; i < rows; i++) {

            legoBlock[i] = Arrays.asList(scanner.nextLine().trim().split("\\s+")).
                    stream().
                    mapToInt(Integer::parseInt).
                    toArray();
        }

        return legoBlock;
    }
}