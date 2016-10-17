package Problem03.ExamScore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        calculateScores();
    }

    private static void printResults(TreeMap<Integer, TreeMap<String, Double>> studentsByExamScores) {
        for(Integer examScore : studentsByExamScores.keySet()) {
            double averageGrade = 0d;
            for(String student : studentsByExamScores.get(examScore).keySet()) {
                averageGrade += studentsByExamScores.get(examScore).get(student);
            }

            averageGrade /= studentsByExamScores.get(examScore).values().size();
            System.out.println(examScore + " -> [" + String.join(", ", studentsByExamScores.get(examScore).keySet()) + "]; avg=" +
            String.format("%.2f",averageGrade));
        }
    }

    private static void calculateScores() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.nextLine();
        scanner.nextLine();
        TreeMap<Integer, TreeMap<String, Double>> studentsByExamScores = new TreeMap<>();
        while(true) {
            String input = scanner.nextLine();
            if(input.startsWith("-")) {
                break;
            }

            String paramPattern = "[^\\|\\s+]+";
            Pattern pattern = Pattern.compile(paramPattern);
            Matcher match = pattern.matcher(input);
            String[] params = new String[4];
            int i = 0;
            while(match.find()){
                params[i] = match.group();
                i++;
            }

            String student = params[0] + " " + params[1];
            int examScore = Integer.parseInt(params[2]);
            Double grade = Double.parseDouble(params[3]);
            studentsByExamScores.putIfAbsent(examScore, new TreeMap<>());
            studentsByExamScores.get(examScore).put(student, grade);
        }

        printResults(studentsByExamScores);
    }
}
