package bootcamp.ecosystem.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeManagement {
    public static String getActualDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return now.format(formatter);
    }

    public static String addDateToActualDateTime(long weeks) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime now = LocalDateTime.now();
        return now.plusWeeks(weeks).format(formatter);
    }

    public static void compareActualDateWithPassedDateAndDisplayResult(LocalDate dateToCompare) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        if (now.isBefore(dateToCompare)) {
            System.out.println("Das aktuelle Datum " + now.format(formatter) + " liegt vor dem angegeben Datum:  " + dateToCompare.format(formatter));
        } else if (now.isAfter(dateToCompare)) {
            System.out.println("Das aktuelle Datum " + now.format(formatter) + " liegt nach dem angegeben Datum: " + dateToCompare.format(formatter));
        }
    }

    public static void calculateDifferenceInDaysBetweenTwoDatesAndDisplayResult(LocalDate dateFirst, LocalDate dateSecond) {
        long diffDays = ChronoUnit.DAYS.between(dateFirst, dateSecond);
        System.out.println("Differenz in Tagen: " + diffDays);
    }

    public static void executeExercises() {
        System.out.println();
        System.out.println(getActualDateTime());
        System.out.println();
        System.out.println(addDateToActualDateTime(2));
        System.out.println();
        compareActualDateWithPassedDateAndDisplayResult(LocalDate.now().plusDays(3));
        compareActualDateWithPassedDateAndDisplayResult(LocalDate.now().minusDays(3));
        System.out.println();
        calculateDifferenceInDaysBetweenTwoDatesAndDisplayResult(LocalDate.of(2025, 9, 1),
                LocalDate.of(2025, 10, 15));
        System.out.println();
    }
}
