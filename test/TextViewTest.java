import static cs3500.animator.model.ShapeType.ELLIPSE;
import static cs3500.animator.model.ShapeType.RECTANGLE;
import static org.junit.Assert.assertEquals;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import cs3500.animator.model.IModel;
import cs3500.animator.model.Model;
import cs3500.animator.view.IView;
import cs3500.animator.view.TextView;

public class TextViewTest {

  IModel m1;
  IView v1;

  @Before
  public void setUp() {
    m1 = new Model();
    v1 = new TextView();
  }

  @Test
  public void testPrintView() {
    m1.addShapeAt(1,"Dave", RECTANGLE,10,10,10,10,255,255,255);
    m1.addShapeAt(4,"Rich II", ELLIPSE,20,30,20,2,3,30,57);
    m1.fullMotionTo("Dave" ,4,4,4,4,4,4,4,4);
    m1.fullMotionTo("Rich II", 20,300,300,12,72,200,200,200);
    m1.fullMotionTo("Dave" ,2,76,30,30,23,199,67,255);
    assertEquals("Rectangle Dave:\n" +
            "1 10.0 10.0 10 10 255 255 255    5 4.0 4.0 4 4 4 4 4\n" +
            "5 4.0 4.0 4 4 4 4 4    7 76.0 30.0 23 30 199 67 255\n" +
            "Ellipse Rich II:\n" +
            "4 20.0 30.0 20 2 3 30 57    24 300.0 300.0 72 12 200 200 200\n", v1.printView(m1));
  }
}