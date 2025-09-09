package bootcamp.ecosystem.animal;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Animal {
    private String name;
    private LocalDate birthDate;

    public Animal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public long daysUntilNextBirthday() {
        LocalDate now = LocalDate.now();
        LocalDate nextBirthday = birthDate.withYear(now.getYear());

        // Wenn der Geburtstag in der Vergangenheit liegt, auf das nächste Jahr setzen
        if(nextBirthday.isBefore(now) || nextBirthday.isEqual(now)) {
            nextBirthday = nextBirthday.plusYears(1);
        }
        return ChronoUnit.DAYS.between(now, nextBirthday);
    }

    public void printDaysUntilNextBirthday() {
        System.out.println("Es sind noch " + this.daysUntilNextBirthday() + " Tage bis zu " + this.getName() + "'s nächsten Geburtstag.");
        System.out.println();
    }
}
