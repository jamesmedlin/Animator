import org.junit.Before;
import org.junit.Test;
import cs3500.animator.model.AnimatedShape;
import cs3500.animator.model.Color;
import cs3500.animator.model.EllipseState;
import cs3500.animator.model.IModel;
import cs3500.animator.model.Model;
import java.awt.geom.Point2D;
import static cs3500.animator.model.ShapeType.ELLIPSE;
import static cs3500.animator.model.ShapeType.RECTANGLE;
import static org.junit.Assert.assertEquals;


/**
 * Tests the functionality of the {@code Model} class and all of its methods.
 */


public class ModelTest {

  IModel model;

  @Before
  public void setUp() {
    model = new Model();
  }

//  @Test
//  public void testBasicAnimation() {
//    IModel model1 = new Model();
//    assertEquals(model.printHistory(), "");
//  }

  @Test
  public void testBasicAnimation2() {
    model.addShapeAt(1,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.addShapeAt(1,"Dave II", ELLIPSE,10,10,10,10,255,255,255);
    model.addShapeAt(1,"Vidojeeee", RECTANGLE,0,200,20,100,0,0,0);
    model.addShapeAt(1,"Vido", RECTANGLE,1,200,20,100,1,1,1);
    model.getShape("Dave");
    model.getShape("Vidojeeee");
    assertEquals(true, model.getShapeObject("Dave") instanceof AnimatedShape);
    assertEquals(true, model.getShapeObject("Vidojeeee") instanceof AnimatedShape);
    assertEquals(true, model.getShapeObject("Vido") instanceof AnimatedShape);
    assertEquals(true, model.getShapeObject("Dave II") instanceof AnimatedShape);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeAtFail() {
    model.addShapeAt(-1,"Dave", ELLIPSE,10,10,10,10,255,255,255);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeAtFail2() {
    model.addShapeAt(0,"", ELLIPSE,10,10,10,10,255,255,255);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeAtFailNull() {
    model.addShapeAt(0,null, ELLIPSE,10,10,10,10,255,255,255);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeAtFail5() {
    model.addShapeAt(0,"Dave", ELLIPSE,10,10,-1,10,255,255,255);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeAtFail6() {
    model.addShapeAt(0,"Dave", ELLIPSE,10,10,10,-1,255,255,255);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeAtFail7() {
    model.addShapeAt(0,"Dave", ELLIPSE,10,10,10,10,-1,255,255);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeAtFail8() {
    model.addShapeAt(0,"Dave", ELLIPSE,10,10,10,10,255,256,255);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeAtFail9() {
    model.addShapeAt(0,"Dave", ELLIPSE,10,10,10,10,255,255,-1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeAtFail10() {
    model.addShapeAt(0,"Dave", ELLIPSE,10,10,0,10,255,255,-1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeAtFail11() {
    model.addShapeAt(0,"Dave", ELLIPSE,10,10,10,0,255,255,-1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeAtFail12() {
    model.addShapeAt(0,"Dave", RECTANGLE,10,10,0,10,255,255,-1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testAddShapeAtFail13() {
    model.addShapeAt(0,"Dave", RECTANGLE,10,10,10,0,255,255,-1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeColorToFail() {
    model.addShapeAt(1, "Dave", ELLIPSE, 10, 10, 10, 10, 255, 255, 255);
    model.changeColorTo("Dave", 0, 0, 0, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeColorToFail2() {
    model.addShapeAt(1, "Dave", ELLIPSE, 10, 10, 10, 10, 255, 255, 255);
    model.changeColorTo("Dave", 0, 0, 0, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMoveToFail() {
    model.addShapeAt(1, "Dave", ELLIPSE, 10, 10, 10, 10, 255, 255, 255);
    model.changeColorTo("Dave", 0, 0, 0, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testGetShapeFail() {
    model.addShapeAt(0,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.getShape("Vido fails this test like he fails his students every day in class");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveShapeFail() {
    model.addShapeAt(0,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.removeShape("Vido");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testRemoveShapeFail2() {
    model.addShapeAt(0,"Dave", RECTANGLE,10,10,10,10,255,255,255);
    model.removeShape("Vido");
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeSizeToFail() {
    model.addShapeAt(0,"Dave", RECTANGLE,10,10,10,10,255,255,255);
    model.changeSizeTo("Dave",-1,5,3);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeSizeToFail2() {
    model.addShapeAt(0,"Dave", RECTANGLE,10,10,10,10,255,255,255);
    model.changeSizeTo("Dave", 5,-1,9);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeSizeToFail3() {
    model.addShapeAt(0,"Dave", RECTANGLE,10,10,10,10,255,255,255);
    model.changeSizeTo("Dave", 5,-1,9);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeSizeToFail4() {
    model.addShapeAt(0,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.changeSizeTo("Dave", 5,5,0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeSizeToFail5() {
    model.addShapeAt(0,"Dave", RECTANGLE,10,10,10,10,255,255,255);
    model.changeSizeTo("Dave", 5,5,-3);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testChangeSizeToFail6() {
    model.addShapeAt(0,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.changeSizeTo("Vido", 5,7,9);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testFullMotionFail() {
    model.addShapeAt(0,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.fullMotionTo("Jake" ,4,4,4,4,4,4,4,4);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testDoNothingFail() {
    model.addShapeAt(0,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.doNothing("Damn Daniel", 9);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testDoNothingFail2() {
    model.addShapeAt(0,"Dave", RECTANGLE,10,10,10,10,255,255,255);
    model.doNothing("Dave", -3);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testFullMotionFail2() {
    model.addShapeAt(0,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.fullMotionTo("Jake" ,4,4,4,4,4,4,4,4);
  }

  @Test
  public void testAddShapeAt() {
    model.addShapeAt(1,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.changeColorTo("Dave", 0,0,0, 2);
    assertEquals(model.getShape("Dave"), new EllipseState(1,10,10,
        new Color(255,255,255), new Point2D.Double(10,10)).toString() + "    " +
        new EllipseState(3,10,10,
            new Color(0,0,0), new Point2D.Double(10,10)).toString() + "\n");
  }

  @Test
  public void testAddShapeAt2() {
    model.addShapeAt(1,"Dave2", RECTANGLE,10,10,10,10,255,255,255);
    model.changeColorTo("Dave2", 0,0,0, 2);
    assertEquals(model.getShape("Dave2"), new EllipseState(1,10,10,
        new Color(255,255,255), new Point2D.Double(10,10)).toString() + "    " +
        new EllipseState(3,10,10,
            new Color(0,0,0), new Point2D.Double(10,10)).toString() + "\n");
  }

  @Test
  public void testChangeColorTo() {
    model.addShapeAt(1,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.changeColorTo("Dave", 0,0,0, 2);
    assertEquals(model.getShape("Dave"), new EllipseState(1,10,10,
        new Color(255,255,255), new Point2D.Double(10,10)).toString() + "    " +
        new EllipseState(3,10,10,
            new Color(0,0,0), new Point2D.Double(10,10)).toString() + "\n");
  }

  @Test
  public void testChangeSizeTo() {
    model.addShapeAt(1,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.changeSizeTo("Dave", 3,3, 2);
    assertEquals(model.getShape("Dave"), new EllipseState(1,10,10,
        new Color(255,255,255), new Point2D.Double(10,10)).toString() + "    " +
        new EllipseState(3,3,3,
            new Color(255,255,255), new Point2D.Double(10,10)).toString() + "\n");
  }

  @Test
  public void testMoveTo() {
    model.addShapeAt(1,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.moveTo("Dave", 25,33,9);
    assertEquals(model.getShape("Dave"), new EllipseState(1,10,10,
        new Color(255,255,255), new Point2D.Double(10,10)).toString() + "    " +
        new EllipseState(10,10,10,
            new Color(255,255,255), new Point2D.Double(25,33)).toString() + "\n");
  }

  @Test
  public void testMoveToOffScreenLeft() {
    model.addShapeAt(1,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.moveTo("Dave", 25,33,9);
    assertEquals(model.getShape("Dave"), new EllipseState(1,10,10,
        new Color(255,255,255), new Point2D.Double(10,10)).toString() + "    " +
        new EllipseState(10,10,10,
            new Color(255,255,255), new Point2D.Double(25,33)).toString() + "\n");
  }

  @Test
  public void testMoveToOffScreenTop() {
    model.addShapeAt(1,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.moveTo("Dave", 25,-100,9);
    assertEquals(model.getShape("Dave"), new EllipseState(1,10,10,
        new Color(255,255,255), new Point2D.Double(10,10)).toString() + "    " +
        new EllipseState(10,10,10,
            new Color(255,255,255), new Point2D.Double(25,-100)).toString() + "\n");
  }

  @Test
  public void testMoveToOffScreenBottom() {
    model.addShapeAt(1,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.moveTo("Dave", 25,10000,9);
    assertEquals(model.getShape("Dave"), new EllipseState(1,10,10,
        new Color(255,255,255), new Point2D.Double(10,10)).toString() + "    " +
        new EllipseState(10,10,10,
            new Color(255,255,255), new Point2D.Double(25,10000)).toString() + "\n");
  }

  @Test
  public void testMoveToOffScreenRight() {
    model.addShapeAt(1,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.moveTo("Dave", 50000,33,9);
    assertEquals(model.getShape("Dave"), new EllipseState(1,10,10,
        new Color(255,255,255), new Point2D.Double(10,10)).toString() + "    " +
        new EllipseState(10,10,10,
            new Color(255,255,255), new Point2D.Double(50000,33)).toString() + "\n");
  }

//  @Test
//  public void testPrintHistory() {
//    model.addShapeAt(1,"Dave", RECTANGLE,10,10,10,10,255,255,255);
//    model.moveTo("Dave", 50000,33,9);
//    model.changeSizeTo("Dave", 12,12,19);
//    model.changeColorTo("Dave", 200,200,200,23);
//    model.fullMotionTo("Dave", 25,50,50,25,25,13,0,93);
//    assertEquals("1 10.0 10.0 10 10 255 255 255    10 50000.0 33.0 10 10 255 255 255\n" +
//        "10 50000.0 33.0 10 10 255 255 255    29 50000.0 33.0 12 12 255 255 255\n" +
//        "29 50000.0 33.0 12 12 255 255 255    52 50000.0 33.0 12 12 200 200 200\n" +
//        "52 50000.0 33.0 12 12 200 200 200    77 50.0 50.0 25 25 13 0 93\n"
//        ,model.printHistory());
//  }
//
//  @Test
//  public void testPrintHistory3() {
//    model.addShapeAt(1,"Dave", ELLIPSE,10,10,10,10,255,255,255);
//    assertEquals(model.printHistory(),"");
//  }
//
//  @Test
//  public void testPrintHistory2() {
//    model.printHistory();
//    assertEquals(model.printHistory(),"");
//  }

  @Test
  public void testFullMotion() {
    model.addShapeAt(1,"Dave", RECTANGLE,10,10,10,10,255,255,255);
    model.fullMotionTo("Dave", 20,3,3,3,3,0,99,43);
    assertEquals(model.getShape("Dave"),
            "1 10.0 10.0 10 10 255 255 255    21 3.0 3.0 3 3 0 99 43" + "\n");
  }

  @Test
  public void testFullMotion2() {
    model.addShapeAt(1,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.fullMotionTo("Dave",4,4,4,4,4,4,4,4);
    assertEquals(model.getShape("Dave"),
            "1 10.0 10.0 10 10 255 255 255    5 4.0 4.0 4 4 4 4 4" + "\n");
  }

  @Test
  public void testDoNothing() {
    model.addShapeAt(1,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.doNothing("Dave", 1);
    assertEquals(model.getShape("Dave"),
            "1 10.0 10.0 10 10 255 255 255    2 10.0 10.0 10 10 255 255 255" + "\n");
  }

  @Test
  public void testDoNothing2() {
    model.addShapeAt(1,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.doNothing("Dave", 33);
    assertEquals(model.getShape("Dave"),
            "1 10.0 10.0 10 10 255 255 255    34 10.0 10.0 10 10 255 255 255" + "\n");
  }

}