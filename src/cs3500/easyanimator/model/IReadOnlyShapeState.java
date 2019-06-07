package cs3500.easyanimator.model;

import java.awt.geom.Point2D;

/**
 * Represents a read only version of a shape state.
 */
public interface IReadOnlyShapeState {
  /**
   * retrieves the width of this readable shape.
   * @return the width value
   */
  int getWidth();

  /**
   * retrieves the height of this readable shape.
   * @return the height value
   */
  int getHeight();

  /**
   * retrieves the color of this readable shape.
   * @return the color object of this readable shape
   */
  Color getColor();

  /**
   * retrieves the position of this readable shape.
   * @return the position as a point
   */
  Point2D getPosition();

  /**
   * retrieves the tick of this readable shape.
   * @return tick, x position, y position, width, height, red, green, blue as string values.
   */
  int getTick();
}
