package cs3500.animator.view;
import java.awt.Dimension;
import java.awt.Color;
import java.util.List;

import javax.swing.*;

import cs3500.animator.model.IReadOnlyModel;
import cs3500.animator.model.IReadOnlyShapeState;

public class VisualView extends JFrame implements IView {
  DrawingPanel panel;
  JScrollPane scrollPane;

  /**
   * represents the standard animation/user-friendly interpretation of the program.
   */
  public VisualView(){
    super();

    panel = new DrawingPanel();
    panel.setMinimumSize( new Dimension(500,500));
    panel.setPreferredSize( new Dimension(2000,2000));
    panel.setBackground(Color.yellow);


    scrollPane = new JScrollPane(panel);

    setSize(800,800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocation(200,200);

    add(scrollPane);

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
  public void render(List<IReadOnlyShapeState> shapes) {
    panel.draw(shapes);
  }
}
