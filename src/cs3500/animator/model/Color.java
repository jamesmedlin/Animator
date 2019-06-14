package cs3500.animator.model;


/**
 * represents color with different values of red, green, and blue.
 */
public class Color {
  // INVARIANT: red is an integer between 0 and 255 inclusive
  private final int red;
  // INVARIANT: red is an integer between 0 and 255 inclusive
  private final int green;
  // INVARIANT: red is an integer between 0 and 255 inclusive
  private final int blue;

  /**
   * constructs an instance of color for shapes.
   *
   * @param red   the value of red in the color
   * @param green the value of green in the color
   * @param blue  in the color
   */
  public Color(int red, int green, int blue) {
    if (red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || blue < 0) {
      throw new IllegalArgumentException("Color values must be between 0 and 255");
    } else {
      this.red = red;
      this.green = green;
      this.blue = blue;
    }
  }

  public int getRed() {
    return this.red;
  }

  public int getGreen() {
    return this.green;
  }

  public int getBlue() {
    return this.blue;
  }

  public float[] getHSB() {
    return java.awt.Color.RGBtoHSB(this.red, this.green, this.blue, new float[3]);
  }

}
