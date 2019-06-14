package cs3500.animator.view;

import java.awt.Graphics;
import java.awt.Color;
import java.util.List;

import javax.swing.*;

import cs3500.animator.model.IReadOnlyShapeState;


public class DrawingPanel extends JPanel implements IDrawingPanel {
  List<IReadOnlyShapeState> shapes = null;

  public DrawingPanel(){
    super();
  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    if ( shapes != null ){
      g.setColor( Color.pink );
      for ( IReadOnlyShapeState shape : shapes ){
        g.fillRect((int)shape.getPosition().getX(), (int)shape.getPosition().getY(),shape.getWidth(), shape.getHeight());
      }
    }
  }

  @Override
  public void draw(List<IReadOnlyShapeState> shapes) {
    this.shapes = shapes;
    repaint();
  }
}
