package cs3500.animator.view;

public class ViewFactory {

  public IView makeView(String type, int ticksPerSecond) {
    switch (type) {
      case "text":
        return new TextView();
      case "svg":
        return new SVGView(ticksPerSecond);
      case "visual":
        return new VisualView(ticksPerSecond);
      default:
        throw new IllegalArgumentException("Must be a valid type of view.");
    }
  }
}
