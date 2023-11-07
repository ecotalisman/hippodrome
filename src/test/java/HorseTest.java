import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class HorseTest {
    @Test
    void testConstructorShouldThrowIllegalArgumentExceptionWhenNameIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, 10, 10));

        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "\t", "\n", "\r\n"})
    void testConstructorShouldThrowIllegalArgumentExceptionWhenEmptyOrWhitespace(String name) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(name, 10, 10));

        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @Test
    void testConstructorShouldThrowIllegalArgumentExceptionWhenNegativeSecondParameter() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse("name", -1, 10));

        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @Test
    void testConstructorShouldThrowIllegalArgumentExceptionWhenNegativeThirdParameter() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse("name", 10, -1));

        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    public void testGetName() {
        String expectedName = "White Horse";
        Horse horse = new Horse(expectedName, 10, 10);

        String resultName = horse.getName();
        assertEquals(expectedName, resultName);
    }

    @Test
    public void testGetSpeed() {
        double expectedSpeed = 10.0;
        Horse horse = new Horse("name", expectedSpeed, 10);

        double resultSpeed = horse.getSpeed();
        assertEquals(expectedSpeed, resultSpeed);
    }

    @Test
    public void testGetDistanceShouldReturnDistancePassedToConstructor() {
        double expectedDistance = 10.0;
        Horse horse = new Horse("name", 10, expectedDistance);

        double resultDistance = horse.getDistance();
        assertEquals(expectedDistance, resultDistance);
    }

    @Test
    public void testGetDistanceShouldReturnZeroWhenConstructedWithTwoParameters() {
        Horse horse = new Horse("name", 10);

        double resultDistance = horse.getDistance();
        assertEquals(0, resultDistance);
    }


    @Test
    public void testMoveShouldCallGetRandomDoubleWithCorrectParameters() {
        try (MockedStatic<Horse> mockStatic = Mockito.mockStatic(Horse.class)){
            Horse horse = new Horse("name", 10, 10);
            horse.move();

            mockStatic.verify(()-> Horse.getRandomDouble(0.2, 0.9));
        }
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.2, 0.9})
    public void testMoveShouldUpdateDistanceBasedOnSpeedAndRandomValue(double randomValue) {

        try (MockedStatic<Horse> mockStatic = Mockito.mockStatic(Horse.class)){
            mockStatic.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(randomValue);
            double initialSpeed = 10.0;
            double initialDistance = 10.0;
            Horse horse = new Horse("White horse", initialSpeed, initialDistance);
            horse.move();

            double expectedDistance = initialDistance + initialSpeed * randomValue;

            assertEquals(expectedDistance, horse.getDistance());
        }
    }
}
