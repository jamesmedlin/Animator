package cs3500.easyanimator.model;

import java.awt.geom.Point2D;

/**
 * represents a model for this animation
 */
public interface IModel {

  /**
   * instantiates a shape to the animation when called
   * @param name unique identifier
   * @param type the type of shape initialized
   * @param startLoc the location at which the shape is created
   * @throws IllegalArgumentException when given an invalid name
   */
  void addShapeAt(
      int tick, String name, ShapeType type, double x, double y, int width,
      int height, int red, int green, int blue) throws IllegalArgumentException;

  /**
   * removes a specific shape when called
   * @param name the unique shape being removed
   * @throws IllegalArgumentException when given an invalid name
   */
  void removeShape(String name) throws IllegalArgumentException;

  /**
   * 
   * @param name
   * @param startTime
   * @param endTime
   * @param i
   * @param j
   * @param startHeight
   * @param endHeight
   * @param startWidth
   * @param endWidth
   * @param startRed
   * @param endRed
   * @param startGreen
   * @param endGreen
   * @param startBlue
   * @param endBlue
   */
  void addFullMotion(
      String name, int startTime, int endTime, double startX, double endX, double startY, double endY,
      int startHeight, int endHeight, int startWidth, int endWidth, int startRed, int endRed,
      int startGreen, int endGreen, int startBlue, int endBlue);
  
/**
* changes the color of this shape over a certain amount of time
* @param color the color it changes to
* @param duration the time it takes to change
*/
void changeColorTo(String name, int red, int green, int blue, int duration) throws IllegalArgumentException;

/**
* moves the shapes from its current position to the given position
* @param moveTo the position the shapes is moving to
* @param duration the time it takes for the shape to move
*/
void moveTo(String name, double x, double y, int duration);

/**
* changes the size of this shape over a specific duration
* @param duration the times it takes to change the shape's size
* @param newHeight the height it changes to
* @param newWidth the width it changes to
* @throws IllegalArgumentException
*/
void changeSizeTo(String name, int newHeight, int newWidth, int duration) throws IllegalArgumentException;

  
  /**
   * retrieves the previous states of this shape
   * @return the history of this shape
   */
  String printHistory();

}
