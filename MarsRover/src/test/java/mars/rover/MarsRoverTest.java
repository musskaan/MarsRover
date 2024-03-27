package mars.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class MarsRoverTest {
    private MarsRover marsRover;
    private Plateau plateau;
    private Position position;

    @BeforeEach
    void setUp() {
        plateau = mock(Plateau.class);
        when(plateau.isValidPosition(anyInt(), anyInt())).thenReturn(true);
        position = new Position(1,2,Direction.N, plateau);
        marsRover = spy(new MarsRover(position));
    }


    @Test
    public void testProcessInstructions_InvalidInstruction_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> marsRover.processInstructions("LX"));
    }

    @Test
    void testProcessInstructions_ShouldTurnLeftAndMove() {
        marsRover.processInstructions("LMLMLMLMM");

        verify(marsRover, times(9)).execute(any(Instruction.class));
        verify(marsRover, never()).turnRight();
        verify(marsRover, times(4)).turnLeft();
        verify(marsRover, times(5)).move();
        assertEquals("1 3 N", marsRover.getCurrentPosition());
    }


    @Test
    public void testProcessInstructions_ShouldTurnRightAndMove() {
        Position position1 = new Position(3, 3, Direction.E, plateau);
        MarsRover marsRover = spy(new MarsRover(position1));

        marsRover.processInstructions("MMRMMRMRRM");

        verify(marsRover, times(10)).execute(any(Instruction.class));
        verify(marsRover, times(4)).turnRight();
        verify(marsRover, never()).turnLeft();
        verify(marsRover, times(6)).move();
        assertEquals("5 1 E", marsRover.getCurrentPosition());
    }

    @Test
    void testExecute_InstructionL_ShouldTurnLeft() {
        Instruction instructionL = Instruction.L;

        marsRover.execute(instructionL);

        verify(marsRover, times(1)).turnLeft();
        verify(marsRover, never()).turnRight();
        verify(marsRover, never()).move();
        assertEquals("1 2 W", marsRover.getCurrentPosition());
    }

    @Test
    void testExecute_InstructionR_ShouldTurnRight() {
        Instruction instructionR = Instruction.R;

        marsRover.execute(instructionR);

        verify(marsRover, never()).turnLeft();
        verify(marsRover, times(1)).turnRight();
        verify(marsRover, never()).move();
        assertEquals("1 2 E", marsRover.getCurrentPosition());
    }

    @Test
    void testExecute_InstructionM_ShouldMove() {
        Instruction instructionM = Instruction.M;

        marsRover.execute(instructionM);

        verify(marsRover, never()).turnLeft();
        verify(marsRover, never()).turnRight();
        verify(marsRover, times(1)).move();
        assertEquals("1 3 N", marsRover.getCurrentPosition());
    }

    @Test
    void testTurnLeft_ShouldChangeDirection() {
        marsRover.turnLeft();

        assertEquals("1 2 W", marsRover.getCurrentPosition());
    }

    @Test
    void testTurnRight_ShouldChangeDirection() {
        marsRover.turnRight();

        assertEquals("1 2 E", marsRover.getCurrentPosition());
    }

    @Test
    void testMove_ShouldMoveRover() {
        marsRover.move();

        assertEquals("1 3 N", marsRover.getCurrentPosition());
    }


    @Test
    public void testProcessInstructions_OutOfPlateauBounds_throwsRuntimeException() {
        when(plateau.isValidPosition(1, 3)).thenReturn(false);
        Instruction instructionM = Instruction.M;

       assertThrows(RuntimeException.class, () -> marsRover.execute(instructionM));
    }
}