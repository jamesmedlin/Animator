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
  private JScrollPane scrollPane;
  private Timer timer;
  private int tick = 0;

  /**
   * represents the standard animation/user-friendly interpretation of the program.
   */
  public VisualView(int speed, IReadOnlyModel model) {
    super();

    this.panel = new DrawingPanel();
    panel.setMinimumSize(new Dimension(model.getWidth(), model.getHeight()));
    panel.setPreferredSize(new Dimension(2000, 2000));
    panel.setBackground(Color.white);

    this.timer = new Timer(1000 / speed, new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        List<IReadOnlyShapeState> shapesToRender = model.getShapesAtTick(tick++);
        drawShapes(shapesToRender);
      }
    });


    scrollPane = new JScrollPane(panel);

    setSize(800, 800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocation(200, 200);

    add(scrollPane);

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
  public void render() {
    this.timer.start();
  }

  private void drawShapes(List<IReadOnlyShapeState> shapes) {
    panel.draw(shapes);
  }
}
