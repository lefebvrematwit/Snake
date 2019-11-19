import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Snake class
 * @author Matt Lefebvre
 */
public class Snake extends GameNode {
    private final List<Coordinate> coordinates;
    private Direction direction;
    private Color color;
    private int points;

    /**
     * Snake Default Constructor (sets color to GREEN)
     */
    public Snake() {
        this(Color.GREEN);
    }

    /**
     * Snake constructor
     * @param color Color color of the snake
     */
    public Snake(Color color) {
        this.coordinates = new ArrayList<>();
        this.direction = Direction.UP;
        this.color = color;
        this.points = 0;
    }

    /**
     * Method to get the snakes color
     * @return
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Method to set the snakes color
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Method to set the snakes color
     * @return
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Set the snakes points
     * @param points int points
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Method to get the snakes direction
     * @return Direction direction
     */
    public Direction getDirection() {
        return this.direction;
    }

    /**
     * Method to set the snakes direction
     * @param direction Direction direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Method to add a coordinate to the back of the snake
     * @param coordinate Coordinate back of the snake
     */
    public void addCoordinate(Coordinate coordinate) {
        coordinates.add(coordinate);
    }

    /**
     * Method to get the head of the snake (i.e. - the front coordinate)
     * @return Coordinate coordinate
     */
    public Coordinate getHead() {
        return coordinates.get(0);
    }

    /**
     * Method to get the tail of the snake (i.e. - the back coordinate)
     * @return Coordinate coordinate
     */
    public Coordinate getTail() {
        return coordinates.get(coordinates.size()-1);
    }

    /**
     * Method to get the snakes next move (the snakes front location + its direction values)
     * @return Coordinate next move
     */
    public Coordinate getNextMove() {
        final Coordinate current = getHead();
        return new Coordinate(current.getX() + this.direction.getX(), current.getY() + this.direction.getY());
    }

    /**
     * Moves the snake to a location
     * @param coordinate Coordinate the location the snake is moving to
     */
    public void moveTo(Coordinate coordinate) {
        this.coordinates.add(0, coordinate);
        this.coordinates.remove(coordinates.size()-1);
    }

    /**
     * Method to get the list of all the snakes coordinates
      * @return
     */
    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    /**
     * Method to get the snake's size
     * @return int size
     */
    public int getSize() {
        return coordinates.size();
    }

    @Override
    public void interact(GameNode node) {
        if (node instanceof PointObject) {
            this.points += ((PointObject) node).getValue();
        }
    }

    @Override
    public void reset() {
        this.setPoints(0);
        this.coordinates.clear();
        this.color = Color.GREEN;
        this.direction = Direction.UP;
    }

}
