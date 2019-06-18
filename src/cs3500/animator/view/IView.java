package cs3500.animator.view;

import java.awt.event.ActionListener;
import cs3500.animator.controller.IAnimatorController;
import cs3500.animator.model.IReadOnlyModel;

/**
 * Represents the view for an animator program.
 *
 */
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
  void play();

  /**
   * TODO
   */
  void setListener(ActionListener listener);
}
