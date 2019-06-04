package cs3500.easyanimator.model;

public class Color {
  private final int red;
  private final int green;
  private final int blue;
  
  public Color(int red, int green, int blue) {
    if (red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || blue < 0) {
      throw new IllegalArgumentException("Color values must be between 0 and 255");
    }
    else {
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
  
}
