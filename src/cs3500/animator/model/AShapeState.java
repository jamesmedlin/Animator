package cs3500.animator.model;

import java.awt.geom.Point2D;


/**
 * Represents the abstracted instantaneous version of any supported shape.
 */

public abstract class AShapeState implements IShapeState {
  // INVARIANT: tick is a positive number > 0
  protected final int tick;
  // INVARIANT: width is a positive number > 0
  protected int width;
  // INVARIANT: height is a positive number > 0
  protected int height;
  protected Color color;
  protected Point2D position;

  /**
   * Serves as a common constructor for all subclasses of an abstract shape state.
   * @param tick the tick at which this state exists
   * @param width the width of the shape in this state
   * @param height the the height of the shape in this state
   * @param color the color of the shape in this state
   * @param position the position of the shape in this state
   */
  public AShapeState(
      int tick, int width, int height, Color color, Point2D position) {
    if (tick < 0 || width < 0 || height < 0 || position == null) {
      throw new IllegalArgumentException("Tick, width, and height must be non-negative");
    }
    this.tick = tick;
    this.width = width;
    this.height = height;
    this.color = color;
    this.position = position;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public Color getColor() {
    return new Color(this.color.getRed(), this.color.getGreen(), this.color.getBlue());
  }

  @Override
  public Point2D getPosition() {
    return new Point2D.Double(this.position.getX(), this.position.getY());
  }

  @Override
  public int getTick() {
    return this.tick;
  }

  @Override
  public String toString() {
    return "" + this.tick + " "
        + this.position.getX() + " "
        + this.position.getY() + " "
        + this.width + " "
        + this.height + " "
        + this.color.getRed() + " "
        + this.color.getGreen() + " "
        + this.color.getBlue();
  }
  
  @Override
  public abstract IShapeState deepCopy();

}