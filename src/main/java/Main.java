import bootcamp.ecosystem.enums.*;
import bootcamp.ecosystem.streams.StreamsManagement;
import bootcamp.ecosystem.students.StudentProcessing;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {
        //EnumsManagement.start();
        //StreamsManagement.start();
        //StudentProcessing.readStudents();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(ANSI_BLUE + "Java Ecosystem Aufgaben" + ANSI_RESET);
            System.out.println("1. Enums Aufgabe ausführen");
            System.out.println("2. Streams Aufgabe ausführen");
            System.out.println("3. Studenten aus der CSV-Datei lesen");
            System.out.println("4. Programm beenden");
            System.out.print("Wählen Sie eine Option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Zeilenumbruch konsumieren

            switch (choice) {
                case 1:
                    EnumsManagement.start();
                    break;
                case 2:
                    StreamsManagement.start();
                    break;
                case 3:
                    StudentProcessing.readStudents();
                    break;
                case 4:
                    System.out.println(ANSI_RED + "Programm beendet." + ANSI_RESET);
                    return;
                default:
                    System.out.println(ANSI_YELLOW + "Ungültige Auswahl. Bitte versuchen Sie es erneut." + ANSI_RESET);
            }
        }
    }
}
