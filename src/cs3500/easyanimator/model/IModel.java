package cs3500.easyanimator.model;

import java.util.List;

/**
 * represents a model for this animation
 */
public interface IModel {

  /**
   * instantiates a shape to the animation when called.
   * @param tick the tick at which this shape initializes
   * @param name a unique identifier
   * @param type the type of shape being instantiated
   * @param x the x position of where the shape starts
   * @param y the y position of where the shape starts
   * @param width the width of the shape
   * @param height the height of the shape
   * @param red the value of red color
   * @param green the value of green color
   * @param blue the value of blue color
   * @throws IllegalArgumentException when given invalid initial values
   */
  void addShapeAt(
      int tick, String name, ShapeType type, double x, double y, int width,
      int height, int red, int green, int blue) throws IllegalArgumentException;

  /**
   * removes a specific shape when called.
   * @param name the unique identifier
   * @throws IllegalArgumentException when given an invalid name
   */
  void removeShape(String name) throws IllegalArgumentException;


  /**
   * changes the color of this shape over a certain amount of time.
   * @param name the unique identifier
   * @param red the value of red color
   * @param green the value of green color
   * @param blue the value of blue color
   * @param duration the time it takes to perform this motion
   * @throws IllegalArgumentException when given invalid color values or names
   */
  void changeColorTo(String name, int red, int green, int blue, int duration) throws IllegalArgumentException;

  /**
   * moves the shapes from its current position to the given position.
   * @param name the unique shape identifier
   * @param x the x coordinate it will move to
   * @param y the y value it will move to
   * @param duration the time it takes to perform this motion
   */
  void moveTo(String name, double x, double y, int duration);

  /**
   * changes the size of this shape over a specific duration.
   * @param name the unique shape identifier
   * @param newHeight the new height of the shape
   * @param newWidth the new width of the shape
   * @param duration the time it takes to perform this motion
   * @throws IllegalArgumentException when given invalid lengths or names
   */
  void changeSizeTo(String name, int newHeight, int newWidth, int duration) throws IllegalArgumentException;


  /**
   * retrieves the previous states of this shape.
   * @return the history of this shape
   */
  String printHistory();

  /**
   * retrieves all shapes at a certain tick.
   * @param tick the tick at which shapes are retrieves
   * @return the list of readable shapes at the given tick
   */
  List<IReadOnlyShapeState> getShapesAtTick(int tick);

  /**
   * creates a new motion which allows instantaneous changes in states.
   * @param name the unique shape identifier
   * @param duration the times over which this motion is performed
   * @param endX the x value of the position it moves to
   * @param endY the y value of the position it moves to
   * @param endHeight the final height of the shape
   * @param endWidth the final width of the shape
   * @param endRed the final end value of red color
   * @param endGreen the final end value of green color
   * @param endBlue the final end value of blue color
   */
  void fullMotionTo(String name, int duration, double endX, double endY, int endHeight,
      int endWidth, int endRed, int endGreen, int endBlue);
  
}
