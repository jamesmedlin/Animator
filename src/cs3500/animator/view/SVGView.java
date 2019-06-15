package cs3500.animator.view;

import java.util.HashMap;
import java.util.function.Function;

import cs3500.animator.model.IReadOnlyAnimatedShape;
import cs3500.animator.model.IReadOnlyModel;
import cs3500.animator.model.ShapeType;

/**
 * represents the svg type of view for this program's animation.
 */
public class SVGView implements IView {
  private int rate;
  private HashMap<ShapeType, Function<IReadOnlyAnimatedShape, ISVGTag>> commandMap;

  public SVGView(int rate) {
    this.rate = rate;
    this.commandMap = new HashMap<>();
    this.commandMap.put(
            ShapeType.RECTANGLE,
            (IReadOnlyAnimatedShape shape) -> {
              return new RectangleTag(shape, this.rate);
            });
    this.commandMap.put(
            ShapeType.ELLIPSE,
            (IReadOnlyAnimatedShape shape) -> {
              return new EllipseTag(shape, this.rate);
            });
  }

  @Override
  public String formatSVG(IReadOnlyModel model) {
    String result = "<svg width=\"" + model.getWidth() + "\" height\"" + model.getHeight()
            + "\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n";
    for (IReadOnlyAnimatedShape shape : model.getShapes()) {
      Function<IReadOnlyAnimatedShape, ISVGTag> func = this.commandMap.get(shape.getType());
      ISVGTag tag = func.apply(shape);
      result += tag.format();
    }
    return result + "\n</svg>\n";
  }

  @Override
  public String printView(IReadOnlyModel model) {
    throw new UnsupportedOperationException("This operation is" +
            " not supported in this type of view.");
  }

  @Override
  public void render() {
    throw new UnsupportedOperationException("This operation is not" +
            " supported in this type of view.");
  }

}
