package cs3500.easyanimator.model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model implements IModel {
  private HashMap<String, IAnimatedShape> shapes = new HashMap<String, IAnimatedShape>();
  
  
  /**
   * constructs a default model
   */
  public Model() {

  }




  @Override
  public void removeShape(String name) throws IllegalArgumentException {
    shapes.remove(name);
  }

  @Override
  public void addFullMotion(String name, int startTime, int endTime, double startX, double endX,
      double startY, double endY, int startHeight, int endHeight, int startWidth, int endWidth,
      int startRed, int endRed, int startGreen, int endGreen, int startBlue, int endBlue) {
    IAnimatedShape shape = this.shapes.getOrDefault(name, null);
    if (shape == null) {
      throw new IllegalArgumentException("Shape with name " + name + " does not exist");
    }
    else {
      shape.addFullMotion(startTime, endTime, new Point2D.Double(startX, startY), 
          new Point2D.Double(endX, endY), startHeight, endHeight, startWidth, endWidth,
          new Color(startRed, startGreen, startBlue), new Color(endRed, endGreen, endBlue));
    }
  }

  @Override
  public String printHistory() {
    String result = "";
    for (IAnimatedShape shape : shapes.values()) {
      result += shape.getMotions();
    }
    return result;
  }




  @Override
  public void addShapeAt(int tick, String name, ShapeType type, double x, double y, int width,
      int height, int red, int green, int blue) throws IllegalArgumentException {
    if (this.shapes.containsKey(name) || type == null || name == null) {
      throw new IllegalArgumentException("Shape names must be unique and non-null.");
    }
    
    switch (type) {
      case RECTANGLE:
        shapes.put(name, new AnimatedShape(type,
            new RectangleState(
                tick, width, height, new Color(red, green, blue), new Point2D.Double(x, y))));
        break;
      case ELLIPSE:
        shapes.put(name, new AnimatedShape(type, 
            new EllipseState(
                tick, width, height, new Color(red, green, blue), new Point2D.Double(x, y))));
        break;
      default:
        shapes.put(name, null);
    }
    
  }

  @Override
  public void changeColorTo(String name, int red, int green, int blue, int duration)
      throws IllegalArgumentException{
    IAnimatedShape shape = this.shapes.getOrDefault(name, null);
    if (shape == null) {
      throw new IllegalArgumentException("Shape with name " + name + " does not exist");
    }
    else {
      shape.changeColor(new Color(red, green, blue), duration);
    }
    
  }




  @Override
  public void moveTo(String name, double x, double y, int duration) {
    // TODO Auto-generated method stub
    IAnimatedShape shape = this.shapes.getOrDefault(name, null);
    if (shape == null) {
      throw new IllegalArgumentException("Shape with name " + name + " does not exist");
    }
    else {
      shape.moveTo(new Point2D.Double(x, y), duration);
    }
  }




  @Override
  public void changeSizeTo(String name, int newHeight, int newWidth, int duration)
      throws IllegalArgumentException {
    IAnimatedShape shape = this.shapes.getOrDefault(name, null);
    if (shape == null) {
      throw new IllegalArgumentException("Shape with name " + name + " does not exist");
    }
    else {
      shape.changeSizeTo(newHeight, newWidth, duration);
    }
    
  }

  @Override
  public List<IReadOnlyShapeState> getShapesAtTick(int tick) {
    // TODO Auto-generated method stub
    return null;
  }

}
