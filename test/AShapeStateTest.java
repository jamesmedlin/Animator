import org.junit.Before;
import org.junit.Test;
import java.awt.geom.Point2D;
import cs3500.easyanimator.model.Color;
import cs3500.easyanimator.model.EllipseState;
import cs3500.easyanimator.model.IReadOnlyShapeState;
import cs3500.easyanimator.model.IShapeState;
import cs3500.easyanimator.model.RectangleState;

import static org.junit.Assert.assertEquals;

/**
 * tests the abstracted methods of {@code AShapeState} for getters and setters.
 */
public class AShapeStateTest {

  IShapeState shapeState;
  IShapeState shapeState2;
  IReadOnlyShapeState readOnly;
  IReadOnlyShapeState readOnly2;

  @Before
  public void setUp() {
    shapeState = new RectangleState(4,4,4,new Color(255,255,255),
            new Point2D.Double(100,100));
    shapeState2 = new EllipseState(4,4,4,new Color(1,10,100),
            new Point2D.Double(100,100));
    readOnly = new RectangleState(5,5,5,new Color(55,155,255),
            new Point2D.Double(100,100));
    readOnly2 = new EllipseState(10,10,10,new Color(10,10,10),
            new Point2D.Double(10,10));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructor1() {
    new RectangleState(-1,2,2, new Color(0,0,0), new Point2D.Double(0,0));
  }
  @Test (expected = IllegalArgumentException.class)
  public void testConstructor2() {
    new RectangleState(1,-7,2, new Color(0,0,0), new Point2D.Double(0,0));
  }
  @Test (expected = IllegalArgumentException.class)
  public void testConstructor3() {
    new RectangleState(0,2,-4, new Color(0,0,0), new Point2D.Double(0,0));
  }
  @Test (expected = IllegalArgumentException.class)
  public void testConstructor7() {
    new RectangleState(0,2,2, new Color(0,0,0), null);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructor4() {
    new EllipseState(-1,2,2, new Color(0,0,0), new Point2D.Double(0,0));
  }
  @Test (expected = IllegalArgumentException.class)
  public void testConstructor5() {
    new EllipseState(1,-7,2, new Color(0,0,0), new Point2D.Double(0,0));
  }
  @Test (expected = IllegalArgumentException.class)
  public void testConstructor6() {
    new EllipseState(0,2,-4, new Color(0,0,0), new Point2D.Double(0,0));
  }
  @Test (expected = IllegalArgumentException.class)
  public void testConstructor8() {
    new EllipseState(0,2,2, new Color(0,0,0), null);
  }

  @Test
  public void testGetWidth() {
    assertEquals(readOnly.getWidth(), 5);
  }
  @Test
  public void testGetHeight() {
    assertEquals(readOnly.getHeight(), 5);
  }
  @Test
  public void testGetColor() {
    assertEquals(readOnly.getColor().getRed(), 55);
    assertEquals(readOnly.getColor().getGreen(), 155);
    assertEquals(readOnly.getColor().getBlue(), 255);
  }
  @Test
  public void testGetPosition() {
    assertEquals(readOnly.getPosition(), new Point2D.Double(100,100));
  }

  @Test
  public void testGetWidth2() {
    assertEquals(readOnly2.getWidth(), 10);
  }
  @Test
  public void testGetHeight2() {
    assertEquals(readOnly2.getHeight(), 10);
  }
  @Test
  public void testGetColor2() {
    assertEquals(readOnly2.getColor().getRed(), 10);
    assertEquals(readOnly2.getColor().getGreen(), 10);
    assertEquals(readOnly2.getColor().getBlue(), 10);
  }
  @Test
  public void testGetPosition2() {
    assertEquals(readOnly2.getPosition(), new Point2D.Double(10,10));
  }

  @Test
  public void testSetWidth() {
    shapeState.setWidth(1000);
    assertEquals(shapeState.getWidth(), 1000);
  }
  @Test
  public void testSetHeight() {
    shapeState.setHeight(2000);
    assertEquals(shapeState.getHeight(), 2000);
  }
  @Test
  public void testSetColor() {
    shapeState.setColor(55,66,77);
    assertEquals(shapeState.getColor().getRed(), 55);
    assertEquals(shapeState.getColor().getGreen(), 66);
    assertEquals(shapeState.getColor().getBlue(), 77);
  }
  @Test
  public void testSetPosition() {
    shapeState.setPosition(99,88);
    assertEquals(shapeState.getPosition().getX(), 99, 0.01);
    assertEquals(shapeState.getPosition().getY(), 88,0.01);
  }

  @Test
  public void testSetWidth2() {
    shapeState2.setWidth(1000);
    assertEquals(shapeState2.getWidth(), 1000);
  }
  @Test
  public void testSetHeight2() {
    shapeState2.setHeight(2000);
    assertEquals(shapeState2.getHeight(), 2000);
  }
  @Test
  public void testSetColor2() {
    shapeState2.setColor(155,166,177);
    assertEquals(shapeState2.getColor().getRed(), 155);
    assertEquals(shapeState2.getColor().getGreen(), 166);
    assertEquals(shapeState2.getColor().getBlue(), 177);
  }
  @Test
  public void testSetPosition2() {
    shapeState2.setPosition(99,88);
    assertEquals(shapeState2.getPosition(), new Point2D.Double(99,88));
  }

}
