package mars.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    private final Plateau plateau = new Plateau(5, 5);

    @Test
    void testConstructorWithInvalidPosition_throwsRuntimeException() {
        assertThrows(RuntimeException.class, () -> new Position(6, 3, Direction.S, plateau));
    }

    @Test
    void testConstructorWithValidPosition() {
        Position position = new Position(2, 3, Direction.S, plateau);

        assertEquals(2, position.getX_coordinate());
        assertEquals(3, position.getY_coordinate());
        assertEquals(Direction.S, position.getDirection());
        assertEquals(plateau, position.getPlateau());
    }
}