package bootcamp.ecosystem.enums;

import java.util.Arrays;

public enum Gender {
    MALE, FEMALE, OTHER;

    public static String[] names() {
        return Arrays.stream(Gender.values())
                .map(Enum::name)
                .toArray(String[]::new);
    }
}
