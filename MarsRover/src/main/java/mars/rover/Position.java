package mars.rover;

public class Position {
    private int x_coordinate;
    private int y_coordinate;
    private Direction direction;
    private final Plateau plateau;

    public Position(final int x_coordinate, final int y_coordinate, final Direction direction, final Plateau plateau) {
        if(!plateau.isValidPosition(x_coordinate, y_coordinate)) {
            throw new RuntimeException("Position of rover is out of the plateau");
        }
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        this.direction = direction;
        this.plateau = plateau;
    }

    public int getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(final int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public int getY_coordinate() {
        return y_coordinate;
    }

    public void setY_coordinate(final int y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public String getCurrentPosition() {
        return x_coordinate + " " + y_coordinate + " " + direction;
    }
}
