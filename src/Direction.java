import javafx.scene.input.KeyCode;

/**
 * Coordinates for moving a sprite/node/shape in a javafx GridPane.
 * @author Matt Lefebvre
 */
public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int x;
    private final int y;
    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The x value of the direction
     * @return int x
     */
    public int getX() {
        return this.x;
    }

    /**
     * The y value of the direction
     * @return int y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Returns the Direction enum in (x, y) format
     * @return
     */
    @Override
    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
    }

    /**
     * Returns a Direction from the following javafx.scene.input.KeyCode: UP, DOWN, LEFT, RIGHT. Returns null otherwise.
     * @param code KeyCode code
     * @return Direction direction or null
     */
    public static Direction fromKeyCode(KeyCode code) {
        switch (code) {
            case UP:
                return Direction.UP;
            case DOWN:
                return Direction.DOWN;
            case LEFT:
                return Direction.LEFT;
            case RIGHT:
                return Direction.RIGHT;
            default:
                return null;
        }
    }

    public static Direction getOpposite(Direction direction) {
        switch (direction) {
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            default:
                return null;
        }
    }

}
