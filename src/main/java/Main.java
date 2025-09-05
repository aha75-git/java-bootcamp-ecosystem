import bootcamp.ecosystem.enums.DaysOfWeek;
import bootcamp.ecosystem.enums.Gender;
import bootcamp.ecosystem.enums.Person;
import bootcamp.ecosystem.enums.PersonRepository;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();
        personRepository.add(new Person("1", "John Doe", DaysOfWeek.FRIDAY, Gender.MALE));
        personRepository.add(new Person("2", "Jane Doe", DaysOfWeek.MONDAY, Gender.FEMALE));
        personRepository.add(new Person("3", "Melanie Doe", DaysOfWeek.SATURDAY, Gender.FEMALE));
        personRepository.add(new Person("4", "Alex Doe", DaysOfWeek.SUNDAY, Gender.MALE));
        personRepository.add(new Person("5", "Peter Doe", DaysOfWeek.FRIDAY, Gender.MALE));

        System.out.println(personRepository.printPeople());
        System.out.println();
        personRepository.printCountsNumberOfPeopleByGender();
        System.out.println();
        System.out.println("Personen mit dem Lieblingswochentag Montag:");
        System.out.println(personRepository.searchForPeoplesFavoriteDay(DaysOfWeek.MONDAY));
        System.out.println();
        System.out.println("Personen mit dem Lieblingswochentag Montag:");
        System.out.println(personRepository.searchForPeoplesFavoriteDay(DaysOfWeek.FRIDAY));

        System.out.println("\r\n##################  Person anhand ihrer ID suchen  ##################\r\n");
        Optional<Person> personOptional = personRepository.searchForPersonById("2");
        if(personOptional.isPresent()) {
            System.out.println("Name: " + personOptional.get().name() + " Lieblingstag: " + personOptional.get().favoriteDay().getValue());
        }

        System.out.println();
        personOptional = personRepository.searchForPersonById("5");
        personOptional.ifPresent(person -> System.out.println("Name: " + person.name() + " Lieblingstag: " + person.favoriteDay().getValue()));

        System.out.println();
        personOptional = personRepository.searchForPersonById("6");
        personOptional.ifPresent(person -> System.out.println("Name: " + person.name() + " Lieblingstag: " + person.favoriteDay().getValue()));

        System.out.println("##################  Person anhand ihres Namens suchen  ##################\r\n");
        personOptional = personRepository.searchForPersonByName("Jane Doe");
        personOptional.ifPresent(person -> System.out.println("Name: " + person.name() + " Lieblingstag: " + person.favoriteDay().getValue()));

        System.out.println();
        personOptional = personRepository.searchForPersonByName("Alex Doner");
        personOptional.ifPresent(person -> System.out.println("Name: " + person.name() + " Lieblingstag: " + person.favoriteDay().getValue()));
    }
}
