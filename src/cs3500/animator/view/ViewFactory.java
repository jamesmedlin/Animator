package cs3500.animator.view;

public class ViewFactory {

  public IView makeView(String type) {
    switch (type) {
      case "text":
        return new TextView();
      case "svg":
        return new SVGView();
      case "visual":
        return new VisualView();
      default:
        throw new IllegalArgumentException("Must be a valid type of view.");
    }
  }
}
