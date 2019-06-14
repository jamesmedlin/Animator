package cs3500.animator.view;

import java.util.List;

import cs3500.animator.model.IReadOnlyAnimatedShape;
import cs3500.animator.model.IReadOnlyShapeState;

/**
 * represents an abstracted version of a vsg tag depending on the type of shape.
 */
public abstract class ASVGTag implements ISVGTag {

  protected final IReadOnlyAnimatedShape shape;
  protected int rate;

  protected ASVGTag(IReadOnlyAnimatedShape shape, int rate) {
    this.shape = shape;
    this.rate = rate;
  }

  @Override
  public abstract String format();

  protected String stateConverter(List<IReadOnlyShapeState> states) {
    String result = "";
    for (int i = 0; i < states.size() - 1; i += 2) {
      if (states.get(i).getColor() != states.get(i + 1).getColor()) {
        result += "<animate attributesType=\"xml\" begin=\"" +
                (states.get(i).getTick() / this.rate * 1000) + "ms\" dur=\""
                + ((states.get(i + 1).getTick() - states.get(i).getTick()) / this.rate * 1000)
                + "ms\" attributeName=\"fill\" from=\"rgb(" +
                shape.getStates().get(i).getColor().getRed() + ","
                + shape.getStates().get(i).getColor().getGreen() + ","
                + shape.getStates().get(i).getColor().getBlue() +
                ")\" to=\"rgb("
                + shape.getStates().get(0).getColor().getRed() + ","
                + shape.getStates().get(0).getColor().getGreen() + ","
                + shape.getStates().get(0).getColor().getBlue() + ")\" fill=\"freeze\" />\n";
      }
      result += stateConverterHelper(states, i);
    }
    return result;
  }

  protected String stateConverterHelper(List<IReadOnlyShapeState> states, int i) {
    return "";
  }
}
