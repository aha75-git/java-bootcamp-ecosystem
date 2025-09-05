package bootcamp.ecosystem.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GenderTest {
    @Test
    public void testGender() {
        assertEquals(3, Gender.values().length);
    }

    @Test
    void testEnumNames() {
        String[] expectedNames = {"MALE", "FEMALE", "OTHER"};
        assertArrayEquals(expectedNames, Gender.names());
    }
}