package Problem01.GandalfsStash;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        measureGandalfMood();
    }

    private static void measureGandalfMood() {
        Scanner scanner = new Scanner(System.in);
        int initialMoodPoints = Integer.parseInt(scanner.nextLine());
        int moodPoints = initialMoodPoints;
        String foodSequence = scanner.nextLine().toLowerCase();
        String[] foods = foodSequence.split("[^a-z]+");
        int length = foods.length;
        for(int i = 0; i < length; i++) {
            moodPoints += gandalfEatsFood(foods[i]);
        }

        System.out.println(moodPoints);
        String mood = checkMood(moodPoints);
        System.out.println(mood);
    }

    private static String checkMood(int moodPoints) {
        String mood = null;
        if(moodPoints < -5) {
            mood = "Angry";
        }

        if(moodPoints >= -5 && moodPoints < 0) {
            mood = "Sad";
        }

        if(moodPoints >= 0 && moodPoints <= 15) {
            mood = "Happy";
        }

        if(moodPoints > 15) {
            mood = "Special JavaScript mood";
        }

        return mood;
    }

    private static int gandalfEatsFood(String food) {
        switch(food) {
            case "cram" : {
                return 2;
            }

            case "lembas" : {
                return 3;
            }

            case "apple" : {
                return 1;
            }

            case "melon" : {
                return 1;
            }

            case "honeycake" : {
                return 5;
            }

            case "mushrooms" : {
                return -10;
            }

            default : {
                return -1;
            }
        }
    }
}
