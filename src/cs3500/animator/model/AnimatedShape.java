package cs3500.animator.model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an animated shape over time. It is made up of an initial shape state and a list of
 * subsequent shape states added by the MotionAdder over time
 */
public class AnimatedShape implements IAnimatedShape {
  // any type of subsequent shapes
  private final ShapeType type;
  // records the initial state of the animated shape
  private final IShapeState initState;
  // a list of the shapes in its different states
  private ArrayList<IShapeState> states;
  
  
  /**
   * Public constructor that allows for the creation of an {@code AnimatedShape} object while
   * specifying all its fields.
   * 
   * @param type the type of the shape
   * @param initState The initial state of the shape as an {@code IShapeState}
   * @param states A list of {@code IShapeState} objects representing end points of motions
   */
  public AnimatedShape(ShapeType type, IShapeState initState, ArrayList<IShapeState> states) {
    if (type == null || states == null) {
      throw new IllegalArgumentException("Cannot construct " +
              "animated shape with null type or null states.");
    }
    else {
      this.type = type;
      this.initState = initState;
      this.states = states;
    }
  }

  /**
   * Public constructor that allows for the creation of an {@code AnimatedShape} object at
   * its initial state, with no movements added.
   * 
   * @param type the type of the shape
   * @param initState The initial state of the shape as an {@code IShapeState}
   */
  public AnimatedShape(ShapeType type, IShapeState initState) {
    this(type, initState, new ArrayList<IShapeState>());
  }

  /**
   * Serves as something of a builder for motions. This way, anyone using or extending this
   * implementation can very easily personalize the kinds of motions they want to create, while
   * having access to the most recent state of this animated shape.
   */
  private class MotionAdder {
    private IReadOnlyShapeState mostRecentShape;
    private int startWidth;
    private int startHeight;
    private int endWidth;
    private int endHeight;
    private Point2D startPos;
    private Point2D endPos;
    private Color startColor;
    private Color endColor;
    private int startTick;
    private int endTick;

    private MotionAdder() {
      if (AnimatedShape.this.states.isEmpty()) {
        this.mostRecentShape = AnimatedShape.this.initState;
      }
      else {
        this.mostRecentShape = AnimatedShape.this.states.get(AnimatedShape.this.states.size() - 1);
      }
      this.startWidth = this.mostRecentShape.getWidth();
      this.startHeight = this.mostRecentShape.getHeight();
      this.endWidth = this.mostRecentShape.getWidth();
      this.endHeight = this.mostRecentShape.getHeight();
      this.startPos = this.mostRecentShape.getPosition();
      this.endPos = this.mostRecentShape.getPosition();
      this.startColor = this.mostRecentShape.getColor();
      this.endColor = this.mostRecentShape.getColor();
      this.startTick = this.mostRecentShape.getTick();
      this.endTick = this.mostRecentShape.getTick();
    }

    private MotionAdder setStartWidth(int value) {
      if (value <= 0) {
        throw new IllegalArgumentException("Width must be positive");
      }
      this.startWidth = value;
      return this;
    }

    private MotionAdder setStartHeight(int value) {
      if (value <= 0) {
        throw new IllegalArgumentException("Height must be positive");
      }
      this.startHeight = value;
      return this;
    }

    private MotionAdder setEndWidth(int value) {
      if (value <= 0) {
        throw new IllegalArgumentException("Width must be positive");
      }
      this.endWidth = value;
      return this;
    }

    private MotionAdder setEndHeight(int value) {
      if (value <= 0) {
        throw new IllegalArgumentException("Height must be positive");
      }
      this.endHeight = value;
      return this;
    }

    private MotionAdder setStartPos(Point2D pos) {
      this.startPos = pos;
      return this;
    }

    private MotionAdder setEndPos(Point2D pos) {
      this.endPos = pos;
      return this;
    }

    private MotionAdder setStartColor(Color color) {
      this.startColor = color;
      return this;
    }

    private MotionAdder setEndColor(Color color) {
      this.endColor = color;
      return this;
    }

    private MotionAdder setStartTick(int value) {
      if (value <= 0) {
        throw new IllegalArgumentException("Tick must be positive");
      }
      this.startTick = value;
      return this;
    }

    private MotionAdder setEndTick(int value) {
      if (value <= 0) {
        throw new IllegalArgumentException("Tick must be positive");
      }
      this.endTick = value;
      return this;
    }
    
    public MotionAdder setDuration(int duration) {
      if (duration < 1) {
        throw new IllegalArgumentException("Durations must be positive.");
      }
      else {
        this.endTick = this.startTick + duration;
        return this;
      }   
    }

    /**
     * Adds a new shape state to this animated shape. First checks if the ticks specified create
     * any overlapping motions, then adds the correct {@code IShapeState} to this AnimatedShape.
     * 
     * @return returns this object after mutating it
     */
    private AnimatedShape add() {

      ArrayList<IShapeState> states = AnimatedShape.this.states;

      for (int i = 0; i < AnimatedShape.this.states.size(); i += 2) {
        if (!((this.startTick <= states.get(i).getTick()
            && this.endTick <= states.get(i).getTick())
            || (this.startTick >= states.get(i + 1).getTick()
                && this.endTick >= states.get(i + 1).getTick()))) {
          throw new IllegalArgumentException(
              "Shape is already performing an operation "
              + "during at least one of the ticks specified.");
        }
      }

      switch (AnimatedShape.this.type) {
        case RECTANGLE:
          AnimatedShape.this.states.add(
              new RectangleState(
                  this.startTick, this.startWidth, 
                  this.startHeight, this.startColor, this.startPos));
          AnimatedShape.this.states.add(
              new RectangleState(
                  this.endTick, this.endWidth, this.endHeight, this.endColor, this.endPos));
          break;
        case ELLIPSE:
          AnimatedShape.this.states.add(
              new EllipseState(
                  this.startTick, this.startWidth,
                  this.startHeight, this.startColor, this.startPos));
          AnimatedShape.this.states.add(
              new EllipseState(
                  this.endTick, this.endWidth, this.endHeight, this.endColor, this.endPos));
          break;
        default:
          break;
      }
      return AnimatedShape.this;
    }
  }
  
  @Override
  public String getMotions() {
    String result = "";
    int i = 0;
    while (i < this.states.size() - 1) {
      result +=  this.states.get(i).toString() + "    " + this.states.get(i + 1).toString() + "\n"; 
      i += 2;
    }
    return result;
  }

  @Override
  public IReadOnlyShapeState getShapeAt(int tick) {
    // TODO implement when we start animation
    return null;
  }

  @Override
  public void fullMotionTo(
          Point2D endPos, int endHeight, int endWidth, Color endColor, int duration) {
    if (endPos == null || endColor == null) {
      throw new IllegalArgumentException("Position and color must not be null.");
    }
    new MotionAdder()
            .setEndColor(endColor)
            .setEndHeight(endHeight)
            .setEndWidth(endWidth)
            .setEndPos(endPos)
            .setDuration(duration)
            .add();
  }

  @Override
  public void changeColor(Color color, int duration) {
    if (color == null) {
      throw new IllegalArgumentException("Position and color must not be null.");
    }
    new MotionAdder().setEndColor(color).setDuration(duration).add();
  }

  @Override
  public void moveTo(Point2D endPos, int duration) {
    if (endPos == null) {
      throw new IllegalArgumentException("Position and color must not be null.");
    }
    new MotionAdder().setEndPos(endPos).setDuration(duration).add();    
  }

  @Override
  public void changeSizeTo(int newHeight, int newWidth, int duration) {
    new MotionAdder().setEndWidth(newWidth)
            .setEndHeight(newHeight)
            .setDuration(duration)
            .add();
  }
  
  @Override
  public void addDoNothing(int duration) {
    new MotionAdder().setDuration(duration).add();
  }
  
  @Override
  public List<IReadOnlyShapeState> getStates() {
    ArrayList<IReadOnlyShapeState> result = new ArrayList<IReadOnlyShapeState>();
    
    for (IShapeState state : this.states) {
      result.add(state.deepCopy());
    }
    
    return result;
  }

}
