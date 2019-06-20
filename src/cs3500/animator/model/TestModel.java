package cs3500.animator.model;

import java.io.IOException;
import java.util.List;


public class TestModel implements IModel {
  private final Appendable appendable;

  public TestModel(Appendable appendable){
    this.appendable = appendable;
  }

  @Override
  public void addShape(String id, ShapeType type) throws IllegalArgumentException {
    try{
      appendable.append("Shape " + id + " added into model");
    }catch (IOException e){
      System.err.println("Model appendable couldn't output addShape");
    }
  }

  @Override
  public List<IReadOnlyShapeState> getShapesAtTick(int tick) {
    return null;
  }

  @Override
  public String getShape(String name) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public IReadOnlyAnimatedShape getShapeObject(String name) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<IReadOnlyAnimatedShape> getShapes() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getWidth() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getHeight() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void removeShape(String name) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void changeColorTo(String name, int red, int green, int blue, int duration)
      throws IllegalArgumentException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void moveTo(String name, double x, double y, int duration) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void changeSizeTo(String name, int newHeight, int newWidth, int duration)
      throws IllegalArgumentException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void fullMotionTo(String name, int duration, double endX, double endY, int endHeight,
      int endWidth, int endRed, int endGreen, int endBlue) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void doNothing(String name, int duration) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void fullMotion(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1,
      int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void removeKeyFrame(String id, int index) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void editKeyFrame(String id, int index, int tick, double x, double y, int width,
      int height, int r, int g, int b) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void addKeyFrame(String id, int tick, double x, double y, int width, int height, int r,
      int g, int b) {
    // TODO Auto-generated method stub
    
  }
}
