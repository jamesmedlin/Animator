package cs3500.easyanimator.model;

import java.util.ArrayList;

public class MovableShape implements IMovableShape {

  private IShape shape;
  private ArrayList<IMotion> motions;
  
  public MovableShape(IShape shape, ArrayList<IMotion> motions) {
    this.shape = shape;
    this.motions = motions;
  }
  
  @Override
  public String getMotions() {
    String result = "";
    
    for (IMotion motion : this.motions) {
      result +=  motion.toString() + "\n"; 
    }
    
    return result;
  }

  @Override
  public void addMotion(int startTime, int endTime, double startX, double endX, double startY,
      double endY, int startHeight, int endHeight, int startWidth, int endWidth, int startRed,
      int endRed, int startGreen, int endGreen, int startBlue, int endBlue) {
    this.motions.add(new Motion(startTime, endTime, startX, endX,startY, endY, startHeight,
        endHeight, startWidth, endWidth, startRed, endRed, startGreen,
        endGreen, startBlue, endBlue));
  }
  
}
