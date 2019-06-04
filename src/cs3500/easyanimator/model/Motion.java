package cs3500.easyanimator.model;

import java.awt.geom.Point2D;

public class Motion implements IMotion {
  
  
  
  int startTime;
  int endTime;
  Point2D startPos;
  Point2D endPos;
  int startHeight;
  int endHeight;
  int startWidth;
  int endWidth;
  int startRed;
  int endRed;
  int startGreen;
  int endGreen;
  int startBlue;
  int endBlue;
  
  @Override
  public String toString() {
    return startTime
        + " " + startPos.getX()
        + " " + startPos.getY()
        + " " + startWidth
        + " " + startHeight
        + " " + startRed
        + " " + startGreen
        + " " + startBlue
        + "    "
        + endTime
        + " " + endPos.getX()
        + " " + endPos.getY()
        + " " + endWidth
        + " " + endHeight
        + " " + endRed
        + " " + endGreen
        + " " + endBlue;
  }
}
