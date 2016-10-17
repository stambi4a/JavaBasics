package Problem03.LabyrinthDash;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int INITIAL_LIFE_POINTS = 3;
    public static void main(String[] args) {
        walkLabyrinth();
    }

    private static void walkLabyrinth() {
        Scanner scanner = new Scanner(System.in);
        char[][] labyrinth = inputLabyrinth(scanner);
        char[] commandSequence = scanner.nextLine().toCharArray();
        tryWalkLabyrinth(labyrinth, commandSequence);
    }

    private static void tryWalkLabyrinth(
            char[][] labyrinth,
            char[] commandSequence) {
        int coordinates[] = new int[2];
        String walls = "|_";
        String obstacles = "@#*";
        int lifePoints = INITIAL_LIFE_POINTS;
        int moves = 0;
        coordinates[0] = 0;
        coordinates[1] = 0;

        int indexCommand = -1;
        int countCommands = commandSequence.length;
        while(indexCommand < countCommands - 1) {
            indexCommand++;
            char command = commandSequence[indexCommand];
            int[] newCoordinates = tryMove(command, coordinates);
            boolean areValid = areCoordinatesValid(newCoordinates, labyrinth);
            if(!areValid) {
                moves++;
                System.out.println("Fell off a cliff! Game Over!");
                break;
            }

            char symbol = labyrinth[newCoordinates[0]][newCoordinates[1]];
            boolean hasNotHitWall = checkIfNoWall(walls, symbol);
            if(hasNotHitWall) {
                coordinates = newCoordinates;
                moves++;
            } else {
                System.out.println("Bumped a wall.");
                continue;
            }

            if(symbol == ' ') {
                System.out.println("Fell off a cliff! Game Over!");
                break;
            }

            if(symbol == '.') {
                System.out.println("Made a move!");
            }

            if(obstacles.indexOf(symbol) != -1) {
                lifePoints--;
                System.out.println("Ouch! That hurt! Lives left: " + lifePoints);
                if(lifePoints == 0) {
                    System.out.println("No lives left! Game Over!");
                    break;
                }
            }
            if(symbol == '$'){
                lifePoints++;
                System.out.println("Awesome! Lives left: " + lifePoints);
                labyrinth[coordinates[0]][coordinates[1]] = '.';
            }
        }

        System.out.println("Total moves made: " + moves);
    }

    private static boolean checkIfNoWall(String walls, char newSymbol) {
        return (walls.indexOf(newSymbol) == -1);
    }

    private static boolean areCoordinatesValid(
            int[] newCoordinates,
            char[][] labyrinth) {
        boolean areValid = true;
        int rows = labyrinth.length;
        if(newCoordinates[0] < 0 ||
                newCoordinates[1] < 0 ||
                newCoordinates[0] >= rows ||
                newCoordinates[1] >= labyrinth[newCoordinates[0]].length
                ) {
            areValid = false;
        }

        return areValid;
    }

    private static int[] tryMove(
            char command,
            int[] coordinates) {
        int[] newCoordinates = Arrays.copyOf(coordinates, 2);
        switch(command) {
            case '^' : {
                newCoordinates[0]--;
            }

            break;

            case '>' : {
                newCoordinates[1]++;
            }

            break;

            case '<' : {
                newCoordinates[1]--;
            }

            break;

            case 'v' : {
                newCoordinates[0]++;
            }

            break;

            default :  break;
        }

        return newCoordinates;
    }

    private static char[][] inputLabyrinth(Scanner scanner) {
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] labyrinth = new char[rows][];
        for(int i = 0; i < rows; i++) {
            {
                String line = scanner.nextLine();
                labyrinth[i] = line.toCharArray();
            }
        }

        return labyrinth;
    }
}
