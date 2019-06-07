package cs3500.easyanimator.model;

import java.awt.geom.Point2D;

/**
 * represents the instantaneous state of an ellipse shape
 */

public class EllipseState extends AShapeState {

  public EllipseState(int tick, int width, int height, Color color, Point2D position) {
    super(tick, width, height, color, position);
  }

  @Override
  public IShapeState deepCopy() {
    return new EllipseState(
        this.tick, this.width, this.height, 
        new Color(this.color.getRed(), this.color.getGreen(), this.color.getBlue()),
        new Point2D.Double(this.position.getX(), this.position.getY()));
  }
}
