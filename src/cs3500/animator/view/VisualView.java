package cs3500.animator.view;

import cs3500.animator.model.IReadOnlyModel;

public class VisualView implements IView {


  @Override
  public String printView(IReadOnlyModel model) {
    throw new UnsupportedOperationException("You suck.");
  }

  @Override
  public String formatSVG(IReadOnlyModel model) {
    return null;
  }
}
