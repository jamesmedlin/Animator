package cs3500.animator.view;

import java.util.List;

import cs3500.animator.model.IReadOnlyAnimatedShape;
import cs3500.animator.model.IReadOnlyModel;
import cs3500.animator.model.IReadOnlyShapeState;
import cs3500.animator.model.ShapeType;

public class SVGView implements IView {
  int rate;

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
      result += stateConverter(shape.getStates(), model);
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

  private String stateConverter(List<IReadOnlyShapeState> states, IReadOnlyModel model) {
    String result = "";
    for (int i = 0; i < states.size() - 1; i += 2) {
      result += "<animate attributesType=\"xml\" begin=\"" +
              (states.get(i).getTick() / this.rate * 1000) + "ms\" dur=\"" +
              ((states.get(i + 1).getTick() - states.get(i).getTick()) / this.rate * 1000) + "ms\" attributeName=\'" + states.get(i).;
    }
  }
}
