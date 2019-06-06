import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import cs3500.easyanimator.model.IModel;
import cs3500.easyanimator.model.Model;
import cs3500.easyanimator.model.ShapeType;

public class ShapeTest {

  IModel model;
  
  @Before
  public void setUp() {
    model = new Model();
    
  }
  
  @Test
  public void testPrint() {
    model.addShapeAt(1, "Dave", ShapeType.ELLIPSE, 10, 10, 60, 60, 255, 255, 255);
    model.addFullMotion("Dave", 1, 50, 10, 10, 10, 10, 60, 60, 60, 60, 255, 0, 255, 0, 255, 0);
    model.addFullMotion("Dave", 3, 52, 10, 10, 10, 10, 60, 60, 60, 60, 255, 0, 255, 0, 255, 0);
    assertEquals("", model.printHistory());
  }
  
}
