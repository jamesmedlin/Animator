package cs3500.easyanimator.model;

import java.awt.geom.Point2D;

public interface IReadOnlyShapeState {
  int getWidth();
  int getHeight();
  Color getColor();
  Point2D getPosition();
  int getTick();
}
