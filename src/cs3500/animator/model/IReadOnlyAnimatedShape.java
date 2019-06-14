package cs3500.animator.model;

import java.util.List;

public interface IReadOnlyAnimatedShape {

  /**
   * Getter for the list of states of this Animated Shape. Used primarily for testing purposes.
   *
   * @return List of shape states.
   */
  List<IReadOnlyShapeState> getStates();

  /**
   * Retrieves all the states associated with this shape.
   *
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

  ShapeType getType();

  String getName();
}
