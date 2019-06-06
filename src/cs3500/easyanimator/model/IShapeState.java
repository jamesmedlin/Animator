package cs3500.easyanimator.model;


public interface IShapeState extends IReadOnlyShapeState {

  /**
   * Sets the width of this shape state to the given value.
   * 
   * @param value the value to which the width will be set
   */
  void setWidth(int value);
  
  /**
   * Sets the height of this shape state to the given value.
   * 
   * @param value the value to which the height will be set
   */
  void setHeight(int value);
  
  /**
   * Sets the color of this shape state to the color represented by the given RGB color values.
   * @param red integer between 0 and 255 for the strength of red in the color
   * @param green integer between 0 and 255 for the strength of green in the color
   * @param blue integer between 0 and 255 for the strength of blue in the color
   */
  void setColor(int red, int green, int blue);
  
  /**
   * Sets the position of this shape state to a 2D point using the given x and y double values.
   * @param x the horizontal position of this shape state
   * @param y the vertical position of this shape state
   */
  void setPosition(double x, double y);
  
  /**
   * Overrides the java-provided toString method. This method returns all the methods fields/
   * attributes as strings.
   * @return tick, x position, y position, width, height, red, green, blue as string values.
   */
  String toString();

}
