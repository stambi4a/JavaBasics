package Problem04.SchoolSystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        calculateGrades();
    }

    private static void calculateGrades() {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, TreeMap<String, List<Integer>>> grades = new TreeMap<>();
        int lines = Integer.parseInt(scanner.nextLine());
        int index = 1;
        while(index <= lines) {
            String input = scanner.nextLine();
            addGrade(grades, input);
            index++;
        }

        printResults(grades);
    }

    private static void printResults(TreeMap<String, TreeMap<String, List<Integer>>> grades) {
        for(String student : grades.keySet()) {
            System.out.print(student + ": ");
            List<String> averageGrades = new ArrayList<>();
            for(String subject : grades.get(student).keySet()) {
                Double sumGrades = 0d;
                List<Integer> subjectGrades = grades.get(student).get(subject);
                for(Integer grade : subjectGrades){
                    sumGrades += grade;
                }

                sumGrades /= subjectGrades.size();

                averageGrades.add(subject + " - " + String.format(Locale.ENGLISH, "%.2f", sumGrades));
            }
            System.out.println("[" + String.join(", ", averageGrades) + "]");
        }
    }

    private static void addGrade(TreeMap<String, TreeMap<String, List<Integer>>> grades, String input) {
        String[] params = input.split("\\s+");
        String name = params[0] + " " + params[1];
        String subject = params[2];
        int grade = Integer.parseInt(params[3]);
        grades.putIfAbsent(name, new TreeMap<>());
        grades.get(name).putIfAbsent(subject, new ArrayList<>());
        grades.get(name).get(subject).add(grade);
    }
}
