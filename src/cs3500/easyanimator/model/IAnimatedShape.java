package cs3500.easyanimator.model;

import java.awt.geom.Point2D;

public interface IAnimatedShape {
  /**
   * retrieves the previous states of the shape
   * @return the history of the shape
   */
  String getMotions();
  
  IShapeState getShapeAt(int tick);

  void addFullMotion(int startTime, int endTime, Point2D startPos, Point2D endPos, int startHeight,
      int endHeight, int startWidth, int endWidth, Color startColor, Color endColor);

  void changeColor(Color color, int duration);

  void moveTo(Point2D endPos, int duration);


  void changeSizeTo(int newHeight, int newWidth, int duration);

}
