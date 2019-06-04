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
    model.addShape("Dave", ShapeType.ELLIPSE, 10, 10, 60, 60, 255, 255, 255);
    model.addMotion("Dave", 0, 50, 10, 10, 10, 10, 60, 60, 60, 60, 255, 0, 255, 0, 255, 0);
    assertEquals("", model.printHistory());
  }
  
}
