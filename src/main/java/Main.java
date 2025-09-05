import bootcamp.ecosystem.enums.DaysOfWeek;
import bootcamp.ecosystem.enums.Gender;
import bootcamp.ecosystem.enums.Person;
import bootcamp.ecosystem.enums.PersonRepository;

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
    }
}
