import org.junit.Before;
import org.junit.Test;

import cs3500.easyanimator.model.IModel;
import cs3500.easyanimator.model.Model;

import static cs3500.easyanimator.model.ShapeType.*;

public class ModelTest {

  IModel model;

  @Before
  public void setUp() {
    model = new Model();
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

  @Test
  public void testRemoveShape() {

  }



}