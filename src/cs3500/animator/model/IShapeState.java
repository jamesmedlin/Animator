package cs3500.animator.model;

import java.util.Comparator;

/**
 * Represents an instantaneous state of a shape.
 */
public interface IShapeState extends IReadOnlyShapeState, Comparable<IShapeState> {

  /**
   * Overrides the java-provided toString method. This method returns all the methods fields/
   * attributes as strings.
   * @return tick, x position, y position, width, height, red, green, blue as string values.
   */
  String toString();

  /**
   * returns a new copy of the object instead of a pointer to its memory location in order to avoid
   * mid-animation outside changes by other users.
   * @return a complete copy of a shape's state
   */
  IShapeState deepCopy();
}
