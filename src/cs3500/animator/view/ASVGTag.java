package cs3500.animator.view;

import cs3500.animator.model.IReadOnlyAnimatedShape;

public abstract class ASVGTag implements ISVGTag {
  
  protected final IReadOnlyAnimatedShape shape;
  protected int rate;
  
  protected ASVGTag(IReadOnlyAnimatedShape shape, int rate) {
    this.shape = shape;
    this.rate = rate;
  }
  
  @Override
  public abstract String format();

}
