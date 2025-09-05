package bootcamp.ecosystem.enums;

import java.util.ArrayList;
import java.util.List;

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
        int countMale = 0;
        int  countFemale = 0;
        int countOther = 0;

        for (Person person : this.people) {
            if(person.gender() == Gender.MALE) {
                countMale++;
            } else if(person.gender() == Gender.FEMALE) {
                countFemale++;
            } else if(person.gender() == Gender.OTHER) {
                countOther++;
            }
        }
        System.out.println("Anzahl der männlichen Personen: " + countMale);
        System.out.println("Anzahl der weiblichen Personen: " + countFemale);
        System.out.println("Anzahl der diversen Personen: " + countOther);
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
