import org.junit.Before;
import org.junit.Test;
import cs3500.animator.controller.IAnimatorController;
import cs3500.animator.view.IView;
import cs3500.animator.view.TestView;
import java.io.BufferedReader;
import java.io.StringReader;
import cs3500.animator.controller.TestController;
import static org.junit.Assert.assertEquals;


public class TestControllerTest {
  Appendable appendable;
  IView testView;
  IAnimatorController testController;
  
  @Before
  public void setup() {
    appendable = new StringBuilder();
    testController = new TestController(testView, appendable);
  }
  
  
  @Test
  public void testPlay() {
    testView = new TestView(new StringReader("Play"));
    testView.drawShapes(null);
    assertEquals("play", appendable.toString());
  }
  
  @Test
  public void testPause() {
    testView = new TestView(new StringReader("Pause"));
    testView.addListner(testController);
    testView.drawShapes(null);
    assertEquals("pause", appendable.toString());
  }
  
  @Test
  public void testRestart() {
    testView = new TestView(new StringReader("Restart"));
    testView.addListner(testController);
    testView.drawShapes(null);
    assertEquals("restart", appendable.toString());
  }
  
  @Test
  public void testLoop() {
    testView = new TestView(new StringReader("Loop"));
    testView.addListner(testController);
    testView.drawShapes(null);
    assertEquals("loop", appendable.toString());
  }
  
  @Test
  public void testUpdateSpeed() {
    testView = new TestView(new StringReader("Speed"));
    testView.addListner(testController);
    testView.drawShapes(null);
    assertEquals("new speed: 50", appendable.toString());
  }
  
  @Test
  public void testAddShape() {
    testView = new TestView(new StringReader("AddShape"));
    testView.addListner(testController);
    testView.drawShapes(null);
    assertEquals("new shape: Test Success", appendable.toString());
  }
  
  @Test
  public void testRemoveShape() {
    testView = new TestView(new StringReader("RemoveShape"));
    testView.addListner(testController);
    testView.drawShapes(null);
    assertEquals("Test Success shape removed", appendable.toString());
  }
  
  @Test
  public void testAddKeyFrame() {
    testView = new TestView(new StringReader("AddKeyframe"));
    testView.addListner(testController);
    testView.drawShapes(null);
    assertEquals("new key frame to shape Test Success at tick 0", appendable.toString());
  }
  
  @Test
  public void testEditKeyFrame() {
    testView = new TestView(new StringReader("EditKeyframe"));
    testView.addListner(testController);
    testView.drawShapes(null);
    assertEquals("key frame edited for shape Test Success", appendable.toString());
  }
  
  @Test
  public void testRemoveKeyFrame() {
    testView = new TestView(new StringReader("RemoveKeyframe"));
    testView.addListner(testController);
    testView.drawShapes(null);
    assertEquals("key frame removed from shape Test Success", appendable.toString());
  }
}