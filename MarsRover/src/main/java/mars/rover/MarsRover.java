package mars.rover;

public class MarsRover {

    private final Position position;

    public MarsRover(final Position position) {
        this.position = position;
    }

    public void processInstructions(final String instructions) {
        for (char instruction : instructions.toCharArray()) {
            execute(Instruction.valueOf(String.valueOf(instruction)));
        }
    }

    public void execute(final Instruction instruction) {
        instruction.execute(this);
    }

    public void turnLeft() {
        position.setDirection(position.getDirection().turnLeft());
    }

    public void turnRight() {
        position.setDirection(position.getDirection().turnRight());
    }

    public void move() {
        int newX = position.getX_coordinate() + (position.getDirection() == Direction.E ? 1 : (position.getDirection() == Direction.W ? -1 : 0));
        int newY = position.getY_coordinate() + (position.getDirection() == Direction.N ? 1 : (position.getDirection() == Direction.S ? -1 : 0));

        if (position.getPlateau().isValidPosition(newX, newY)) {
            position.setX_coordinate(newX);
            position.setY_coordinate(newY);
        } else {
            throw new RuntimeException("Rover went out of the plateau");
        }
    }

    public String getCurrentPosition() {
        return position.getCurrentPosition();
    }
}
