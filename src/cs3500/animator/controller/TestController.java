package cs3500.animator.controller;
import java.io.IOException;
import cs3500.animator.view.IView;
import cs3500.animator.view.IViewListener;


public class TestController implements IAnimatorController, IViewListener {
  private final Appendable appendable;

  public TestController(IView view, Appendable appendable){
    view.addListner(this);
    this.appendable = appendable;
  }

  @Override
  public void play() {
    try{
      appendable.append("play");
    } catch (IOException e) {
      System.err.println("Appendable could not output play");
    }
  }

  @Override
  public void removeShape(String id) {
    try {
      appendable.append(id + " shape removed");
    } catch (IOException e) {
      System.err.println("Appendable could not output pause");
    }
  }

  @Override
  public void loop(boolean value) {
    try {
      appendable.append("loop");
    } catch (IOException e) {
      System.err.println("Appendable could not output loop");
    }
  }

  @Override
  public void pause() {
    try {
      appendable.append("pause");
    } catch (IOException e) {
      System.err.println("Appendable could not output pause");
    }
  }

  @Override
  public void restart() {
    try {
      appendable.append("restart");
    } catch (IOException e) {
      System.err.println("Appendable could not output restart");
    }

  }

  @Override
  public void updateSpeed(int newTPS) {
    try {
      appendable.append("new speed: " + newTPS);
    } catch (IOException e) {
      System.err.println("Appendable could not output updateSpeed");
    }
  }

  @Override
  public void addShape(String id, String shapeType) {
    try {
      appendable.append("new shape: " + id);
    } catch (IOException e) {
      System.err.println("Appendable could not output addShape");
    }
  }

  @Override
  public void addKeyFrame(
      String id, int tick, double x, double y, int width, int height, int r, int g, int b) {
    try {
      appendable.append("new key frame to shape " + id + " at tick " + tick);
    } catch (IOException e) {
      System.err.println("Appendable could not output addKeyFrame");
    }
  }

  @Override
  public void removeKeyFrame(String id, int index) {
    try {
      appendable.append("key frame removed from shape " + id);
    } catch (IOException e) {
      System.err.println("Appendable could not output removeKeyFrame");
    }
  }

  @Override
  public void editKeyFrame(String id, int index, int tick, double x, double y, int width,
      int height, int r, int g, int b) {
    try {
      appendable.append("key frame edited for shape " + id);
    } catch (IOException e) {
      System.err.println("Appendable could not output editKeyFrame");
    }
  }
}
