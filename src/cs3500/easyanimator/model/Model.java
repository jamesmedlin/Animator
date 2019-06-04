package cs3500.easyanimator.model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

public class Model implements IModel {
  private HashMap<String, IMovableShape> shapes = new HashMap<String, IMovableShape>();
  
  
  /**
   * constructs a default model
   */
  public Model() {

  }


  @Override
  public void addShape(
      String name, ShapeType type, int startX, int startY, int startWidth, int startHeight,
      int startRed, int startGreen, int startBlue) throws IllegalArgumentException {
    if (this.shapes.containsKey(name) || type == null || name == null) {
      throw new IllegalArgumentException("Shape names must be unique and non-null.");
    }
    
    switch (type) {
      case RECTANGLE:
        shapes.put(name, new MovableShape(
            new MyRectangle(
                name, startWidth, startHeight, startRed, startGreen, startBlue, startX, startY),
            new ArrayList<IMotion>()));
        break;
      case ELLIPSE:
        shapes.put(name, new MovableShape(
            new MyEllipse(
                name, startWidth, startHeight, startRed, startGreen, startBlue, startX, startY),
            new ArrayList<IMotion>()));
      default:
        shapes.put(name, null);
    }
  }

  @Override
  public void removeShape(String name) throws IllegalArgumentException {
    shapes.remove(name);
  }

  public void addMotion(
      String name, int startTime, int endTime, int startX, int endX, int startY, int endY,
      int startHeight, int endHeight, int startWidth, int endWidth, int startRed, int endRed,
      int startGreen, int endGreen, int startBlue, int endBlue) {
    
  }

  @Override
  public String printHistory() {
    for (IMovableShape shape : shapes.values()) {
      shape.getMotions();
    }
    return "The history here";
  }

}
