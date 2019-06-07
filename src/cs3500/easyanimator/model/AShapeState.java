package cs3500.easyanimator.model;

import java.awt.geom.Point2D;

/**
 * represents the abstracted instantaneous version of a rectangle or ellipse.
 */

public abstract class AShapeState implements IShapeState {
  protected final int tick;
  protected int width;
  protected int height;
  protected Color color;
  protected Point2D position;

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
  public void setWidth(int value) {
    this.width = value;
  }

  @Override
  public void setHeight(int value) {
    this.height = value;
  }

  @Override
  public void setColor(int red, int green, int blue) {
    this.color = new Color(red, green, blue);
  }

  @Override
  public void setPosition(double x, double y) {
    this.position.setLocation(x, y);
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
