import static org.junit.Assert.assertEquals;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import cs3500.easyanimator.model.AnimatedShape;
import cs3500.easyanimator.model.Color;
import cs3500.easyanimator.model.EllipseState;
import cs3500.easyanimator.model.IAnimatedShape;
import cs3500.easyanimator.model.IReadOnlyShapeState;
import cs3500.easyanimator.model.RectangleState;
import cs3500.easyanimator.model.ShapeType;

/**
 * Tests the functionality of the {@code AnimatedShape} class implementation.
 */
public class ShapeTest {

  IAnimatedShape animatedRectangle;
  IAnimatedShape animatedEllipse;
  
  @Before
  public void setUp() {
    animatedRectangle = new AnimatedShape(
        ShapeType.RECTANGLE,
        new RectangleState(0, 50, 50, new Color(255, 255, 255), new Point2D.Double(0,0)));
    animatedEllipse = new AnimatedShape(
        ShapeType.ELLIPSE,
        new EllipseState(6, 25, 35, new Color(0, 0, 0), new Point2D.Double(40, 30)));
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testNullConstructor1() {
    IAnimatedShape badShape =
        new AnimatedShape(
            null, new EllipseState(6, 25, 35, new Color(0, 0, 0), new Point2D.Double(40, 30)));
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testNullConstructor2() {
    IAnimatedShape badShape =
        new AnimatedShape(
            ShapeType.ELLIPSE, null);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testNullConstructor3() {
    IAnimatedShape badShape =
        new AnimatedShape(
            ShapeType.ELLIPSE,
            new RectangleState(0, 50, 50, new Color(255, 255, 255), new Point2D.Double(0,0)),
            null);
  }
  
  @Test
  public void testGetMotions() {
    assertEquals("", animatedRectangle.getMotions());
    assertEquals("", animatedEllipse.getMotions());
    animatedRectangle.addDoNothing(15);
    assertEquals("0 0.0 0.0 50 50 255 255 255    15 0.0 0.0 50 50 255 255 255\n",
        animatedRectangle.getMotions());
    animatedRectangle.addDoNothing(10);
    assertEquals("0 0.0 0.0 50 50 255 255 255    15 0.0 0.0 50 50 255 255 255\n"
        + "15 0.0 0.0 50 50 255 255 255    25 0.0 0.0 50 50 255 255 255\n",
        animatedRectangle.getMotions());
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testNegativeDuration() {
    animatedRectangle.addDoNothing(-2);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testNegativeDuration2() {
    animatedEllipse.changeColor(new Color(5, 5, 5), -5);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testNegativeDuration3() {
    animatedEllipse.moveTo(new Point2D.Double(0, 0), 0);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testNegativeDuration4() {
    animatedEllipse.changeSizeTo(23, 23, -1);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testNegativeDuration5() {
    animatedRectangle.fullMotionTo(new Point2D.Double(0, 0), 3, 4, new Color(0, 0, 0), -3);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testBadColorColor() {
    animatedRectangle.changeColor(new Color(257, 3, 2), 3);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testBadColorFull() {
    animatedEllipse.fullMotionTo(new Point2D.Double(-2, 3), 3, 3, new Color(-2, 0, 0), 32);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testBadSizeSize() {
    animatedRectangle.changeSizeTo(0, 0, 11);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testBadSizeFull() {
    animatedEllipse.fullMotionTo(new Point2D.Double(-2, 3), 0, 0, new Color(0, 0, 0), 32);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testNullColorColor() {
    animatedEllipse.changeColor(null, 1);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testNullColorFull() {
    animatedEllipse.fullMotionTo(new Point2D.Double(0, 0), 3, 4, null, 32);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testNullPosMove() {
    animatedRectangle.moveTo(null, 31);
  }
  
  @Test (expected = IllegalArgumentException.class)
  public void testNullPosFull() {
    animatedEllipse.fullMotionTo(null, 3, 4, new Color(0, 0, 0), 32);
  }

  @Test
  public void testGetStates() {
    assertEquals(true, animatedRectangle.getStates().isEmpty());
    assertEquals(true, animatedEllipse.getStates().isEmpty());
    animatedRectangle.changeColor(new Color(0, 0, 0), 23);
    animatedEllipse.changeColor(new Color(255, 255, 255), 13);
    for (IReadOnlyShapeState state : animatedRectangle.getStates()) {
      assertEquals(true, state instanceof RectangleState);
      assertEquals(true, animatedRectangle.getStates().size() % 2 == 0);
    }
    for (IReadOnlyShapeState state : animatedEllipse.getStates()) {
      assertEquals(true, state instanceof EllipseState);
      assertEquals(true, animatedEllipse.getStates().size() % 2 == 0);
    }
    animatedRectangle.addDoNothing(43);
    animatedEllipse.changeSizeTo(2, 3, 42);
    for (IReadOnlyShapeState state : animatedRectangle.getStates()) {
      assertEquals(true, state instanceof RectangleState);
      assertEquals(true, animatedRectangle.getStates().size() % 2 == 0);
    }
    for (IReadOnlyShapeState state : animatedEllipse.getStates()) {
      assertEquals(true, state instanceof EllipseState);
      assertEquals(true, animatedEllipse.getStates().size() % 2 == 0);
    }
  }
  
  @Test
  public void testFullMotionToRectangle() {
    assertEquals(true, animatedRectangle.getStates().isEmpty());
    animatedRectangle.fullMotionTo(new Point2D.Double(25, 25), 55, 25, new Color(255, 0, 0), 20);
    assertEquals(2, animatedRectangle.getStates().size());
    assertEquals("0 0.0 0.0 50 50 255 255 255    20 25.0 25.0 25 55 255 0 0\n",
        animatedRectangle.getMotions());
  }
  
  @Test
  public void testFullMotionToEllipse() {
    assertEquals(true, animatedEllipse.getStates().isEmpty());
    animatedEllipse.fullMotionTo(new Point2D.Double(25, 25), 55, 25, new Color(255, 0, 0), 20);
    assertEquals(2, animatedEllipse.getStates().size());
    assertEquals("6 40.0 30.0 25 35 0 0 0    26 25.0 25.0 25 55 255 0 0\n",
        animatedEllipse.getMotions());
  }
  
  @Test
  public void testChangeColorRectangle() {
    assertEquals(true, animatedRectangle.getStates().isEmpty());
    animatedRectangle.changeColor(new Color(255, 231, 241), 23);
    assertEquals(2, animatedRectangle.getStates().size());
    assertEquals("0 0.0 0.0 50 50 255 255 255    23 0.0 0.0 50 50 255 231 241\n",
        animatedRectangle.getMotions());
  }
  
  @Test
  public void testChangeColorEllipse() {
    assertEquals(true, animatedEllipse.getStates().isEmpty());
    animatedEllipse.changeColor(new Color(255, 231, 241), 23);
    assertEquals(2, animatedEllipse.getStates().size());
    assertEquals("6 40.0 30.0 25 35 0 0 0    29 40.0 30.0 25 35 255 231 241\n",
        animatedEllipse.getMotions());
  }
  
  @Test
  public void testMoveToRectangle() {
    assertEquals(true, animatedRectangle.getStates().isEmpty());
    animatedRectangle.moveTo(new Point2D.Double(23.5, 21.25), 43);
    assertEquals(2, animatedRectangle.getStates().size());
    assertEquals("0 0.0 0.0 50 50 255 255 255    43 23.5 21.25 50 50 255 255 255\n",
        animatedRectangle.getMotions());
  }
  
  @Test
  public void testMoveToEllipse() {
    assertEquals(true, animatedEllipse.getStates().isEmpty());
    animatedEllipse.moveTo(new Point2D.Double(69, 420), 12);
    assertEquals(2, animatedEllipse.getStates().size());
    assertEquals("6 40.0 30.0 25 35 0 0 0    18 69.0 420.0 25 35 0 0 0\n",
        animatedEllipse.getMotions());
  }
  
  @Test
  public void testChangeSizeRectangle() {
    assertEquals(true, animatedRectangle.getStates().isEmpty());
    animatedRectangle.changeSizeTo(1, 1, 1);
    assertEquals(2, animatedRectangle.getStates().size());
    assertEquals("0 0.0 0.0 50 50 255 255 255    1 0.0 0.0 1 1 255 255 255\n",
        animatedRectangle.getMotions());
  }
  
  @Test
  public void testChangeSizeEllipse() {
    assertEquals(true, animatedEllipse.getStates().isEmpty());
    animatedEllipse.changeSizeTo(32, 21, 11);
    assertEquals(2, animatedEllipse.getStates().size());
    assertEquals("6 40.0 30.0 25 35 0 0 0    17 40.0 30.0 21 32 0 0 0\n",
        animatedEllipse.getMotions());
  }
  
  @Test
  public void testDoNothingRectangle() {
    assertEquals(true, animatedRectangle.getStates().isEmpty());
    animatedRectangle.addDoNothing(15);
    assertEquals(2, animatedRectangle.getStates().size());
    assertEquals("0 0.0 0.0 50 50 255 255 255    15 0.0 0.0 50 50 255 255 255\n",
        animatedRectangle.getMotions());
  }
  
  @Test
  public void testDoNothingEllipse() {
    assertEquals(true, animatedEllipse.getStates().isEmpty());
    animatedEllipse.addDoNothing(89);
    assertEquals(2, animatedEllipse.getStates().size());
    assertEquals("6 40.0 30.0 25 35 0 0 0    95 40.0 30.0 25 35 0 0 0\n",
        animatedEllipse.getMotions());
  }
  
  /**
   * Tests that end states of one motion match the start times of the next and that there are
   * no gaps in the ticks of the motions.
   */
  @Test
  public void testGoodMotionTransition() {
    animatedRectangle.addDoNothing(5);
    animatedRectangle.changeColor(new Color(0, 0, 0), 10);
    animatedRectangle.changeSizeTo(50, 40, 12);
    animatedRectangle.moveTo(new Point2D.Double(33, 33), 10);
    animatedRectangle.fullMotionTo(new Point2D.Double(44, 44), 23, 42, new Color(255, 0, 0), 23);
    ArrayList<IReadOnlyShapeState> states =
        (ArrayList<IReadOnlyShapeState>) this.animatedRectangle.getStates();
    for (int i = 1; i < states.size() - 1; i += 2) {
      assertEquals(states.get(i).toString(), states.get(i + 1).toString());
    }
  }
  
}
