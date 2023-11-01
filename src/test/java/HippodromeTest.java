import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class HippodromeTest {
    @Test
    public void testConstructorShouldThrowIllegalArgumentExceptionWhenHorsesAreNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(null));

        assertEquals("Horses cannot be null.", exception.getMessage());
    }

    @Test
    public void testConstructorShouldThrowIllegalArgumentExceptionWhenHorseListIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(Collections.emptyList()));

        assertEquals("Horses cannot be empty.", exception.getMessage());
    }

    @Test
    public void testGetHorsesReturnsSameListPassedToConstructor() {
        List<Horse> expectedHorses = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            Horse horse = new Horse("Horse" + i, i, i);
            expectedHorses.add(horse);
        }

        Hippodrome hippodrome = new Hippodrome(expectedHorses);
        List<Horse> resultHorses = hippodrome.getHorses();

        assertEquals(expectedHorses, resultHorses);
    }

    @Test
    public void testMoveShouldInvokeMoveOnAllHorses() {
        List<Horse> horseListMocks = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            Horse horseMock = Mockito.mock(Horse.class);
            horseListMocks.add(horseMock);
        }

        Hippodrome hippodrome = new Hippodrome(horseListMocks);
        hippodrome.move();

        for (Horse horseListMock : horseListMocks) {
            Mockito.verify(horseListMock).move();
        }
    }

    @Test
    public void testGetWinnerShouldReturnHorseWithMaxDistance() {
        Horse horse1 = new Horse("Horse1", 4, 12);
        Horse horse2 = new Horse("Horse2", 5, 10);

        List<Horse> horseList = Arrays.asList(horse1, horse2);
        Hippodrome hippodrome = new Hippodrome(horseList);

        assertEquals(horse1, hippodrome.getWinner());
    }
}
