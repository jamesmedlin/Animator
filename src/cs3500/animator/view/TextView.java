package cs3500.animator.view;

import java.awt.event.ActionListener;
import java.util.List;

import cs3500.animator.model.IReadOnlyAnimatedShape;
import cs3500.animator.model.IReadOnlyModel;
import cs3500.animator.model.IReadOnlyShapeState;
import cs3500.animator.model.ShapeType;

/**
 * Represents an animation formatted as a string of texts that lists shapes and their motions.
 */
public class TextView implements IView {

  @Override
  public String printView(IReadOnlyModel model) {
    String result = "";
    List<IReadOnlyAnimatedShape> shapes = model.getShapes();
    for (IReadOnlyAnimatedShape shape : shapes) {
      result += convertToString(shape.getType()) + " " + shape.getName() + ":\n";
      result += shape.getMotions();
    }
    return result;
  }

  @Override
  public void drawShapes(List<IReadOnlyShapeState> shapes) {
    throw new UnsupportedOperationException("This operation is not " +
        "supported in this type of view.");
  }

  private String convertToString(ShapeType type) throws IllegalArgumentException {
    switch (type) {
      case RECTANGLE:
        return "Rectangle";
      case ELLIPSE:
        return "Ellipse";
      default:
        throw new IllegalArgumentException("Conversion code from Shape " +
            "types to String must be updated.");
    }
  }
  
  @Override
  public void addListener(IViewListener listener) {
    throw new UnsupportedOperationException("Listeners not supported for this view.");
  }
}
