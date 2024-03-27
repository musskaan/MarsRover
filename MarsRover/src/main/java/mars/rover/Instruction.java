package mars.rover;

public enum Instruction {
    L(MarsRover::turnLeft),
    R(MarsRover::turnRight),
    M(MarsRover::move);

    private final RoverOperation operation;

    Instruction(RoverOperation operation) {
        this.operation = operation;
    }

    public void execute(MarsRover rover) {
        operation.execute(rover);
    }
}

