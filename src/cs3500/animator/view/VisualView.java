package cs3500.animator.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.Timer;

import cs3500.animator.model.IReadOnlyModel;
import cs3500.animator.model.IReadOnlyShapeState;

/**
 * Represents a view that opens a separate animation window.
 */
public class VisualView extends JFrame implements IView {
  protected DrawingPanel panel;

  /**
   * represents the standard animation/user-friendly interpretation of the program.
   */
  public VisualView(int speed, int width, int height) {
    super();

    this.panel = new DrawingPanel();
    this.setSize(width + 25, height + 25);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel.setPreferredSize(new Dimension(width, height));
    panel.setBackground(Color.white);


    add(panel);
    setVisible(true);
  }

  @Override
  public String printView(IReadOnlyModel model) {
    throw new UnsupportedOperationException("This operation is not" +
            " supported in this type of view.");
  }

  @Override
  public String formatSVG(IReadOnlyModel model) {
    throw new UnsupportedOperationException("This operation is not" +
            " supported in this type of view.");
  }
  
  @Override
  public void drawShapes(List<IReadOnlyShapeState> shapes) {
    panel.draw(shapes);
  }
}
