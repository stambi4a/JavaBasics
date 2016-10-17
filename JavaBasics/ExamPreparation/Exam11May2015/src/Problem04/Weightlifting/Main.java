package Problem04.Weightlifting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        trainWightLifters();
    }

    private static void trainWightLifters() {
        Scanner scanner = new Scanner(System.in);
        int countLines = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeMap<String , Long>> exercises = new TreeMap<>();
        int index = 1;
        while(index <= countLines) {
            String[] params = scanner.nextLine().split(" ");
            addExercise(exercises, params);
            index++;
        }

        printResullts(exercises);
    }

    private static void printResullts( TreeMap<String, TreeMap<String , Long>> exercises) {
        for(String lifter : exercises.keySet()) {
            System.out.printf("%s : ", lifter);
            List<String> lifterResults = new ArrayList<>();
            exercises.get(lifter).keySet().
                    forEach((exercise) -> lifterResults.add(exercise + " - " + exercises.get(lifter).get(exercise) + " kg"));
            /*for(String exercise : exercises.get(lifter).keySet()) {
                lifterResults.add(exercise + " - " + exercises.get(lifter).get(exercise) + " kg");
            }*/
            System.out.println(String.join(", ", lifterResults));
        }
    }

    private static void addExercise(TreeMap<String, TreeMap<String , Long>> exercises, String[] params) {
        String lifter = params[0];
        String exercise = params[1];
        Long weight = Long.parseLong(params[2]);
        exercises.putIfAbsent(lifter, new TreeMap<>());
        exercises.get(lifter).putIfAbsent(exercise, 0L);
        Long weightSofar = exercises.get(lifter).get(exercise);
        exercises.get(lifter).put(exercise, weightSofar + weight);
    }
}
