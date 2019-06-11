package cs3500.animator.view;

import cs3500.animator.model.IReadOnlyAnimatedShape;

public abstract class ASVGTag implements ISVGTag {
  
  protected final IReadOnlyAnimatedShape shape;
  
  protected ASVGTag(IReadOnlyAnimatedShape shape) {
    this.shape = shape;
  }
  
  @Override
  public abstract String format();

}
