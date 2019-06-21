package cs3500.animator.view;

import cs3500.animator.model.ShapeType;

public interface IViewListener {
  void pause();
  void play();
  void restart();
  void updateSpeed(int newTPS);
  void addShape(String id, ShapeType shapeType);
  void removeShape(String id);
  void loop(boolean value);
  void addKeyFrame(
      String id, int tick, double x, double y, int width, int height, int r, int g, int b);
  void removeKeyFrame(String id, int index);
  void editKeyFrame(String id, int index, int tick, double x, double y,
      int width, int height, int r, int g, int b);

}
