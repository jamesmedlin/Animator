package cs3500.easyanimator.model;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.Arrays;

public class AnimatedShape implements IAnimatedShape {

  private final ShapeType type;
  private ArrayList<IShapeState> states;

  public AnimatedShape(ShapeType type, ArrayList<IShapeState> states) {
    this.type = type;
    this.states = states;
  }

  public AnimatedShape(ShapeType type, IShapeState initialState) {
    this.type = type;
    this.states = new ArrayList<IShapeState>(Arrays.asList(initialState));
  }

  @Override
  public String getMotions() {
    String result = "";
    int i = 0;
    while (i < this.states.size() - 1) {
      result +=  this.states.get(i).toString() + "    " + this.states.get(i + 1).toString() + "/n"; 
      i += 2;
    }

    return result;
  }

  public class MotionAdder {
    private IShapeState mostRecentShape = 
        AnimatedShape.this.states.get(AnimatedShape.this.states.size() - 1);

    private int startWidth = this.mostRecentShape.getWidth();
    private int startHeight = this.mostRecentShape.getHeight();
    private int endWidth = this.mostRecentShape.getWidth();
    private int endHeight = this.mostRecentShape.getHeight();
    private Point2D startPos = this.mostRecentShape.getPosition();
    private Point2D endPos = this.mostRecentShape.getPosition();
    private Color startColor = this.mostRecentShape.getColor();
    private Color endColor = this.mostRecentShape.getColor();
    private int startTick = this.mostRecentShape.getTick();
    private int endTick = this.mostRecentShape.getTick();

    public MotionAdder() {
    }

    public MotionAdder setStartWidth(int value) {
      this.startWidth = value;
      return this;
    }

    public MotionAdder setStartHeight(int value) {
      this.startHeight = value;
      return this;
    }

    public MotionAdder setEndWidth(int value) {
      this.endWidth = value;
      return this;
    }

    public MotionAdder setEndHeight(int value) {
      this.endHeight = value;
      return this;
    }

    public MotionAdder setStartPos(Point2D pos) {
      this.startPos = pos;
      return this;
    }

    public MotionAdder setEndPos(Point2D pos) {
      this.endPos = pos;
      return this;
    }

    public MotionAdder setStartColor(Color color) {
      this.startColor = color;
      return this;
    }

    public MotionAdder setEndColor(Color color) {
      this.endColor = color;
      return this;
    }

    public MotionAdder setStartTick(int value) {
      this.startTick = value;
      return this;
    }

    public MotionAdder setEndTick(int value) {
      this.endTick = value;
      return this;
    }

    public AnimatedShape add() {
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
  public void addFullMotion(int startTime, int endTime, Point2D startPos, Point2D endPos,
      int startHeight, int endHeight, int startWidth, int endWidth, Color startColor,
      Color endColor) {
    new MotionAdder().setStartColor(startColor)
    .setEndColor(endColor)
    .setStartHeight(startHeight)
    .setEndHeight(endHeight)
    .setStartWidth(startWidth)
    .setEndWidth(endWidth)
    .setStartPos(startPos)
    .setEndPos(endPos)
    .setStartTick(startTime)
    .setEndTick(endTime)
    .add();
  }

  @Override
  public void changeColor(Color color, int duration) {
    AnimatedShape.MotionAdder adder = new MotionAdder();
    adder.setEndColor(color).setEndTick(adder.mostRecentShape.getTick() + duration).add();
  }

  @Override
  public void moveTo(Point2D endPos, int duration) {
    AnimatedShape.MotionAdder adder = new MotionAdder();
    adder.setEndPos(endPos).setEndTick(adder.mostRecentShape.getTick() + duration).add();    
  }

  @Override
  public void changeSizeTo(int newHeight, int newWidth, int duration) {
    AnimatedShape.MotionAdder adder = new MotionAdder();
    adder.setEndWidth(newWidth)
    .setEndHeight(newHeight)
    .setEndTick(adder.mostRecentShape.getTick() + duration)
    .add();       
  }



}
