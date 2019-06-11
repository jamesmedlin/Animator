package cs3500.animator.view;

import java.util.List;

import cs3500.animator.model.IReadOnlyAnimatedShape;
import cs3500.animator.model.IReadOnlyModel;

public class TextView implements IView {


  public String printView(IReadOnlyModel model) {
    String result = "";
    List<IReadOnlyAnimatedShape> shapes = model.getShapes();
    for (IReadOnlyAnimatedShape shape : shapes) {
      result += shape.getMotions();
    }
    return result;
  }

  @Override
  public String formatSVG(IReadOnlyModel model) {
    return null;
  }
}
