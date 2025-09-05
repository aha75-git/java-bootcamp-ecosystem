package bootcamp.ecosystem.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsManagement {
    public static void start() {
        // Ursprüngliche Liste von Zahlen
        List<Integer> list = Arrays.asList(4, 5, 6, 1, 2, 12, 22, 3, 11, 7, 8, 9, 10, 15);

        // Schritt 1: Filtere die geraden Zahlen
        List<Integer> evenNumbers = list.stream().filter(x -> x % 2 == 0).toList();
        System.out.println("Schritt 1: Filtere die geraden Zahlen");
        System.out.println(evenNumbers);
        System.out.println();

        // Schritt 2: Verdopple jede Zahl
        List<Integer> doubledNumbers = evenNumbers.stream().map(x -> x * 2).toList();
        System.out.println("Schritt 2: Verdopple jede Zahl");
        System.out.println(doubledNumbers);
        System.out.println();

        // Schritt 3: Sortiere die Liste in aufsteigender Reihenfolge
        List<Integer> sortedNumbers = doubledNumbers.stream().sorted().toList();
        System.out.println("Schritt 3: Sortiere die Liste in aufsteigender Reihenfolge");
        System.out.println(sortedNumbers);
        System.out.println();

        // Schritt 4: Berechne die Summe aller Zahlen
        int sum = sortedNumbers.stream().reduce(0, Integer::sum);
        System.out.println("Schritt 4: Berechne die Summe aller Zahlen");
        System.out.println("Summe der verarbeiteten Zahlen: " + sum);
        System.out.println();

        // Schritt 5: Gib jede verarbeitete Zahl aus
        System.out.println("Schritt 5: Gib jede verarbeitete Zahl aus");
        sortedNumbers.forEach(System.out::println);
        System.out.println();

        // Schritt 6: Sammle die verarbeiteten Zahlen in einer neuen Liste
        List<Integer> processedNumbers = sortedNumbers.stream().toList();
        System.out.println("Schritt 6: Sammle die verarbeiteten Zahlen in einer neuen Liste");
        System.out.println(processedNumbers);
    }

    public static void start2() {
        // Ursprüngliche Liste von Zahlen
        List<Integer> list = Arrays.asList(4, 5, 6, 1, 2, 12, 22, 3, 11, 7, 8, 9, 10, 15);

        // Schritt 1: Filtere die geraden Zahlen
        List<Integer> processedNumbers = list.stream().filter(x -> x % 2 == 0)
                .map(x -> x * 2)
                .sorted()
                .toList();
        processedNumbers.forEach(System.out::println);
        int sum = processedNumbers.stream().reduce(0, Integer::sum);
        System.out.println("Summe der verarbeiteten Zahlen: " + sum);
    }
}
