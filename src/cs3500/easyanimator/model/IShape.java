package cs3500.easyanimator.model;

public interface IShape {

  void changeColor(Color color, int duration);
  void move(Posn moveTo, int duration);
  void changeSize(int duration, int newHeight, int newWidth) throws IllegalArgumentException;
  String getHistory();

}
