package Problem03.FireTheArrows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        fireTheArrows();
    }

    public static void fireTheArrows() {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = inputMatrix(scanner);
        while(true) {
            if(!tryMoveArrows(matrix)) {
                break;
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        int rows = matrix.length;
        for(int i = 0; i < rows; i++) {
            String row = new String(matrix[i]);
            System.out.println(row);
        }
    }

    private static boolean tryMoveArrows(char[][] matrix) {
        int columns = matrix[0].length;
        int rows = matrix.length;
        boolean matrixHasChanged = false;
        for(int i = 0 ; i < matrix.length; i++) {
            int row = i;
            int column = i;
            for(int j = 0; j < columns; j++) {
                matrixHasChanged = checkCell(matrix, row, j) || matrixHasChanged;
            }

            /*for(int j = row + 1; j < rows; j++) {
                if(column >= columns) {
                    column = columns - 1;
                }

                matrixHasChanged = checkCell(matrix, j, column) || matrixHasChanged;
            }*/
        }

        return matrixHasChanged;
    }

    private static boolean moveUp(char[][] matrix, int row, int indexColumn) {
        boolean hasMoved = false;
        if(row - 1 >= 0 && matrix[row - 1][indexColumn] == 'o') {
            hasMoved = true;
            matrix[row - 1][indexColumn] = '^';
            matrix[row][indexColumn] = 'o';
        }

        return hasMoved;
    }

    private static boolean moveRight(char[][] matrix, int row, int indexColumn) {
        boolean hasMoved = false;
        int columns = matrix[0].length;
        if(indexColumn + 1 < columns && matrix[row][indexColumn + 1] == 'o') {
            matrix[row][indexColumn + 1] = '>';
            matrix[row][indexColumn] = 'o';
            hasMoved = true;
        }

        return hasMoved;
    }

    private static boolean moveLeft(char[][] matrix, int row, int indexColumn) {
        boolean hasMoved = false;
        if(indexColumn - 1 >= 0 && matrix[row][indexColumn - 1] == 'o') {
            matrix[row][indexColumn - 1] = '<';
            matrix[row][indexColumn] = 'o';
            hasMoved = true;
        }

        return hasMoved;
    }

    private static boolean moveDown(char[][] matrix, int row, int indexColumn) {
        int rows = matrix.length;
        boolean hasMoved = false;
        if(row + 1 < rows  && matrix[row + 1][indexColumn] == 'o') {
            matrix[row + 1][indexColumn] = 'v';
            matrix[row][indexColumn] = 'o';
            hasMoved = true;
        }

        return hasMoved;
    }

    private static boolean checkCell(char[][]matrix, int row, int indexColumn) {
        boolean cellIsChanged = false;
        switch(matrix[row][indexColumn]) {
            case 'o' : {
            }

            break;
            case '^' :{
                cellIsChanged = moveUp(matrix, row, indexColumn);
            }

            break;

            case 'v' :{
                cellIsChanged = moveDown(matrix, row, indexColumn);
            }

            break;

            case '>' :{
                cellIsChanged = moveRight(matrix, row, indexColumn);
            }

            break;

            case '<' :{
                cellIsChanged = moveLeft(matrix, row, indexColumn);
            }

            break;
            default : break;
        }

        return cellIsChanged;
    }

    private static char[][] inputMatrix(Scanner scanner) {
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][];
        for(int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        return matrix;
    }
}
