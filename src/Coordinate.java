/**
 * Coordinate class which represents a coordinate on a graph or plane. Coordinate objects are immutable and have two
 * fields, an x and y value. The fields are accompanied by getters methods as well as a toString nd equals method.
 * @author Matt Lefebvre
 */
public class Coordinate {
    private final int x;
    private final int y;

    /**
     * Coordinate Constructor, no default constructor available
     * @param x int x coordinate
     * @param y int y coordinate
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the Coordinate's x coordinate
     * @return
     */
    public int getX() {
        return this.x;
    }

    /**
     * Returns the Coordinate's y coordinate
     * @return
     */
    public int getY() {
        return this.y;
    }

    /**
     * Returns the Coordinate as a String in (x, y) format
     * @return
     */
    @Override
    public String toString() {
        return String.format("(%d, %d)", this.x, this.y);
    }

    /**
     * Compares this Coordinate object with another object. If the other Object is also a Coordinaate, the x and y
     * values are compared.
     * @param object Object object
     * @return boolean the two objects are equal (content)
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Coordinate)) {
            return false;
        }

        final Coordinate coordinate = (Coordinate) object;
        return this.x == coordinate.getX() && this.y == coordinate.getY();
    }

    /**
     * Formats the param x and y values as a String the same as a Coordinate object with those and y values would
     * return when invoking the toString method
     * @param x int x
     * @param y int y
     * @return String (x, y)
     */
    public static String format(int x, int y) {
        return String.format("(%d, %d)", x, y);
    }

}
