package cs3500.animator.view;

public interface IViewListener {
  void pause();
  void play();
  void restart();
  void updateSpeed(int newTPS);
  void addShape(String id, String shapeType);
  void removeShape(String id);
  void loop(boolean value);
  void addKeyFrame(String id, double x, double y, int width, int height, int r, int g, int b);
  void removeKeyFrame(String id, int index);
  void editKeyFrame(
      String id, int index, double x, double y, int width, int height, int r, int g, int b);

}
