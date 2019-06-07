package cs3500.easyanimator.model;

import java.awt.geom.Point2D;
import java.util.List;

/**
 * Represents an  animated shape that has different states over time.
 */
public interface IAnimatedShape {
  /**
   * Retrieves all the states associated with this shape.
   * @return the motions associated with this animated shape
   */
  String getMotions();
  
  /**
   * Based on the added motions of this animated shape, this method will return the read only
   * version of the shape state that represents the animated shape at the given tick.
   * 
   * @param tick the tick at which the Animated shape should be represented
   * @return the shape at the given tick
   * @throws IllegalArgumentException when given a tick that does not exist for this shape
   */
  IReadOnlyShapeState getShapeAt(int tick) throws IllegalArgumentException;

  /**
   * Adds a motion to this animated shape, taking as the starting position the state at the
   * greatest tick.
   * 
   * @param endPos The position the shape is moving to
   * @param endHeight the height of the shape at the end of the motion
   * @param endWidth the width of the shape at the end of the motion
   * @param endColor the color of the shape at the end of the motion
   * @param duration the time the motion will take
   * @throws IllegalArgumentException if any of the arguments are null or non-positive
   */
  void fullMotionTo(Point2D endPos, int endHeight, int endWidth, Color endColor, int duration)
       throws IllegalArgumentException;

  /**
   * Changes the color of this animated shape to the given color over the given duration, but
   * nothing else about that shape will change during that time.
   * 
   * @param color the color to which the shape will change
   * @param duration the time the shape will take to fade colors
   * @throws IllegalArgumentException if the duration is non-positive or the color is null
   */
  void changeColor(Color color, int duration) throws IllegalArgumentException;

  /**
   * Moves this animated shape over a given duration, but does not modify anything else about the
   * shape during that time.
   * 
   * @param endPos the position of the shape after the move
   * @param duration the amount of time the shape will take to slide there
   * @throws IllegalArgumentException if the duration is non-positive or the position is null
   */
  void moveTo(Point2D endPos, int duration) throws IllegalArgumentException;

  /**
   * Changes the size of this animated shape over the given duration, but does not change anything
   * else about the shape during that time.
   * 
   * @param newHeight the height of the shape after the transformation
   * @param newWidth the width of the shape after the transformation
   * @param duration the amount of time the transformation will take  
   * @throws IllegalArgumentException if any of the arguments are non-positive
   */
  void changeSizeTo(int newHeight, int newWidth, int duration) throws IllegalArgumentException;
  
  /**
   * Directs this animated shape to do nothing for the given duration.
   * 
   * @param duration the length of time this Animated Shape should rest.
   */
  void addDoNothing(int duration);
  
  /**
   * Getter for the list of states of this Animated Shape. Used primarily for testing purposes.
   * @return List of shape states.
   */
  List<IReadOnlyShapeState> getStates();

}
