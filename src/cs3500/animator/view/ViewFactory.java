package cs3500.animator.view;

import cs3500.animator.model.IReadOnlyModel;

/**
 * represents a factory to make the specific View type given.
 */
public class ViewFactory {

  /**
   * creates an instance of the requested view based on the given type.
   * @param type
   * @param ticksPerSecond
   * @param model
   * @return
   */
  public static IView makeView(String type, int ticksPerSecond, IReadOnlyModel model) {
    switch (type) {
      case "text":
        return new TextView();
      case "svg":
        return new SVGView(ticksPerSecond);
      case "visual":
        return new VisualView(ticksPerSecond, model);
      default:
        throw new IllegalArgumentException("Must be a valid type of view.");
    }
  }
}
