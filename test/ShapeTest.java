import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import cs3500.easyanimator.model.AnimatedShape;
import cs3500.easyanimator.model.IAnimatedShape;
import cs3500.easyanimator.model.IModel;
import cs3500.easyanimator.model.Model;
import cs3500.easyanimator.model.ShapeType;

public class ShapeTest {

  IModel model;
  
  
  @Before
  public void setUp() {
    model = new Model();
    model.addShapeAt(0, "Dave", ShapeType.ELLIPSE, 50, 50, 100, 100, 255, 255, 255);
    model.addShapeAt(6, "Sandy", ShapeType.RECTANGLE, 25, 75, 33, 33, 0, 0, 0);
  }
  
  @Test
  public void testPrint() {
    model.addShapeAt(1, "Dave", ShapeType.ELLIPSE, 10, 10, 60, 60, 255, 255, 255);
    assertEquals("", model.printHistory());
  }
  
}
