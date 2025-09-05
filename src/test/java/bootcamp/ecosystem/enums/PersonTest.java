package bootcamp.ecosystem.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    public void testPerson() {
        Person person1 = new Person("1", "John Doe", DaysOfWeek.FRIDAY, Gender.MALE);
        Person person2 = new Person("2", "Jane Doe", DaysOfWeek.MONDAY, Gender.FEMALE);

        assertEquals("John Doe", person1.name());
        assertEquals(Gender.MALE, person1.gender());
        assertEquals(DaysOfWeek.FRIDAY, person1.favoriteDay());

        assertEquals("Jane Doe", person2.name());
        assertEquals(Gender.FEMALE, person2.gender());
        assertEquals(DaysOfWeek.MONDAY, person2.favoriteDay());
    }
}