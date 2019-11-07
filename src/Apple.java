import javafx.scene.paint.Color;

/**
 * Apple class. This is the object the snake consumes and gains points/grows in size
 * @author Matt Lefebvre
 */
public class Apple extends PointObject {
    private final Color color;
    private Coordinate coordinate;

    /**
     * Apple constructor - point value is set to 1
     */
    public Apple() {
        super(1);
        this.color = Color.RED;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Color getColor() {
        return this.color;
    }

    @Override
    public void interact(GameNode node) {}

    @Override
    public void reset() {}

}
