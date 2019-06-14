import static cs3500.animator.model.ShapeType.ELLIPSE;
import static cs3500.animator.model.ShapeType.RECTANGLE;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cs3500.animator.model.IModel;
import cs3500.animator.model.Model;
import cs3500.animator.view.IView;
import cs3500.animator.view.SVGView;

/**
 * tests the svg formatted view of {@code SVGView}.
 */
public class SVGViewTest {

  IView v1;
  IModel m1;

  @Before
  public void setUp() {
    v1 = new SVGView(30);
    m1 = new Model();
  }

  @Test
  public void testPrintView3() {
    assertEquals("<svg width=\"500\" height\"500\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "</svg>\n", v1.formatSVG(m1));
  }

  @Test
  public void testPrintView2() {
    m1.addShapeAt(1, "Dave", RECTANGLE, 10, 10, 10, 10, 255, 255, 255);
    m1.addShapeAt(4, "Rich II", ELLIPSE, 20, 30, 20, 2, 3, 30, 57);
    assertEquals("", v1.formatSVG(m1));
  }

  @Test
  public void testPrintView() {
    m1.addShapeAt(1, "Dave", RECTANGLE, 10, 10, 10, 10, 255, 255, 255);
    m1.addShapeAt(4, "Rich II", ELLIPSE, 20, 30, 20, 2, 3, 30, 57);
    m1.fullMotionTo("Dave", 4, 4, 4, 4, 4, 4, 4, 4);
    m1.fullMotionTo("Rich II", 20, 300, 300, 12, 72, 200, 200, 200);
    m1.fullMotionTo("Dave", 2, 76, 30, 30, 23, 199, 67, 255);
    assertEquals("<svg width=\"500\" height\"500\" version=\"1.1\" xmlns=\"http://" +
            "www.w3.org/2000/svg\"><rect id=\"Dave\" x=\"10.0\"  y=\"10.0\" width=\"10\" he" +
            "ight=\"10\" fill=\"rgb(255,255,255)\" visibility=\"visible\" ><animate attrib" +
            "utesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill\" from=\"rgb(" +
            "255,255,255)\" to=\"rgb(255,255,255)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"x\" " +
            "from=\"10.0\" to=\"4.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"y\" " +
            "from=\"10.0\" to=\"4.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"width" +
            "\" from=\"10\" to=\"4\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"heigh" +
            "t\" from=\"10\" to=\"4\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill\"" +
            " from=\"rgb(4,4,4)\" to=\"rgb(255,255,255)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"x\" fr" +
            "om=\"4.0\" to=\"76.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"y\" fr" +
            "om=\"4.0\" to=\"30.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"width\"" +
            " from=\"4\" to=\"23\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"height" +
            "\" from=\"4\" to=\"30\" fill=\"freeze\" />\n" +
            "</rect>\n" +
            "<ellipse id=\"Rich II\" cx=\"20.0\"  cy=\"30.0\" rx=\"10\" ry=\"1\" fill=\"rgb(3," +
            "30,57)\" visibility=\"visible\" ><animate attributesType=\"xml\" begin=\"0ms\" du" +
            "r=\"0ms\" attributeName=\"fill\" from=\"rgb(3,30,57)\" to=\"rgb(3,30,57)\" fill=\"" +
            "freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cx\" fr" +
            "om=\"20.0\" to=\"300.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cy\" fr" +
            "om=\"30.0\" to=\"300.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"rx\" fr" +
            "om=\"10\" to=\"36\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"ry\" fr" +
            "om=\"1\" to=\"6\" fill=\"freeze\" />\n" +
            "</ellipse>\n" +
            "\n" +
            "</svg>\n", v1.formatSVG(m1));
  }

  @Test
  public void testPrintViewBasedOnWhenInstantiated() {
    m1.addShapeAt(1, "Dave", RECTANGLE, 10, 10, 10, 10, 255, 255, 255);
    m1.addShapeAt(10, "Adam", ELLIPSE, 20, 30, 20, 2, 3, 30, 57);
    m1.addShapeAt(5, "Daniel", RECTANGLE, 30, 30, 10, 10, 30, 78, 180);
    m1.addShapeAt(3, "Vido", ELLIPSE, 200, 200, 1, 1, 0, 0, 0);
    m1.fullMotionTo("Dave", 4, 4, 4, 4, 4, 4, 4, 4);
    m1.fullMotionTo("Vido", 20, 250, 250, 23, 34, 90, 36, 78);
    m1.fullMotionTo("Adam", 20, 300, 300, 12, 72, 200, 200, 200);
    m1.fullMotionTo("Dave", 2, 76, 30, 30, 23, 199, 67, 255);
    m1.fullMotionTo("Daniel", 17, 100, 100, 100, 100, 0, 13, 255);
    assertEquals("<svg width=\"500\" height\"500\" version=\"1.1\" xmlns=\"http://www." +
            "w3.org/2000/svg\"><rect id=\"Dave\" x=\"10.0\"  y=\"10.0\" width=\"10\" height=\"" +
            "10\" fill=\"rgb(255,255,255)\" visibility=\"visible\" ><animate attributesType=\"" +
            "xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill\" from=\"rgb(255,255,255)\"" +
            " to=\"rgb(255,255,255)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"x\" fr" +
            "om=\"10.0\" to=\"4.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"y\" fr" +
            "om=\"10.0\" to=\"4.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"width\"" +
            " from=\"10\" to=\"4\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"height\"" +
            " from=\"10\" to=\"4\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill\"" +
            " from=\"rgb(4,4,4)\" to=\"rgb(255,255,255)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"x\" " +
            "from=\"4.0\" to=\"76.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"y\" " +
            "from=\"4.0\" to=\"30.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"width\" " +
            "from=\"4\" to=\"23\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"hei" +
            "ght\" from=\"4\" to=\"30\" fill=\"freeze\" />\n" +
            "</rect>\n" +
            "<ellipse id=\"Vido\" cx=\"200.0\"  cy=\"200.0\" rx=\"0\" ry=\"0\" fill=\"" +
            "rgb(0,0,0)\" visibility=\"visible\" ><animate attributesType=\"xml\" begi" +
            "n=\"0ms\" dur=\"0ms\" attributeName=\"fill\" from=\"rgb(0,0,0)\" to=\"rgb(" +
            "0,0,0)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cx\"" +
            " from=\"200.0\" to=\"250.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cy\"" +
            " from=\"200.0\" to=\"250.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"rx\"" +
            " from=\"0\" to=\"17\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"ry\"" +
            " from=\"0\" to=\"11\" fill=\"freeze\" />\n" +
            "</ellipse>\n" +
            "<rect id=\"Daniel\" x=\"30.0\"  y=\"30.0\" width=\"10\" height=\"10\" fill=\"" +
            "rgb(30,78,180)\" visibility=\"visible\" ><animate attributesType=\"xml\" begi" +
            "n=\"0ms\" dur=\"0ms\" attributeName=\"fill\" from=\"rgb(30,78,180)\" to=\"rgb" +
            "(30,78,180)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"x\" " +
            "from=\"30.0\" to=\"100.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"y\" " +
            "from=\"30.0\" to=\"100.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"width\"" +
            " from=\"10\" to=\"100\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"height\"" +
            " from=\"10\" to=\"100\" fill=\"freeze\" />\n" +
            "</rect>\n" +
            "<ellipse id=\"Adam\" cx=\"20.0\"  cy=\"30.0\" rx=\"10\" ry=\"1\" fill=\"rgb(3" +
            ",30,57)\" visibility=\"visible\" ><animate attributesType=\"xml\" begin=\"" +
            "0ms\" dur=\"0ms\" attributeName=\"fill\" from=\"rgb(3,30,57)\" to=\"rgb(3,3" +
            "" +
            "0,57)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"c" +
            "x\" from=\"20.0\" to=\"300.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cy\"" +
            " from=\"30.0\" to=\"300.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"rx\" " +
            "from=\"10\" to=\"36\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"ry\" " +
            "from=\"1\" to=\"6\" fill=\"freeze\" />\n" +
            "</ellipse>\n" +
            "\n" +
            "</svg>\n", v1.formatSVG(m1));
  }

  @Test
  public void testPrintViewAlphabetically() {
    m1.addShapeAt(3, "Dave", RECTANGLE, 10, 10, 10, 10, 255, 255, 255);
    m1.addShapeAt(3, "Adam", ELLIPSE, 20, 30, 20, 2, 3, 30, 57);
    m1.addShapeAt(3, "Daniel", RECTANGLE, 30, 30, 10, 10, 30, 78, 180);
    m1.addShapeAt(3, "Vido", ELLIPSE, 200, 200, 1, 1, 0, 0, 0);
    m1.fullMotionTo("Dave", 4, 4, 4, 4, 4, 4, 4, 4);
    m1.fullMotionTo("Vido", 20, 250, 250, 23, 34, 90, 36, 78);
    m1.fullMotionTo("Adam", 20, 300, 300, 12, 72, 200, 200, 200);
    m1.fullMotionTo("Dave", 2, 76, 30, 30, 23, 199, 67, 255);
    m1.fullMotionTo("Daniel", 17, 100, 100, 100, 100, 0, 13, 255);
    assertEquals("<svg width=\"500\" height\"500\" version=\"1.1\" xmlns=\"http:/" +
            "/www.w3.org/2000/svg\"><ellipse id=\"Adam\" cx=\"20.0\"  cy=\"30.0\" rx=\"10" +
            "\" ry=\"1\" fill=\"rgb(3,30,57)\" visibility=\"visible\" ><animate attribute" +
            "sType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill\" from=\"rgb(3,3" +
            "0,57)\" to=\"rgb(3,30,57)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cx\"" +
            " from=\"20.0\" to=\"300.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cy\"" +
            " from=\"30.0\" to=\"300.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"rx\" " +
            "from=\"10\" to=\"36\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"ry\" " +
            "from=\"1\" to=\"6\" fill=\"freeze\" />\n" +
            "</ellipse>\n" +
            "<rect id=\"Daniel\" x=\"30.0\"  y=\"30.0\" width=\"10\" height=\"10\" fill=\"r" +
            "gb(30,78,180)\" visibility=\"visible\" ><animate attributesType=\"xml\" begin=" +
            "\"0ms\" dur=\"0ms\" attributeName=\"fill\" from=\"rgb(30,78,180)\" to=\"rgb(30," +
            "78,180)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"x\" f" +
            "rom=\"30.0\" to=\"100.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"y\" " +
            "from=\"30.0\" to=\"100.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"width\"" +
            " from=\"10\" to=\"100\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"height\"" +
            " from=\"10\" to=\"100\" fill=\"freeze\" />\n" +
            "</rect>\n" +
            "<rect id=\"Dave\" x=\"10.0\"  y=\"10.0\" width=\"10\" height=\"10\" fill=\"rgb(2" +
            "55,255,255)\" visibility=\"visible\" ><animate attributesType=\"xml\" begin=\"0m" +
            "s\" dur=\"0ms\" attributeName=\"fill\" from=\"rgb(255,255,255)\" to=\"rgb(255,25" +
            "5,255)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"x\" fr" +
            "om=\"10.0\" to=\"4.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"y\" fr" +
            "om=\"10.0\" to=\"4.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"width\"" +
            " from=\"10\" to=\"4\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"height\"" +
            " from=\"10\" to=\"4\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill" +
            "\" from=\"rgb(4,4,4)\" to=\"rgb(255,255,255)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"x\" " +
            "from=\"4.0\" to=\"76.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"y\" " +
            "from=\"4.0\" to=\"30.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"widt" +
            "h\" from=\"4\" to=\"23\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"heigh" +
            "t\" from=\"4\" to=\"30\" fill=\"freeze\" />\n" +
            "</rect>\n" +
            "<ellipse id=\"Vido\" cx=\"200.0\"  cy=\"200.0\" rx=\"0\" ry=\"0\" fill=\"rgb(" +
            "0,0,0)\" visibility=\"visible\" ><animate attributesType=\"xml\" begin=\"0ms\"" +
            " dur=\"0ms\" attributeName=\"fill\" from=\"rgb(0,0,0)\" to=\"rgb(0,0,0)\" fill=" +
            "\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cx\"" +
            " from=\"200.0\" to=\"250.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cy\"" +
            " from=\"200.0\" to=\"250.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"rx\"" +
            " from=\"0\" to=\"17\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"ry\" " +
            "from=\"0\" to=\"11\" fill=\"freeze\" />\n" +
            "</ellipse>\n" +
            "\n" +
            "</svg>\n", v1.formatSVG(m1));
  }
}
