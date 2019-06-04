package cs3500.easyanimator.model;


public abstract class AShape implements IShape {

  @Override
  public void changeColor(Color color, int duration) {

  }

  @Override
  public void move(Posn moveTo, int duration) {

  }

  @Override
  public void changeSize(int duration, int newHeight, int newWidth) throws IllegalArgumentException {

  }

  @Override
  public String getHistory() {
    return null;
  }
}
