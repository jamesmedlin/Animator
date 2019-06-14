package cs3500.animator.view;

/**
 * represents a factory to make the specific View type given.
 */
public class ViewFactory {

  /**
   * based on the given string, this creates an instance of the respective view.
   * @param type the string version of a specific type
   * @param ticksPerSecond the speed at which the view should run
   * @throws IllegalArgumentException when given an invalid view type
   * @return an instance of the requested View
   */
  public IView makeView(String type, int ticksPerSecond) throws IllegalArgumentException {
    switch (type) {
      case "text":
        return new TextView();
      case "svg":
        return new SVGView(ticksPerSecond);
      case "visual":
        return new VisualView();
      default:
        throw new IllegalArgumentException("Must be a valid type of view.");
    }
  }
}
