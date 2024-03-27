package mars.rover;

public enum Direction {
    N(0), E(1), S(2), W(3);

    private final int value;

    Direction(int value) {
        this.value = value;
    }

    public Direction turnLeft() {
        return rotate(-1);
    }

    public Direction turnRight() {
        return rotate(1);
    }

    private Direction rotate(int rotationAmount) {
        int newValue = (value + rotationAmount + 4) % 4;
        return Direction.values()[newValue];
    }
}


