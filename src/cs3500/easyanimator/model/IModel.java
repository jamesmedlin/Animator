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
  void addShape(
      String name, ShapeType type, int startX, int startY, int startWidth, int startHeight,
      int startRed, int startGreen, int startBlue) throws IllegalArgumentException;

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
  void addMotion(
      String name, int startTime, int endTime, double startX, double endX, double startY, double endY,
      int startHeight, int endHeight, int startWidth, int endWidth, int startRed, int endRed,
      int startGreen, int endGreen, int startBlue, int endBlue);
  
  /**
   * retrieves the previous states of this shape
   * @return the history of this shape
   */
  String printHistory();

}
