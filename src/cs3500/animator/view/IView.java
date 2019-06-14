package cs3500.animator.view;

import cs3500.animator.model.IReadOnlyModel;

public interface IView {

  /**
   * prints the motions of each shape in the animation.
   *
   * @param model a Read Only version of the model
   * @return a String description of the shapes and their motions
   */
  String printView(IReadOnlyModel model);

  /**
   * returns an svg formatted description of the animation.
   *
   * @param model a Read Only version of the model
   * @return a String description of the animation in SVG style
   */
  String formatSVG(IReadOnlyModel model);

  /**
   * renders all the shapes in the given list.
   */
  void render();
}
