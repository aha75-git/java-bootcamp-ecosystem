package bootcamp.ecosystem.students;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StudentProcessing {
    public static void readStudents() {
        // Datei lesen und verarbeiten
        try {
            List<Student> students = Files.lines(Path.of("src/students.csv"))
                    .skip(1)
                    .map(StudentProcessing::convertToStudent)
                    .filter(student -> student != null)
                    .distinct()
                    .toList();
            students.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Student convertToStudent(String line) {
        List<Student> students = new ArrayList<>();
        String[] values = line.split(",");
        if(values.length != 4) {
            return null;
        }

        Integer id = Integer.valueOf(values[0]);
        String name = values[1];
        String postalCode = values[2];
        Integer age = Integer.valueOf(values[3]);
        return new Student(id, name, postalCode, age);
    }
}
