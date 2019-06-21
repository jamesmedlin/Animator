import org.junit.Before;
import org.junit.Test;
import cs3500.animator.controller.IAnimatorController;
import cs3500.animator.controller.VisualController;
import cs3500.animator.model.IModel;
import cs3500.animator.model.TestModel;
import cs3500.animator.view.IView;
import cs3500.animator.view.TestView;
import java.io.StringReader;

import static org.junit.Assert.*;


public class ControllerToModelTest {
  Appendable appendable;
  IView testView;
  IModel testModel;
  IAnimatorController controller;

  @Before
  public void setUp() {
    appendable = new StringBuilder();
    testModel = new TestModel(appendable);
  }
  
  @Test
  public void testAddShape() {
    this.testView = new TestView(new StringReader("AddShape"));
    controller = new VisualController(testModel, testView, 50);
    testView.drawShapes(null);
    assertEquals("Shape Test Success added into model", appendable.toString());
  }
  
  @Test
  public void testRemoveShape() {
    this.testView = new TestView(new StringReader("RemoveShape"));
    controller = new VisualController(testModel, testView, 50);
    testView.drawShapes(null);
    assertEquals("Shape Test Success removed from model", appendable.toString());
  }
  
  @Test
  public void testAddKeyFrame() {
    this.testView = new TestView(new StringReader("AddKeyframe"));
    controller = new VisualController(testModel, testView, 50);
    testView.drawShapes(null);
    assertEquals("Key frame added to Test Success in model", appendable.toString());
  }
  
  @Test
  public void testEditKeyFrame() {
    this.testView = new TestView(new StringReader("EditKeyframe"));
    controller = new VisualController(testModel, testView, 50);
    testView.drawShapes(null);
    assertEquals("Key frame edited in Test Success in model", appendable.toString());
  }
  
  @Test
  public void testRemoveKeyFrame() {
    this.testView = new TestView(new StringReader("RemoveKeyframe"));
    controller = new VisualController(testModel, testView, 50);
    testView.drawShapes(null);
    assertEquals("Key frame removed from Test Success in model", appendable.toString());
  }
}