package cs3500.easyanimator.model;

import java.awt.geom.Point2D;

public interface IAnimatedShape {
  /**
   * Retrieves all the states associated with this shape.
   * 
   * @return the motions associated with this animated shape
   */
  String getMotions();
  
  /**
   * Based on the added motions of this animated shape, this method will return the read only
   * version of the shape state that represents the animated shape at the given tick
   * 
   * @param tick the tick at which the Animated shape should be represented
   * @return
   */
  IReadOnlyShapeState getShapeAt(int tick);

  void fullMotionTo(Point2D endPos, int endHeight, int endWidth, Color endColor, int duration);

  void changeColor(Color color, int duration);

  void moveTo(Point2D endPos, int duration);


  void changeSizeTo(int newHeight, int newWidth, int duration);

}
