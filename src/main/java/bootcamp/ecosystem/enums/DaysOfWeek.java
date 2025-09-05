package bootcamp.ecosystem.enums;

import java.util.Arrays;

public enum DaysOfWeek {
    MONDAY("Montag"),
    TUESDAY("Dienstag"),
    WEDNESDAY("Mittwoch"),
    THURSDAY("Donnerstag"),
    FRIDAY("Freitag"),
    SATURDAY("Wochenende"),
    SUNDAY("Wochenende");

    private String value;

    DaysOfWeek(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static String[] names() {
        return Arrays.stream(DaysOfWeek.values())
                .map(Enum::name)
                .toArray(String[]::new);
    }
}
