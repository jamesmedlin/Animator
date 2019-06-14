package cs3500.animator.model;

import java.awt.geom.Point2D;
import java.util.List;

/**
 * Represents an animated shape that has different states over time.
 */
public interface IAnimatedShape extends IReadOnlyAnimatedShape{

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
   * changes the state of this shape via position, color, and/or size.
   * @param t1 initial tick
   * @param x1 initial x position
   * @param y1 initial y position
   * @param w1 initial width
   * @param h1 initial height
   * @param r1 initial red color value
   * @param g1 initial green color value
   * @param b1 initial blue color value
   * @param t2 end tick
   * @param x2 end x position
   * @param y2 end y position
   * @param w2 end width
   * @param h2 end height
   * @param r2 end red color value
   * @param g2 end green color value
   * @param b2 end blue color value
   */
  void fullMotion(int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1, int t2, int x2,
      int y2, int w2, int h2, int r2, int g2, int b2);

  /**
   * returns the complete copy of this for the purpose of ensuring no user can mutate anything.
   * @return a complete copy
   */
  IAnimatedShape deepCopy();

}
