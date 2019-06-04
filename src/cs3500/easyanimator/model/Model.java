package cs3500.easyanimator.model;

import java.util.HashMap;

public class Model implements IModel {
  HashMap<String, IShape> shapes;
  ShapeType type;
  int time;

  /**
   * constructs a default model
   */
  public Model() {

  }


  @Override
  public void addShape(String name, Enum type, Posn StartLoc) throws IllegalArgumentException {
    shapes.put(name, );
  }

  @Override
  public void removeShape(String name) throws IllegalArgumentException {
    shapes.remove(name);
  }

  //@Override
  public void changeShapeColor(String name, Color color, int duration) throws IllegalArgumentException {
    shapes.get(name).changeColor(color, duration);
  }

  @Override
  public void moveShape(String name, Posn moveTo, int duration) throws IllegalArgumentException {
    shapes.get(name).move(moveTo, duration);
  }

  @Override
  public void changeShapeSize(String name, int duration, int newHeight, int newWidth) throws IllegalArgumentException {
    shapes.get(name).changeSize(duration, newHeight, newWidth);
  }

  @Override
  public String printHistory() {
    for (IShape shape : shapes.values()) {
      shape.getHistory();
    }
    return "The history here";
  }

}
