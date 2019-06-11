package cs3500.animator.view;

import java.util.List;

import cs3500.animator.model.IReadOnlyAnimatedShape;
import cs3500.animator.model.IReadOnlyShapeState;

public class RectangleTag extends ASVGTag {

  protected RectangleTag(IReadOnlyAnimatedShape shape) {
    super(shape);
  }

  @Override
  public String format() {
    String result = "";
    result += "<rect id=\""
            + shape.getName() + "\" x=\"" + shape.getStates().get(0).getPosition().getX()
            + "\"  y=\"" + shape.getStates().get(0).getPosition().getY() + "\" width=\""
            + shape.getStates().get(0).getWidth() + "\" height=\""
            + shape.getStates().get(0).getHeight() + "\" fill=\"rgb("
            + shape.getStates().get(0).getColor().getRed() + ","
            + shape.getStates().get(0).getColor().getGreen() + ","
            + shape.getStates().get(0).getColor().getBlue() + ")\" visibility=\"visible\" >";
    result += stateConverter(shape.getStates());
    result += "</rect>\n";
    return result;
  }

  private String stateConverter(List<IReadOnlyShapeState> states) {
    String result = "";
    for (int i = 0; i < states.size() - 1; i += 2) {
      if (states.get(i).getPosition().getX() != states.get(i + 1).getPosition().getX()) {
        result += "<animate attributesType=\"xml\" begin=\"" +
                (states.get(i).getTick() / this.rate * 1000) + "ms\" dur=\""
                + ((states.get(i + 1).getTick() - states.get(i).getTick()) / this.rate * 1000)
                + "ms\" attributeName=\"x\" from=\"" + states.get(i).getPosition().getX()
                + "\" to=\"" + states.get(i + 1).getPosition().getX() + "\" fill=\"freeze\" />";
      }
      if (states.get(i).getPosition().getY() != states.get(i + 1).getPosition().getY()) {
        result += "<animate attributesType=\"xml\" begin=\"" +
                (states.get(i).getTick() / this.rate * 1000) + "ms\" dur=\""
                + ((states.get(i + 1).getTick() - states.get(i).getTick()) / this.rate * 1000)
                + "ms\" attributeName=\"y\" from=\"" + states.get(i).getPosition().getY()
                + "\" to=\"" + states.get(i + 1).getPosition().getY() + "\" fill=\"freeze\" />";
      }
      if (states.get(i).getWidth() != states.get(i + 1).getWidth()) {
        result += "<animate attributesType=\"xml\" begin=\"" +
                (states.get(i).getTick() / this.rate * 1000) + "ms\" dur=\""
                + ((states.get(i + 1).getTick() - states.get(i).getTick()) / this.rate * 1000)
                + "ms\" attributeName=\"width\" from=\"" + states.get(i).getWidth()
                + "\" to=\"" + states.get(i + 1).getWidth() + "\" fill=\"freeze\" />";
      }
      if (states.get(i).getHeight() != states.get(i + 1).getHeight()) {
        result += "<animate attributesType=\"xml\" begin=\"" +
                (states.get(i).getTick() / this.rate * 1000) + "ms\" dur=\""
                + ((states.get(i + 1).getTick() - states.get(i).getTick()) / this.rate * 1000)
                + "ms\" attributeName=\"height\" from=\"" + states.get(i).getHeight()
                + "\" to=\"" + states.get(i + 1).getHeight() + "\" fill=\"freeze\" />";
      }
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
                        + shape.getStates().get(0).getColor().getBlue() + ")\" fill=\"freeze\" />";
      }
    }
    return result;
  }
}
