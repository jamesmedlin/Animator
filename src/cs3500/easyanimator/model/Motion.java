package cs3500.easyanimator.model;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

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
  
  private Motion(int startTime, int endTime, double startX, double startY, double endX, double endY,
      int startHeight, int endHeight, int startWidth, int endWidth, int startRed, int endRed,
      int startGreen, int endGreen, int startBlue, int endBlue) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.startPos = new Point2D.Double(startX, startY);
    this.endPos = new Point2D.Double(endX, endY);
    this.startHeight = startHeight;
    this.endHeight = endHeight;
    this.startWidth = startWidth;
    this.endWidth = endWidth;
    this.startRed = startRed;
    this.endRed = endRed;
    this.startGreen = startGreen;
    this.endGreen = endGreen;
    this.startBlue = startBlue;
    this.endBlue = endBlue;
  }
  
  
  
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
