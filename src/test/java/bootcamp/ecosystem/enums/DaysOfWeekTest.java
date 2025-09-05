package bootcamp.ecosystem.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DaysOfWeekTest {
    @Test
    void testGetValue() {
        assertEquals("Montag", DaysOfWeek.MONDAY.getValue());
        assertEquals("Dienstag", DaysOfWeek.TUESDAY.getValue());
        assertEquals("Mittwoch", DaysOfWeek.WEDNESDAY.getValue());
        assertEquals("Donnerstag", DaysOfWeek.THURSDAY.getValue());
        assertEquals("Freitag", DaysOfWeek.FRIDAY.getValue());
        assertEquals("Wochenende", DaysOfWeek.SATURDAY.getValue());
        assertEquals("Wochenende", DaysOfWeek.SUNDAY.getValue());
    }

    @Test
    void testEnumCount() {
        assertEquals(7, DaysOfWeek.values().length);
    }

    @Test
    void testEnumNames() {
        String[] expectedNames = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        assertArrayEquals(expectedNames, DaysOfWeek.names());
    }
}