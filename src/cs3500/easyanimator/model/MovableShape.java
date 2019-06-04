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
  
}
