package cs3500.easyanimator.model;

import java.util.HashMap;

public class Model implements IModel {
  HashMap<String, IShape> shapes;
  int time;

  /**
   * constructs a default model
   */
  public Model() {

  }


  @Override
  public void addShape(String name, Enum type, Posn StartLoc) throws IllegalArgumentException {

  }

  @Override
  public void removeShape(String name) throws IllegalArgumentException {

  }

  @Override
  public void changeShapeColor(String name, Color color, int duration) throws IllegalArgumentException {

  }

  @Override
  public void moveShape(String name, Posn moveTo, int duration) throws IllegalArgumentException {

  }

  @Override
  public void changeShapeSize(String name, int duration, int newHeight, int newWidth) throws IllegalArgumentException {

  }

  @Override
  public String printHistory() {
    return null;
  }

}
