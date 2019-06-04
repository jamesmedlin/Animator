package cs3500.easyanimator.model;

import java.awt.geom.Point2D;

public abstract class AShape implements IShape {
  private final String name;
  private int width;
  private int height;
  private Color color;
  private Point2D position;
  
  public AShape(
      String name, int width, int height, int red, int green, int blue, double x, double y) {
    this.name = name;
    this.width = width;
    this.height = height;
    this.color = new Color(red, green, blue);
    this.position = new Point2D.Double(x, y);
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
  
}
