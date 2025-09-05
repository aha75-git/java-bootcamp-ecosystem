package bootcamp.ecosystem.enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PersonRepositoryTest {
    private PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        personRepository = new PersonRepository();
    }

    @Test
    void testAddPerson() {
        Person person = new Person("1", "John Doe", DaysOfWeek.FRIDAY, Gender.MALE);
        personRepository.add(person);
        assertEquals(1, personRepository.getPeople().size());
        assertEquals(person, personRepository.getPeople().getFirst());
    }

    @Test
    void testPrintPeople() {
        Person person1 = new Person("1", "John Doe", DaysOfWeek.FRIDAY, Gender.MALE);
        Person person2 = new Person("2", "Jane Doe", DaysOfWeek.MONDAY, Gender.FEMALE);
        personRepository.add(person1);
        personRepository.add(person2);

        String expectedOutput = "Name: John Doe , Lieblingstag: Freitag\n" +
                "Name: Jane Doe , Lieblingstag: Montag\n";
        assertEquals(expectedOutput, personRepository.printPeople());
    }

    @Test
    void testCountByGender() {
        personRepository.add(new Person("1", "John Doe", DaysOfWeek.FRIDAY, Gender.MALE));
        personRepository.add(new Person("2", "Jane Doe", DaysOfWeek.MONDAY, Gender.FEMALE));
        personRepository.add(new Person("3", "Melanie Doe", DaysOfWeek.SATURDAY, Gender.FEMALE));
        personRepository.add(new Person("4", "Alex Doe", DaysOfWeek.SUNDAY, Gender.MALE));
        personRepository.add(new Person("5", "Peter Doe", DaysOfWeek.FRIDAY, Gender.MALE));
        personRepository.add(new Person("6", "Divo Doe", DaysOfWeek.TUESDAY, Gender.OTHER));

        // Capture the output
        String expectedOutput = "Anzahl der männlichen Personen: 3\r\n" +
                "Anzahl der weiblichen Personen: 2\r\n" +
                "Anzahl der diversen Personen: 1\r\n";
        //assertEquals(expectedOutput, personRepository.printCountsNumberOfPeopleByGender());
        assertEquals(6, personRepository.getPeople().size());
    }

    @Test
    void testSearchForPeoplesFavoriteDay() {
        Person person1 = new Person("1", "John Doe", DaysOfWeek.FRIDAY, Gender.MALE);
        Person person2 = new Person("2", "Jane Doe", DaysOfWeek.MONDAY, Gender.FEMALE);
        personRepository.add(person1);
        personRepository.add(person2);
        personRepository.add(new Person("3", "Melanie Doe", DaysOfWeek.SATURDAY, Gender.FEMALE));
        personRepository.add(new Person("4", "Alex Doe", DaysOfWeek.SUNDAY, Gender.MALE));
        personRepository.add(new Person("5", "Peter Doe", DaysOfWeek.FRIDAY, Gender.MALE));
        personRepository.add(new Person("6", "Divo Doe", DaysOfWeek.TUESDAY, Gender.OTHER));

        List<Person> result1 = personRepository.searchForPeoplesFavoriteDay(DaysOfWeek.FRIDAY);
        List<Person> result2 = personRepository.searchForPeoplesFavoriteDay(DaysOfWeek.MONDAY);

        assertEquals(2, result1.size());
        assertEquals(1, result2.size());
        assertEquals(person1, result1.getFirst());
        assertEquals(person2, result2.getFirst());
    }

    @Test
    void testSearchForPersonById() {
        personRepository.add(new Person("1", "John Doe", DaysOfWeek.FRIDAY, Gender.MALE));
        personRepository.add(new Person("2", "Jane Doe", DaysOfWeek.MONDAY, Gender.FEMALE));
        personRepository.add(new Person("3", "Melanie Doe", DaysOfWeek.SATURDAY, Gender.FEMALE));
        personRepository.add(new Person("4", "Alex Doe", DaysOfWeek.SUNDAY, Gender.MALE));
        personRepository.add(new Person("5", "Peter Doe", DaysOfWeek.FRIDAY, Gender.MALE));

        Optional<Person> personOptional = personRepository.searchForPersonById("2");
        assertEquals("Jane Doe", personOptional.get().name());
        assertEquals(DaysOfWeek.MONDAY, personOptional.get().favoriteDay());
        assertEquals(Gender.FEMALE, personOptional.get().gender());

        personOptional = personRepository.searchForPersonById("5");
        assertEquals("Peter Doe", personOptional.get().name());
        assertEquals(DaysOfWeek.FRIDAY, personOptional.get().favoriteDay());
        assertEquals(Gender.MALE, personOptional.get().gender());

        personOptional = personRepository.searchForPersonById("3");
        assertEquals("Melanie Doe", personOptional.get().name());
        assertEquals(DaysOfWeek.SATURDAY, personOptional.get().favoriteDay());
        assertEquals(Gender.FEMALE, personOptional.get().gender());
    }

    @Test
    void testSearchForPersonById_shouldReturnTrue_whenPersonIsPresent() {
        personRepository.add(new Person("1", "John Doe", DaysOfWeek.FRIDAY, Gender.MALE));
        personRepository.add(new Person("2", "Jane Doe", DaysOfWeek.MONDAY, Gender.FEMALE));
        personRepository.add(new Person("3", "Melanie Doe", DaysOfWeek.SATURDAY, Gender.FEMALE));
        personRepository.add(new Person("4", "Alex Doe", DaysOfWeek.SUNDAY, Gender.MALE));
        personRepository.add(new Person("5", "Peter Doe", DaysOfWeek.FRIDAY, Gender.MALE));
        assertTrue(personRepository.searchForPersonById("2").isPresent());
        assertTrue(personRepository.searchForPersonById("5").isPresent());
    }

    @Test
    void testSearchForPersonById_shouldReturnFalse_whenPersonIsNotPresent() {
        personRepository.add(new Person("1", "John Doe", DaysOfWeek.FRIDAY, Gender.MALE));
        personRepository.add(new Person("2", "Jane Doe", DaysOfWeek.MONDAY, Gender.FEMALE));
        assertFalse(personRepository.searchForPersonById("7").isPresent());
    }

    @Test
    void testSearchForPersonByName() {
        personRepository.add(new Person("1", "John Doe", DaysOfWeek.FRIDAY, Gender.MALE));
        personRepository.add(new Person("2", "Jane Doe", DaysOfWeek.MONDAY, Gender.FEMALE));
        personRepository.add(new Person("3", "Melanie Doe", DaysOfWeek.SATURDAY, Gender.FEMALE));
        personRepository.add(new Person("4", "Alex Doe", DaysOfWeek.SUNDAY, Gender.MALE));
        personRepository.add(new Person("5", "Peter Doe", DaysOfWeek.FRIDAY, Gender.MALE));

        Optional<Person> personOptional = personRepository.searchForPersonByName("Jane Doe");
        assertEquals("Jane Doe", personOptional.get().name());
        assertEquals(DaysOfWeek.MONDAY, personOptional.get().favoriteDay());
        assertEquals(Gender.FEMALE, personOptional.get().gender());

        personOptional = personRepository.searchForPersonByName("Peter Doe");
        assertEquals("Peter Doe", personOptional.get().name());
        assertEquals(DaysOfWeek.FRIDAY, personOptional.get().favoriteDay());
        assertEquals(Gender.MALE, personOptional.get().gender());

        personOptional = personRepository.searchForPersonByName("Melanie Doe");
        assertEquals("Melanie Doe", personOptional.get().name());
        assertEquals(DaysOfWeek.SATURDAY, personOptional.get().favoriteDay());
        assertEquals(Gender.FEMALE, personOptional.get().gender());
    }

    @Test
    void testSearchForPersonByName_shouldReturnTrue_whenPersonIsPresent() {
        personRepository.add(new Person("1", "John Doe", DaysOfWeek.FRIDAY, Gender.MALE));
        personRepository.add(new Person("2", "Jane Doe", DaysOfWeek.MONDAY, Gender.FEMALE));
        personRepository.add(new Person("3", "Melanie Doe", DaysOfWeek.SATURDAY, Gender.FEMALE));
        personRepository.add(new Person("4", "Alex Doe", DaysOfWeek.SUNDAY, Gender.MALE));
        personRepository.add(new Person("5", "Peter Doe", DaysOfWeek.FRIDAY, Gender.MALE));
        assertTrue(personRepository.searchForPersonByName("Jane Doe").isPresent());
        assertTrue(personRepository.searchForPersonByName("Melanie Doe").isPresent());
        assertTrue(personRepository.searchForPersonByName("alex doe").isPresent());
    }

    @Test
    void testSearchForPersonByName_shouldReturnFalse_whenPersonIsNotPresent() {
        personRepository.add(new Person("1", "John Doe", DaysOfWeek.FRIDAY, Gender.MALE));
        personRepository.add(new Person("2", "Jane Doe", DaysOfWeek.MONDAY, Gender.FEMALE));
       assertFalse(personRepository.searchForPersonByName("Alex Doner").isPresent());
    }
}