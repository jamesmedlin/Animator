package cs3500.easyanimator.model;

import java.awt.geom.Point2D;

public interface IShapeState {

  void setWidth(int value);
  
  int getWidth();
  
  void setHeight(int value);
  
  int getHeight();
  
  void setColor(int red, int green, int blue);
  
  Color getColor();
  
  void setPosition(double x, double y);
  
  Point2D getPosition();
   
  int getTick();
  
  String toString();

}
