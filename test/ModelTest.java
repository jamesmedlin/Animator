import org.junit.Before;
import org.junit.Test;

import cs3500.animator.model.AnimatedShape;
import cs3500.animator.model.IModel;
import cs3500.animator.model.Model;

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
    model.addShape("Dave", ELLIPSE);
    model.addShape("Dave II", ELLIPSE);
    model.addShape("Vidojeeee", RECTANGLE);
    model.addShape("Vido", RECTANGLE);
    model.getShape("Dave");
    model.getShape("Vidojeeee");
    assertEquals(true, model.getShapeObject("Dave") instanceof AnimatedShape);
    assertEquals(true, model.getShapeObject("Vidojeeee") instanceof AnimatedShape);
    assertEquals(true, model.getShapeObject("Vido") instanceof AnimatedShape);
    assertEquals(true, model.getShapeObject("Dave II") instanceof AnimatedShape);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeAtFail() {
    model.addShape("Dave", ELLIPSE);
    model.fullMotion("Dave", -1, 10, 10, 10, 10, 255, 255,
            255, 3, 10, 10, 10, 10, 255, 255, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeAtFail2() {
    model.addShape("", ELLIPSE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeAtFailNull() {
    model.addShape(null, ELLIPSE);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeAtFail5() {
    model.addShape("Dave", ELLIPSE);
    model.fullMotion("Dave", 1, 10, 10, -1, 10, 255, 255,
            255, 3, 10, 10, 10, 10, 255, 255, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeAtFail6() {
    model.addShape("Dave", ELLIPSE);
    model.fullMotion("Dave", 1, 10, 10, 10, -1, 255, 255,
            255, 4, 10, 10, 10, 10, 255, 255, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeAtFail7() {
    model.addShape("Dave", ELLIPSE);
    model.fullMotion("Dave", 1, 10, 10, 10, 10, -1, 255,
            255, 10, 10, 10, 10, 10, 255, 255, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeAtFail8() {
    model.addShape("Dave", ELLIPSE);
    model.fullMotion("Dave", 1, 10, 10, 10, 10, 255, 256,
            255, 10, 10, 10, 10, 10, 255, 255, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeAtFail9() {
    model.addShape("Dave", ELLIPSE);
    model.fullMotion("Dave", 1, 10, 10, 10, 10, 255, 255,
            -1, 12, 10, 10, 10, 10, 255, 255, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeAtFail10() {
    model.addShape("Dave", ELLIPSE);
    model.fullMotion("Dave", 1, 10, 10, 0, 10, 255, 255,
            255, 2, 10, 10, 10, 10, 255, 255, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeAtFail11() {
    model.addShape("Dave", ELLIPSE);
    model.fullMotion("Dave", 3, 10, 10, 10, 0, 255, 255,
            255, 4, 10, 10, 10, 10, 255, 255, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeAtFail12() {
    model.addShape("Dave", RECTANGLE);
    model.fullMotion("Dave", 2, 10, 10, 0, 10, 255, 255,
            255, 3, 10, 10, 10, 10, 255, 255, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeAtFail13() {
    model.addShape("Dave", RECTANGLE);
    model.fullMotion("Dave", 2, 10, 10, 10, 0, 255, 255,
            255, 4, 10, 10, 10, 10, 255, 255, 255);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorToFail() {
    model.addShape("Dave", ELLIPSE);
    model.changeColorTo("Dave", 0, 0, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorToFail2() {
    model.addShape("Dave", RECTANGLE);
    model.changeColorTo("Dave", 0, 0, 0, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetShapeFail() {
    model.addShape("Dave", ELLIPSE);
    model.getShape("Vido fails this test like he fails his students every day in class");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveShapeFail() {
    model.addShape("Dave", RECTANGLE);
    model.removeShape("Vido");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveShapeFail2() {
    model.addShape("Dave", RECTANGLE);
    model.removeShape("Vido");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeSizeToFail() {
    model.addShape("Dave", RECTANGLE);
    model.changeSizeTo("Dave", -1, 5, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeSizeToFail2() {
    model.addShape("Dave", RECTANGLE);
    model.changeSizeTo("Dave", 5, -1, 9);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeSizeToFail3() {
    model.addShape("Dave", RECTANGLE);
    model.changeSizeTo("Dave", 5, -1, 9);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeSizeToFail4() {
    model.addShape("Dave", ELLIPSE);
    model.changeSizeTo("Dave", 5, 5, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeSizeToFail5() {
    model.addShape("Dave", RECTANGLE);
    model.changeSizeTo("Dave", 5, 5, -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testChangeSizeToFail6() {
    model.addShape("Dave", ELLIPSE);
    model.changeSizeTo("Vido", 5, 7, 9);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFullMotionFail() {
    model.addShape("Dave", ELLIPSE);
    model.fullMotionTo("Jake", 4, 4, 4, 4, 4, 4, 4, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDoNothingFail() {
    model.addShape("Dave", ELLIPSE);
    model.doNothing("Damn Daniel", 9);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDoNothingFail2() {
    model.addShape("Dave", RECTANGLE);
    model.doNothing("Dave", -3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFullMotionFail2() {
    model.addShape("Dave", ELLIPSE);
    model.fullMotionTo("Jake", 4, 4, 4, 4, 4, 4, 4, 4);
  }

//  @Test
//  public void testMoveTo() {
//    model.addShapeAt(1, "Dave", ELLIPSE, 10, 10, 10, 10, 255, 255, 255);
//    model.moveTo("Dave", 25, 33, 9);
//    assertEquals(model.getShape("Dave"), new EllipseState(1, 10, 10,
//            new Color(255, 255, 255), new Point2D.Double(10, 10)).toString() + "    " +
//            new EllipseState(10, 10, 10,
//                    new Color(255, 255, 255), new Point2D.Double(25, 33)).toString() + "\n");
//  }
//
//  @Test
//  public void testMoveToOffScreenLeft() {
//    model.addShapeAt(1, "Dave", ELLIPSE, 10, 10, 10, 10, 255, 255, 255);
//    model.moveTo("Dave", 25, 33, 9);
//    assertEquals(model.getShape("Dave"), new EllipseState(1, 10, 10,
//            new Color(255, 255, 255), new Point2D.Double(10, 10)).toString() + "    " +
//            new EllipseState(10, 10, 10,
//                    new Color(255, 255, 255), new Point2D.Double(25, 33)).toString() + "\n");
//  }
//
//  @Test
//  public void testMoveToOffScreenTop() {
//    model.addShapeAt(1, "Dave", ELLIPSE);
//    model.fullMotion("Dave", 1,10, 10, 10, 10, 255, 255, 255,25, -100, 9);
//    assertEquals(model.getShape("Dave"), new EllipseState(1, 10, 10,
//            new Color(255, 255, 255), new Point2D.Double(10, 10)).toString() + "    " +
//            new EllipseState(10, 10, 10,
//                    new Color(255, 255, 255), new Point2D.Double(25, -100)).toString() + "\n");
//  }

  @Test
  public void testFullMotion() {
    model.addShape("Dave", RECTANGLE);
    model.fullMotion("Dave", 1, 10, 10, 10, 10, 255, 255,
            255, 21, 3, 3, 3, 3, 0, 99, 43);
    assertEquals(model.getShape("Dave"),
            "1 10.0 10.0 10 10 255 255 255    21 3.0 3.0 3 3 0 99 43" + "\n");
  }

  @Test
  public void testFullMotion2() {
    model.addShape("Dave", ELLIPSE);
    model.fullMotion("Dave", 1, 10, 10, 10, 10, 255, 255,
            255, 5, 4, 4, 4, 4, 4, 4, 4);
    assertEquals(model.getShape("Dave"),
            "1 10.0 10.0 10 10 255 255 255    5 4.0 4.0 4 4 4 4 4" + "\n");
  }

  @Test
  public void testDoNothing() {
    model.addShape("Dave", RECTANGLE);
    model.doNothing("Dave", 1);
    assertEquals(model.getShape("Dave"),
            "0 0.0 0.0 0 0 0 0 0    1 0.0 0.0 0 0 0 0 0" + "\n");
  }

  @Test
  public void testDoNothing2() {
    model.addShape("Dave", ELLIPSE);
    model.doNothing("Dave", 33);
    assertEquals(model.getShape("Dave"),
            "0 0.0 0.0 0 0 0 0 0    33 0.0 0.0 0 0 0 0 0" + "\n");
  }
}