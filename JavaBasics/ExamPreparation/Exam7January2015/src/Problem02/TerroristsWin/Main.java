package Problem02.TerroristsWin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        explodeBombs();
    }

    private static void explodeBombs() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int startIndex = 0;
        while(true) {
            startIndex = line.indexOf("|", startIndex);
            if(startIndex == -1) {
                break;
            }

            int endIndex = line.indexOf("|", startIndex + 1);
            if (endIndex == -1) {
                 break;
            }

            String bombCenter = line.substring(startIndex + 1, endIndex);
            int bombPower = calculateBombPower(bombCenter);
            line = explodeBomb(line, startIndex, endIndex, bombPower);

            startIndex = endIndex + 1;
        }

        System.out.println(line);
    }

    private static String explodeBomb(String line, int startIndex, int endIndex, int bombPower) {
        int length = line.length();
        char[] charArray = new char[length];
        int indexBeforeBomb = startIndex - bombPower;
        for(int i = 0; i < indexBeforeBomb; i++) {
            charArray[i] = line.charAt(i);
        }

        int indexafterBomb = endIndex + bombPower + 1;
        for(int i = indexBeforeBomb > 0 ? indexBeforeBomb : 0; i < indexafterBomb && i < length; i++) {
            charArray[i] = '.';
        }

        for(int i = indexafterBomb; i < length; i++) {
            charArray[i] = line.charAt(i);
        }

        String newLine = new String(charArray);

        return newLine;
    }

    private static int calculateBombPower(String bombCenter) {
        int length = bombCenter.length();
        int sumChars = 0;
        for(int i = 0; i < length; i++) {
            sumChars += bombCenter.charAt(i);
        }

        int bombPower = sumChars % 10;

        return bombPower;
    }
}
