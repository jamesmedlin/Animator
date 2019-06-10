package cs3500.animator.model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Represents the model of this EasyAnimator. The model stores {@code AnimatedShape} objects mapped
 * to a unique string name.
 */
public class Model implements IModel {
  private HashMap<String, IAnimatedShape> shapes;

  /**
   * Constructs a default model.
   */
  public Model() {
    this.shapes = new HashMap<String, IAnimatedShape>();
  }

  /**
   * Constructs a model, but a list of Shapes can be given when initialized.
   *
   * @param shapes list of shapes added when instantiating this model
   */
  public Model(HashMap<String, IAnimatedShape> shapes) {
    if (shapes == null) {
      this.shapes = new HashMap<String, IAnimatedShape>();
    } else {
      this.shapes = shapes;
    }
  }

  @Override
  public void removeShape(String name) throws IllegalArgumentException {
    if (shapes.containsKey(name)) {
      shapes.remove(name);
    } else {
      throw new IllegalArgumentException("This is not a valid name or " +
              "is not a current shape's name.");
    }
  }

  @Override
  public void fullMotionTo(String name, int duration, double endX,
                           double endY, int endHeight, int endWidth,
                           int endRed, int endGreen, int endBlue) {
    IAnimatedShape shape = this.shapes.getOrDefault(name, null);
    if (shape == null) {
      throw new IllegalArgumentException("Shape with name " + name + " does not exist");
    } else {
      shape.fullMotionTo(
              new Point2D.Double(endX, endY), endHeight, endWidth,
              new Color(endRed, endGreen, endBlue), duration);
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
    if (this.shapes.containsKey(name) || type == null || name == null || name.equals("")) {
      throw new IllegalArgumentException("Shape names must be unique and non-null.");
    }

    switch (type) {
      case RECTANGLE:
        shapes.put(name, new AnimatedShape(type,
                new RectangleState(
                        tick, width, height,
                        new Color(red, green, blue), new Point2D.Double(x, y))));
        break;
      case ELLIPSE:
        shapes.put(name, new AnimatedShape(type,
                new EllipseState(
                        tick, width, height,
                        new Color(red, green, blue), new Point2D.Double(x, y))));
        break;
      default:
        shapes.put(name, null);
    }

  }


  @Override
  public void changeColorTo(String name, int red, int green, int blue, int duration)
          throws IllegalArgumentException {
    IAnimatedShape shape = this.shapes.getOrDefault(name, null);
    if (shape == null) {
      throw new IllegalArgumentException("Shape with name " + name + " does not exist");
    } else {
      shape.changeColor(new Color(red, green, blue), duration);
    }

  }


  @Override
  public void moveTo(String name, double x, double y, int duration) {
    IAnimatedShape shape = this.shapes.getOrDefault(name, null);
    if (shape == null) {
      throw new IllegalArgumentException("Shape with name " + name + " does not exist");
    } else {
      shape.moveTo(new Point2D.Double(x, y), duration);
    }
  }


  @Override
  public void changeSizeTo(String name, int newHeight, int newWidth, int duration)
          throws IllegalArgumentException {
    IAnimatedShape shape = this.shapes.getOrDefault(name, null);
    if (shape == null) {
      throw new IllegalArgumentException("Shape with name " + name + " does not exist");
    } else {
      shape.changeSizeTo(newHeight, newWidth, duration);
    }
  }


  @Override
  public List<IReadOnlyShapeState> getShapesAtTick(int tick) {
    if (tick < 0) {
      throw new IllegalArgumentException("The tick must be a positive number.");
    } else {
      List<IReadOnlyShapeState> shapesAtTick = new ArrayList<>();
      for (IAnimatedShape shape : shapes.values()) {
        try {
          IReadOnlyShapeState tickShape = shape.getShapeAt(tick);
          shapesAtTick.add(tickShape);
        } catch (IllegalArgumentException e) {
          // ignore if a certain shape doesnt have this tick
        }
      }
      return shapesAtTick;
    }
  }

  @Override
  public String getShape(String name) throws IllegalArgumentException {
    if (shapes.containsKey(name)) {
      return shapes.get(name).getMotions();
    } else {
      throw new IllegalArgumentException("This name does not exist in the current shapes");
    }
  }

  @Override
  public void doNothing(String name, int duration) throws IllegalArgumentException {
    if (!shapes.containsKey(name)) {
      throw new IllegalArgumentException("Invalid name");
    }
    shapes.get(name).addDoNothing(duration);
  }

  @Override
  public IAnimatedShape getShapeObject(String name) {
    if (shapes.containsKey(name)) {
      return shapes.get(name);
    } else {
      throw new IllegalArgumentException("This name does not exist in the current shapes");
    }
  }
}

