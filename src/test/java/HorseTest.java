import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {
    @Test
    void constructorShouldThrowIllegalArgumentExceptionWhenNameIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, 10, 10));

        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "\t", "\n", "\r\n"})
    void constructorShouldThrowIllegalArgumentExceptionWhenEmptyOrWhitespace(String name) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(name, 10, 10));

        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    void constructorShouldThrowIllegalArgumentExceptionWhenNegativeSecondParameter() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse("name", -1, 10));

        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    void constructorShouldThrowIllegalArgumentExceptionWhenNegativeThirdParameter() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse("name", 10, -1));

        assertEquals("Distance cannot be negative.", exception.getMessage());
    }
}
