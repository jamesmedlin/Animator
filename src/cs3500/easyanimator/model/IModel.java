package cs3500.easyanimator.model;

/**
 * represents a model for this animation
 */
public interface IModel {

  /**
   * instantiates a shape to the animation when called
   * @param name unique identifier
   * @param type the type of shape initialized
   * @param StartLoc the location at which the shape is created
   * @throws IllegalArgumentException when given an invalid name
   */
   void addShape(String name, Enum type, Posn StartLoc) throws IllegalArgumentException;

  /**
   * removes a specific shape when called
   * @param name the unique shape being removed
   * @throws IllegalArgumentException when given an invalid name
   */
   void removeShape(String name) throws IllegalArgumentException;

  /**
   * changes the color of a shape over a given amount of time
   * @param name the unique shape that is getting its color changed
   * @param color the color the shape is changing to
   * @param duration the time length for which the color should be changing
   * @throws IllegalArgumentException when given an invalid name
   */
   void changeShapeColor(String name, Color color, int duration) throws IllegalArgumentException;

  /**
   * moves a specific shape from its current location to the given location
   * @param name the unique shape being moved
   * @param moveTo the new location
   * @param duration the time over which it moves
   * @throws IllegalArgumentException when given an invalid name
   */
   void moveShape(String name, Posn moveTo, int duration) throws IllegalArgumentException;

  /**
   * changes the size of a given shape over a certain amount of time
   * @param name the unique shape being changed
   * @param duration the time over which the shape changes size
   * @param newHeight the new height
   * @param newWidth the new width
   * @throws IllegalArgumentException when given an invalid name
   */
   void changeShapeSize(String name, int duration, int newHeight, int newWidth) throws IllegalArgumentException;

  /**
   * retrieves the previous states of this shape
   * @return the history of this shape
   */
   String printHistory();

}
