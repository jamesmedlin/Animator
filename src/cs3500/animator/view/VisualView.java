package cs3500.animator.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import cs3500.animator.model.IReadOnlyModel;
import cs3500.animator.model.IReadOnlyShapeState;

public class VisualView extends JFrame implements IView {
  private DrawingPanel panel;
  private Timer timer;
  private int tick = 0;

  /**
   * represents the standard animation/user-friendly interpretation of the program.
   */
  public VisualView(int speed, IReadOnlyModel model) {
    super();
    
    this.panel = new DrawingPanel();
    this.setSize(model.getWidth() + 25, model.getHeight() + 25);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel.setPreferredSize(new Dimension(model.getWidth(), model.getHeight()));
    panel.setBackground(Color.white);

    this.timer = new Timer(1000 / speed, new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        List<IReadOnlyShapeState> shapesToRender = model.getShapesAtTick(tick++);
        drawShapes(shapesToRender);
      }
    });

    add(panel);

    setVisible(true);
  }

  @Override
  public String printView(IReadOnlyModel model) {
    throw new UnsupportedOperationException("You suck.");
  }

  @Override
  public String formatSVG(IReadOnlyModel model) {
    throw new UnsupportedOperationException("You suck.");
  }

  @Override
  public void render() {
    this.timer.start();
  }

  private void drawShapes(List<IReadOnlyShapeState> shapes) {
    panel.draw(shapes);
  }
}
