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

  @Test(expected = UnsupportedOperationException.class)
  public void testFail() {
    v1.render();
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testFail2() {
    v1.printView(m1);
  }

  @Test
  public void testPrintView3() {
    assertEquals("<svg width=\"500\" height\"500\" version=\"1.1\" " +
            "xmlns=\"http://www.w3.org/2000/svg\">\n" +
            "\n</svg>\n", v1.formatSVG(m1));
  }

  @Test
  public void testPrintView2() {
    m1.addShape("Dave", RECTANGLE);
    m1.addShape("Rich II", ELLIPSE);
    assertEquals("<svg width=\"500\" height\"500\" version=\"1.1\" xmlns=\"http://" +
            "www.w3.org/2000/svg\">\n" +
            "<rect id=\"Dave\">\n" +
            "</rect>\n" +
            "<ellipse id=\"Rich II\">\n" +
            "</ellipse>\n" +
            "\n" +
            "</svg>\n", v1.formatSVG(m1));
  }

  @Test
  public void testPrintView() {
    m1.addShape("Dave", RECTANGLE);
    m1.addShape("Rich II", ELLIPSE);
    m1.fullMotion("Dave", 1, 10, 10, 10, 10, 255, 255, 255,
            4, 4, 4, 4, 4, 4, 4, 4);
    m1.fullMotion("Rich II", 1, 20, 30, 20, 2, 3, 30, 57,
            21, 300, 300, 12, 72, 200, 200, 200);
    m1.fullMotion("Dave", 4, 4, 4, 4, 4, 4, 4, 4, 17,
            76, 30, 30, 23, 199, 67, 255);
    assertEquals("<svg width=\"500\" height\"500\" version=\"1.1\" xmlns=\"http:/" +
            "/www.w3.org/2000/svg\">\n" +
            "<rect id=\"Dave\" x=\"10.0\"  y=\"10.0\" width=\"10\" height=\"10\" fill=\"rg" +
            "b(255,255,255)\" visibility=\"visible\" >\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fil" +
            "l\" from=\"rgb(255,255,255)\" to=\"rgb(255,255,255)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"x\"" +
            " from=\"10.0\" to=\"4.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"y\" " +
            "from=\"10.0\" to=\"4.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"widt" +
            "h\" from=\"10\" to=\"4\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"heig" +
            "ht\" from=\"10\" to=\"4\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill" +
            "\" from=\"rgb(4,4,4)\" to=\"rgb(255,255,255)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"x\" f" +
            "rom=\"4.0\" to=\"76.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"y\" " +
            "from=\"4.0\" to=\"30.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"widt" +
            "h\" from=\"4\" to=\"30\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"heigh" +
            "t\" from=\"4\" to=\"23\" fill=\"freeze\" />\n" +
            "</rect>\n" +
            "<ellipse id=\"Rich II\" cx=\"20.0\"  cy=\"30.0\" rx=\"10\" ry=\"1\" fill=\"rgb(" +
            "3,30,57)\" visibility=\"visible\" >\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill\"" +
            " from=\"rgb(3,30,57)\" to=\"rgb(3,30,57)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cx\"" +
            " from=\"20.0\" to=\"300.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cy\"" +
            " from=\"30.0\" to=\"300.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"rx\"" +
            " from=\"10\" to=\"6\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"ry\"" +
            " from=\"1\" to=\"36\" fill=\"freeze\" />\n" +
            "</ellipse>\n" +
            "\n" +
            "</svg>\n", v1.formatSVG(m1));
  }

  @Test
  public void testPrintViewBasedOnWhenInstantiated() {
    m1.addShape("Dave", RECTANGLE);
    m1.addShape("Adam", ELLIPSE);
    m1.addShape("Daniel", RECTANGLE);
    m1.addShape("Vido", ELLIPSE);
    m1.fullMotion("Dave", 1, 10, 10, 10, 10, 255, 255, 255,
            5, 4, 4, 4, 4, 4, 4, 4);
    m1.fullMotion("Vido", 3, 200, 200, 1, 1, 0, 0, 0, 23,
            250, 250, 23, 34, 90, 36, 78);
    m1.fullMotion("Adam", 10, 20, 30, 20, 2, 3, 30, 57, 30,
            300, 300, 12, 72, 200, 200, 200);
    m1.fullMotion("Dave", 5, 4, 4, 4, 4, 4, 4, 4, 7,
            76, 30, 30, 23, 199, 67, 255);
    m1.fullMotion("Daniel", 5, 30, 30, 10, 10, 30, 78, 180,
            22, 100, 100, 100, 100, 0, 13, 255);
    assertEquals("<svg width=\"500\" height\"500\" version=\"1.1\" xmlns=\"http://ww" +
            "w.w3.org/2000/svg\">\n" +
            "<rect id=\"Dave\" x=\"10.0\"  y=\"10.0\" width=\"10\" height=\"10\" fill=\"rgb(2" +
            "55,255,255)\" visibility=\"visible\" >\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill\"" +
            " from=\"rgb(255,255,255)\" to=\"rgb(255,255,255)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"x\" fr" +
            "om=\"10.0\" to=\"4.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"y\" f" +
            "rom=\"10.0\" to=\"4.0\" fill=\"freeze\" />\n" +
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
            " from=\"4\" to=\"30\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"height" +
            "\" from=\"4\" to=\"23\" fill=\"freeze\" />\n" +
            "</rect>\n" +
            "<ellipse id=\"Adam\" cx=\"20.0\"  cy=\"30.0\" rx=\"10\" ry=\"1\" fill=\"rgb(3,30" +
            ",57)\" visibility=\"visible\" >\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill\" " +
            "from=\"rgb(3,30,57)\" to=\"rgb(3,30,57)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cx\" fr" +
            "om=\"20.0\" to=\"300.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cy\" f" +
            "rom=\"30.0\" to=\"300.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"rx\" f" +
            "rom=\"10\" to=\"6\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"ry\" f" +
            "rom=\"1\" to=\"36\" fill=\"freeze\" />\n" +
            "</ellipse>\n" +
            "<rect id=\"Daniel\" x=\"30.0\"  y=\"30.0\" width=\"10\" height=\"10\" fill=\"rgb(" +
            "30,78,180)\" visibility=\"visible\" >\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill\" " +
            "from=\"rgb(30,78,180)\" to=\"rgb(30,78,180)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"x\" fro" +
            "m=\"30.0\" to=\"100.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"y\" fro" +
            "m=\"30.0\" to=\"100.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"width\"" +
            " from=\"10\" to=\"100\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"height\"" +
            " from=\"10\" to=\"100\" fill=\"freeze\" />\n" +
            "</rect>\n" +
            "<ellipse id=\"Vido\" cx=\"200.0\"  cy=\"200.0\" rx=\"0\" ry=\"0\" fill=\"rgb(0,0,0)" +
            "\" visibility=\"visible\" >\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill\" f" +
            "rom=\"rgb(0,0,0)\" to=\"rgb(0,0,0)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cx\" fro" +
            "m=\"200.0\" to=\"250.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cy\" fro" +
            "m=\"200.0\" to=\"250.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"rx\" fro" +
            "m=\"0\" to=\"11\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"ry\" fro" +
            "m=\"0\" to=\"17\" fill=\"freeze\" />\n" +
            "</ellipse>\n" +
            "\n" +
            "</svg>\n", v1.formatSVG(m1));
  }

  @Test
  public void testPrintViewAlphabetically() {
    m1.addShape("Dave", RECTANGLE);
    m1.addShape("Adam", ELLIPSE);
    m1.addShape("Daniel", RECTANGLE);
    m1.addShape("Vido", ELLIPSE);
    m1.fullMotion("Dave", 3, 10, 10, 10, 10, 255, 255, 255,
            5, 4, 4, 4, 4, 4, 4, 4);
    m1.fullMotion("Vido", 3, 200, 200, 1, 1, 0, 0, 0, 23,
            250, 250, 23, 34, 90, 36, 78);
    m1.fullMotion("Adam", 3, 20, 30, 20, 2, 3, 30, 57, 30,
            300, 300, 12, 72, 200, 200, 200);
    m1.fullMotion("Dave", 5, 4, 4, 4, 4, 4, 4, 4, 7,
            76, 30, 30, 23, 199, 67, 255);
    m1.fullMotion("Daniel", 3, 30, 30, 10, 10, 30, 78, 180,
            22, 100, 100, 100, 100, 0, 13, 255);
    assertEquals("<svg width=\"500\" height\"500\" version=\"1.1\" xmlns=\"http://w" +
            "ww.w3.org/2000/svg\">\n" +
            "<rect id=\"Dave\" x=\"10.0\"  y=\"10.0\" width=\"10\" height=\"10\" fill=\"rgb" +
            "(255,255,255)\" visibility=\"visible\" >\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill\"" +
            " from=\"rgb(255,255,255)\" to=\"rgb(255,255,255)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"x\" f" +
            "rom=\"10.0\" to=\"4.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"y\" f" +
            "rom=\"10.0\" to=\"4.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"width\"" +
            " from=\"10\" to=\"4\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"height\"" +
            " from=\"10\" to=\"4\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill\" " +
            "from=\"rgb(4,4,4)\" to=\"rgb(255,255,255)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"x\" fro" +
            "m=\"4.0\" to=\"76.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"y\" fr" +
            "om=\"4.0\" to=\"30.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"width\"" +
            " from=\"4\" to=\"30\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"height" +
            "\" from=\"4\" to=\"23\" fill=\"freeze\" />\n" +
            "</rect>\n" +
            "<ellipse id=\"Adam\" cx=\"20.0\"  cy=\"30.0\" rx=\"10\" ry=\"1\" fill=\"rgb(3,30" +
            ",57)\" visibility=\"visible\" >\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill\"" +
            " from=\"rgb(3,30,57)\" to=\"rgb(3,30,57)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cx\" " +
            "from=\"20.0\" to=\"300.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cy\" " +
            "from=\"30.0\" to=\"300.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"rx\" " +
            "from=\"10\" to=\"6\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"ry\" " +
            "from=\"1\" to=\"36\" fill=\"freeze\" />\n" +
            "</ellipse>\n" +
            "<rect id=\"Daniel\" x=\"30.0\"  y=\"30.0\" width=\"10\" height=\"10\" fill=\"rgb" +
            "(30,78,180)\" visibility=\"visible\" >\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill\"" +
            " from=\"rgb(30,78,180)\" to=\"rgb(30,78,180)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"x\" fr" +
            "om=\"30.0\" to=\"100.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"y\" fr" +
            "om=\"30.0\" to=\"100.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"width\"" +
            " from=\"10\" to=\"100\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"height" +
            "\" from=\"10\" to=\"100\" fill=\"freeze\" />\n" +
            "</rect>\n" +
            "<ellipse id=\"Vido\" cx=\"200.0\"  cy=\"200.0\" rx=\"0\" ry=\"0\" fill=\"rgb(0,0," +
            "0)\" visibility=\"visible\" >\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"fill\" " +
            "from=\"rgb(0,0,0)\" to=\"rgb(0,0,0)\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cx\" fr" +
            "om=\"200.0\" to=\"250.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"cy\" f" +
            "rom=\"200.0\" to=\"250.0\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"rx\" f" +
            "rom=\"0\" to=\"11\" fill=\"freeze\" />\n" +
            "<animate attributesType=\"xml\" begin=\"0ms\" dur=\"0ms\" attributeName=\"ry\" f" +
            "rom=\"0\" to=\"17\" fill=\"freeze\" />\n" +
            "</ellipse>\n" +
            "\n" +
            "</svg>\n", v1.formatSVG(m1));
  }
}
