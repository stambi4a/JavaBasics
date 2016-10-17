package Problem01.Pyramid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        findSequenceInPyramid();
    }

    private static void findSequenceInPyramid() {
        Scanner scanner = new Scanner(System.in);
        int[][] pyramid = inputPyramid(scanner);
        List<Integer> sequence = findSequence(pyramid);
        printSequence(sequence);
    }

    private static void printSequence(List<Integer> sequence) {
        System.out.println(sequence.toString().replaceAll("[\\[\\]]", ""));
    }

    private static List<Integer> findSequence(int[][] pyramid) {
        int number = pyramid[0][0];
        int rows = pyramid.length;
        List<Integer> sequence = new ArrayList<>();
        sequence.add(number);
        for(int i = 1; i < rows; i++) {
            int columns = pyramid[i].length;
            int next = 0;
            int index = 0;
            while(index < columns) {
                if(pyramid[i][index] > number) {
                    next = pyramid[i][index];
                    break;
                }

                index++;
            }

            if(index < columns) {
                for(int j = index + 1; j < columns; j++) {
                    if(pyramid[i][j] < next && pyramid[i][j] > number) {
                        next = pyramid[i][j];
                        number = next;
                    }
                }
                sequence.add(next);
                number = next;
            } else {
                 number = number + 1;
            }
        }

        return sequence;
    }

    private static int[][] inputPyramid(Scanner scanner) {
        int countLines = Integer.parseInt(scanner.nextLine());
        int index = 0;
        int[][] pyramid = new int[countLines][];
        while(index < countLines) {
            pyramid[index] = Arrays.
                    asList(scanner.nextLine().trim().split("\\s+")).
                    stream().
                    mapToInt(Integer::parseInt).
                    toArray();
            index++;
        }

        return pyramid;
    }
}
