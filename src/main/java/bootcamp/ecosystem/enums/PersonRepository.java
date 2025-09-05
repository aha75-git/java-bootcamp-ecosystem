package bootcamp.ecosystem.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonRepository {
    private final List<Person> people;

    public PersonRepository() {
        this.people = new ArrayList<>();
    }

    public void add(Person person) {
        this.people.add(person);
    }

    public List<Person> getPeople() {
        return this.people;
    }

    public String printPeople() {
        StringBuilder sb = new StringBuilder();
        for (Person person : this.people) {
            sb.append("Name: ")
                    .append(person.name())
                    .append(" , Lieblingstag: " )
                    .append(person.favoriteDay().getValue())
                    .append("\n");
        }
        return sb.toString();
    }

    public void printCountsNumberOfPeopleByGender() {
        for(Map.Entry<Gender, Long> entries :  countByGender(this.people).entrySet()) {
            if (entries.getKey().equals(Gender.MALE)) {
                System.out.println("Anzahl der männlichen Personen: " + entries.getValue());
            } else if(entries.getKey().equals(Gender.FEMALE)) {
                System.out.println("Anzahl der weiblichen Personen: " + entries.getValue());
            } else if(entries.getKey().equals(Gender.OTHER)) {
                System.out.println("Anzahl der diversen Personen: " + entries.getValue());
            }
        }
    }

    public static Map<Gender, Long> countByGender(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(Person::gender, Collectors.counting()));
    }

    public List<Person> searchForPeoplesFavoriteDay(DaysOfWeek dayOfWeek) {
        List<Person> people = new ArrayList<>();
        for (Person person : this.people) {
            if(person.favoriteDay().equals(dayOfWeek)) {
                people.add(person);
            }
        }
        return people;
    }
}
