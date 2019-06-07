import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

import cs3500.easyanimator.model.AShapeState;
import cs3500.easyanimator.model.Color;
import cs3500.easyanimator.model.EllipseState;
import cs3500.easyanimator.model.IModel;
import cs3500.easyanimator.model.IReadOnlyShapeState;
import cs3500.easyanimator.model.IShapeState;
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
    model.addShapeAt(0,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.removeShape("Dave");
    assertEquals(model.getShapesAtTick(0).toString(), new ArrayList<>().toString());
  }

//  @Test
//  public void testRemoveShape2() {
//    model.addShapeAt(0,"Dave", ELLIPSE,10,10,10,10,255,255,255);
//    model.addShapeAt(0,"Vido", RECTANGLE,10,10,10,10,0,0,0);
//    model.removeShape("Vido");
//    int i = model.getShapesAtTick(0).size();
//    assertEquals(model.getShapesAtTick(0).size(), 1);
//    assertEquals(model.getShapesAtTick(1).get(0).toString(),
//            new EllipseState(1,10,10,
//                    new Color(255,255,255),
//                    new Point2D.Double(10,10)).toString());
//  }

  @Test
  public void testChangeColorTo() {
    model.addShapeAt(1,"Dave", ELLIPSE,10,10,10,10,255,255,255);
    model.changeColorTo("Dave", 0,0,0, 2);
    assertEquals(model.getShapesAtTick(1).get(0).toString(), new EllipseState(1,10,10,
            new Color(255,255,255), new Point2D.Double(10,10)).toString());
    assertEquals(model.getShapesAtTick(3).get(0).toString(), new EllipseState(1,10,10,
            new Color(0,0,0), new Point2D.Double(10,10)).toString());
  }



}