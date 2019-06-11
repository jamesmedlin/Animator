package cs3500.animator.view;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import cs3500.animator.model.IAnimatedShape;
import cs3500.animator.model.IReadOnlyAnimatedShape;
import cs3500.animator.model.IReadOnlyModel;
import cs3500.animator.model.IReadOnlyShapeState;
import cs3500.animator.model.ShapeType;

public class SVGView implements IView {
  private int rate;
  private HashMap<ShapeType, Function<IReadOnlyAnimatedShape, ISVGTag>> commandMap;
  
  public SVGView(int rate) {
    this.rate = rate;
    this.commandMap.put(
        ShapeType.RECTANGLE, (IReadOnlyAnimatedShape shape) -> {return new RectangleTag(shape);});
    this.commandMap.put(
        ShapeType.ELLIPSE, (IReadOnlyAnimatedShape shape) -> {return new EllipseTag(shape);});
  }

  @Override
  public String printView(IReadOnlyModel model) {
    throw new UnsupportedOperationException("You suck.");
  }

  public String formatSVG2(IReadOnlyModel model) {
    String result = "";
    for (IReadOnlyAnimatedShape shape : model.getShapes()) {
      Function<IReadOnlyAnimatedShape, ISVGTag> func = this.commandMap.get(shape.getType());
      ISVGTag tag = func.apply(shape);
      result += tag.format();
    }
    return result;
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
