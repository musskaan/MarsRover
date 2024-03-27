package mars.rover;

public class Plateau {

    private final int maxXCoordinate;
    private final int maxYCoordinate;

    public Plateau(final int maxXCoordinate, final int maxYCoordinate) {
        this.maxXCoordinate = maxXCoordinate;
        this.maxYCoordinate = maxYCoordinate;
    }

    public boolean isValidPosition(final int x, final int y) {
        return x >= 0 && x <= maxXCoordinate && y >= 0 && y <= maxYCoordinate;
    }
}
