package cs3500.animator.view;

import java.awt.Graphics;
import java.awt.Color;
import java.util.List;
import cs3500.animator.model.IReadOnlyShapeState;
import static cs3500.animator.model.ShapeType.ELLIPSE;
import static cs3500.animator.model.ShapeType.RECTANGLE;


public class DrawingPanel extends ADrawingPanel {
  List<IReadOnlyShapeState> shapes = null;

  public DrawingPanel(){
    super();
  }

  @Override
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    if ( shapes != null ){
      for (IReadOnlyShapeState shape : shapes ){
        float[] hsbColor = shape.getColor().getHSB();
        g.setColor(Color.getHSBColor(hsbColor[0], hsbColor[1], hsbColor[3]));
        switch (shape.getType()) {
          case RECTANGLE:
            g.fillRect(
                (int)shape.getPosition().getX(), (int)shape.getPosition().getY(),
                shape.getWidth(), shape.getHeight());
            break;
          case ELLIPSE:
            g.fillOval((int)shape.getPosition().getX(), (int)shape.getPosition().getY(),
                shape.getWidth(), shape.getHeight());
            break;
          default:
            throw new IllegalArgumentException(
                "Enum has been updated without support in DrawingPanel");
        }
      }
    }
  }

}