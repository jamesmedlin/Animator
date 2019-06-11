package cs3500.animator.view;

import java.util.List;

import cs3500.animator.model.IReadOnlyAnimatedShape;
import cs3500.animator.model.IReadOnlyModel;
import cs3500.animator.model.IReadOnlyShapeState;
import cs3500.animator.model.ShapeType;

public class SVGView implements IView {


  @Override
  public String printView(IReadOnlyModel model) {
    throw new UnsupportedOperationException("You suck.");
  }

  @Override
  public String formatSVG(IReadOnlyModel model) {
    String result = "";
    List<IReadOnlyAnimatedShape> shapes = model.getShapes();
    for (IReadOnlyAnimatedShape shape : shapes) {
      result += "<" + convertType(shape.getType()) + ">\n";
      result += stateConverter(shape.getStates());
    }
    return result;
  }


  private static String convertType(ShapeType type) {
    switch (type) {
      case RECTANGLE:
        return "rect";
      case ELLIPSE:
        return "ellipse";
      default:
        throw new IllegalArgumentException("Must be a valid type");
    }
  }

  private static String stateConverter(List<IReadOnlyShapeState> states) {
    String result = "";
    for (IReadOnlyShapeState state : states) {
      result += "<animate attributesType=\"xml\" begin=\"" + state.;
    }
  }
}
