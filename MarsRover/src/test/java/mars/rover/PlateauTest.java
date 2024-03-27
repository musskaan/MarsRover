package mars.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    private Plateau plateau;

    @BeforeEach
    void setUp() {
        plateau = new Plateau(5, 5);
    }

    @Test
    void isValidPosition_OutsideXBoundary_ShouldReturnFalse() {
        assertFalse(plateau.isValidPosition(6, 3));
    }

    @Test
    void isValidPosition_OutsideYBoundary_ShouldReturnFalse() {
        assertFalse(plateau.isValidPosition(2, 6));
    }

    @Test
    void isValidPosition_NegativeCoordinates_ShouldReturnFalse() {
        assertFalse(plateau.isValidPosition(-1, 3));
    }

    @Test
    void isValidPosition_NegativeYCoordinate_ShouldReturnFalse() {
        assertFalse(plateau.isValidPosition(4, -2));
    }

    @Test
    void isValidPosition_ValidPosition_ShouldReturnTrue() {
        assertTrue(plateau.isValidPosition(3, 4));
    }

    @Test
    void isValidPosition_OnUpperBoundary_ShouldReturnTrue() {
        assertTrue(plateau.isValidPosition(5, 5));
    }

    @Test
    void isValidPosition_OnLowerBoundary_ShouldReturnTrue() {
        assertTrue(plateau.isValidPosition(0, 0));
    }
}