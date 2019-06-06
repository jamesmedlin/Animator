package cs3500.easyanimator.model;

import java.awt.geom.Point2D;

public interface IShapeState extends IReadOnlyShapeState {

  void setWidth(int value);
  
  
  
  void setHeight(int value);
  
  
  void setColor(int red, int green, int blue);
  
  
  void setPosition(double x, double y);
  
  String toString();

}
