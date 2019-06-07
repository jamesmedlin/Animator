import static org.junit.Assert.assertEquals;
import java.awt.geom.Point2D;
import org.junit.Before;
import org.junit.Test;
import cs3500.easyanimator.model.AnimatedShape;
import cs3500.easyanimator.model.Color;
import cs3500.easyanimator.model.EllipseState;
import cs3500.easyanimator.model.IAnimatedShape;
import cs3500.easyanimator.model.RectangleState;
import cs3500.easyanimator.model.ShapeType;

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
  
  @Test
  public void testGetMotions() {
    assertEquals("", animatedRectangle.getMotions());
    assertEquals("", animatedEllipse.getMotions());
    animatedRectangle.addDoNothing(15);
    assertEquals("0 0.0 0.0 50 50 255 255 255    15 0.0 0.0 50 50 255 255 255\n",
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
  public void testBadColor() {
    animatedRectangle.changeColor(new Color(257, 3, 2), 3);
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
  
}
