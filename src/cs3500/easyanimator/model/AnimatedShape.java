package cs3500.easyanimator.model;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.Arrays;

public class AnimatedShape implements IAnimatedShape {

  private final ShapeType type;
  private final IShapeState initState;
  private ArrayList<IShapeState> states;

  public AnimatedShape(ShapeType type, IShapeState initState, ArrayList<IShapeState> states) {
    this.type = type;
    this.initState = initState;
    this.states = states;
  }

  public AnimatedShape(ShapeType type, IShapeState initState) {
    this.type = type;
    this.initState = initState;
    this.states = new ArrayList<IShapeState>();
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
      this.startWidth = value;
      return this;
    }

    private MotionAdder setStartHeight(int value) {
      this.startHeight = value;
      return this;
    }

    private MotionAdder setEndWidth(int value) {
      this.endWidth = value;
      return this;
    }

    private MotionAdder setEndHeight(int value) {
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
      this.startTick = value;
      return this;
    }

    private MotionAdder setEndTick(int value) {
      this.endTick = value;
      return this;
    }
    
    public MotionAdder setDuration(int duration) {
      this.endTick = this.startTick + duration;
      return this;
    }

    private AnimatedShape add() {

      ArrayList<IShapeState> states = AnimatedShape.this.states;

      for (int i = 0; i < AnimatedShape.this.states.size(); i += 2) {
        if (!((this.startTick < states.get(i).getTick()
            && this.endTick < states.get(i).getTick())
            || (this.startTick > states.get(i + 1).getTick()
                && this.endTick > states.get(i + 1).getTick()))) {
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
  public IShapeState getShapeAt(int tick) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void fullMotionTo(
      Point2D endPos, int endHeight, int endWidth, Color endColor, int duration) {
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
    AnimatedShape.MotionAdder adder = new MotionAdder();
    adder.setEndColor(color).setDuration(duration).add();
  }

  @Override
  public void moveTo(Point2D endPos, int duration) {
    AnimatedShape.MotionAdder adder = new MotionAdder();
    adder.setEndPos(endPos).setDuration(duration).add();    
  }

  @Override
  public void changeSizeTo(int newHeight, int newWidth, int duration) {
    AnimatedShape.MotionAdder adder = new MotionAdder();
    adder.setEndWidth(newWidth)
    .setEndHeight(newHeight)
    .setDuration(duration)
    .add();       
  }



}
