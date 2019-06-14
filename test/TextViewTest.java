import static cs3500.animator.model.ShapeType.ELLIPSE;
import static cs3500.animator.model.ShapeType.RECTANGLE;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import cs3500.animator.model.IModel;
import cs3500.animator.model.Model;
import cs3500.animator.view.IView;
import cs3500.animator.view.TextView;

/**
 * tests the textual view of {@code AShapeState} for getters.
 */
public class TextViewTest {

  IModel m1;
  IView v1;

  @Before
  public void setUp() {
    m1 = new Model();
    v1 = new TextView();
  }

  @Test
  public void testPrintView3() {
    assertEquals("", v1.printView(m1));
  }

  @Test
  public void testPrintView2() {
    m1.addShapeAt(1,"Dave", RECTANGLE,10,10,10,10,255,255,255);
    m1.addShapeAt(4,"Rich II", ELLIPSE,20,30,20,2,3,30,57);
    assertEquals("Rectangle Dave:\n" +
            "Ellipse Rich II:\n", v1.printView(m1));
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

  @Test
  public void testPrintViewBasedOnWhenInstantiated() {
    m1.addShapeAt(1,"Dave", RECTANGLE,10,10,10,10,255,255,255);
    m1.addShapeAt(10,"Adam", ELLIPSE,20,30,20,2,3,30,57);
    m1.addShapeAt(5,"Daniel", RECTANGLE,30,30,10,10,30,78,180);
    m1.addShapeAt(3,"Vido", ELLIPSE,200,200,1,1,0,0,0);
    m1.fullMotionTo("Dave" ,4,4,4,4,4,4,4,4);
    m1.fullMotionTo("Vido" ,20,250,250,23,34,90,36,78);
    m1.fullMotionTo("Adam", 20,300,300,12,72,200,200,200);
    m1.fullMotionTo("Dave" ,2,76,30,30,23,199,67,255);
    m1.fullMotionTo("Daniel" ,17,100,100,100,100,0,13,255);
    assertEquals("Rectangle Dave:\n" +
            "1 10.0 10.0 10 10 255 255 255    5 4.0 4.0 4 4 4 4 4\n" +
            "5 4.0 4.0 4 4 4 4 4    7 76.0 30.0 23 30 199 67 255\n" +
            "Ellipse Vido:\n" +
            "3 200.0 200.0 1 1 0 0 0    23 250.0 250.0 34 23 90 36 78\n" +
            "Rectangle Daniel:\n" +
            "5 30.0 30.0 10 10 30 78 180    22 100.0 100.0 100 100 0 13 255\n" +
            "Ellipse Adam:\n" +
            "10 20.0 30.0 20 2 3 30 57    30 300.0 300.0 72 12 200 200 200\n", v1.printView(m1));
  }

  @Test
  public void testPrintViewAlphabetically() {
    m1.addShapeAt(3,"Dave", RECTANGLE,10,10,10,10,255,255,255);
    m1.addShapeAt(3,"Adam", ELLIPSE,20,30,20,2,3,30,57);
    m1.addShapeAt(3,"Daniel", RECTANGLE,30,30,10,10,30,78,180);
    m1.addShapeAt(3,"Vido", ELLIPSE,200,200,1,1,0,0,0);
    m1.fullMotionTo("Dave" ,4,4,4,4,4,4,4,4);
    m1.fullMotionTo("Vido" ,20,250,250,23,34,90,36,78);
    m1.fullMotionTo("Adam", 20,300,300,12,72,200,200,200);
    m1.fullMotionTo("Dave" ,2,76,30,30,23,199,67,255);
    m1.fullMotionTo("Daniel" ,17,100,100,100,100,0,13,255);
    assertEquals("Ellipse Adam:\n" +
            "3 20.0 30.0 20 2 3 30 57    23 300.0 300.0 72 12 200 200 200\n" +
            "Rectangle Daniel:\n" +
            "3 30.0 30.0 10 10 30 78 180    20 100.0 100.0 100 100 0 13 255\n" +
            "Rectangle Dave:\n" +
            "3 10.0 10.0 10 10 255 255 255    7 4.0 4.0 4 4 4 4 4\n" +
            "7 4.0 4.0 4 4 4 4 4    9 76.0 30.0 23 30 199 67 255\n" +
            "Ellipse Vido:\n" +
            "3 200.0 200.0 1 1 0 0 0    23 250.0 250.0 34 23 90 36 78\n", v1.printView(m1));
  }
}