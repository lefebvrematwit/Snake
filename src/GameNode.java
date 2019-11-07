/**
 * GameNode abstract class that extends Node. GameNodes are very similar to nodes except they have a required method
 * that is invoked when two nodes "meet" on a Scene
 * @author Matt Lefebvre
 */
public abstract class GameNode {

    /**
     * Method for this GameNode object to interact with another GameNode. "interact" behavior is specified
     * in the subclass implementation of this method.
     * @param node GameNode node that this node will interact with
     */
    abstract void interact(GameNode node);

    /**
     * Method for this GameNode object to "reset" itself. This method will be called on GameNodes when a new game has begun
     */
    abstract void reset();
}
