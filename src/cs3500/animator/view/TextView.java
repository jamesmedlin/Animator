package cs3500.animator.view;

import java.awt.event.ActionListener;
import java.util.List;

import cs3500.animator.model.IReadOnlyAnimatedShape;
import cs3500.animator.model.IReadOnlyModel;
import cs3500.animator.model.ShapeType;

/**
 * represents the text formatted as a String for this type of view in this program.
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
  public String formatSVG(IReadOnlyModel model) {
    throw new UnsupportedOperationException("This operation is not " +
        "supported in this type of view.");
  }

  @Override
  public void play() {
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
  public void setListener(ActionListener listener) {
    // TODO Auto-generated method stub
    
  }
}
