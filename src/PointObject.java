/**
 * PointObject class. Similar to GameNode, but PointObjects have a "point" value associated with them. e.g. - this
 * class will be used to create the apple which the snake eats and gains points/grows in size.
 * @author Matt Lefebvre
 */
public abstract class PointObject extends GameNode {
    private final int value;

    /**
     * PointObject constructor (no default constructor available)
     * @param value int the value of this PointObject
     */
    public PointObject(int value) {
        this.value = value;
    }

    /**
     * Method to get this PointObjects value
     * @return int value
     */
    public int getValue() {
        return this.value;
    }

}
