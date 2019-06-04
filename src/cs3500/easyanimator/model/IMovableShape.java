package cs3500.easyanimator.model;


public interface IMovableShape {
  
//  /**
//   * changes the color of this shape over a certain amount of time
//   * @param color the color it changes to
//   * @param duration the time it takes to change
//   */
//  void changeColor(Color color, int duration);
//
//  /**
//   * moves the shapes from its current position to the given position
//   * @param moveTo the position the shapes is moving to
//   * @param duration the time it takes for the shape to move
//   */
//  void move(Point2D moveTo, int duration);
//
//  /**
//   * changes the size of this shape over a specific duration
//   * @param duration the times it takes to change the shape's size
//   * @param newHeight the height it changes to
//   * @param newWidth the width it changes to
//   * @throws IllegalArgumentException
//   */
//  void changeSize(int duration, int newHeight, int newWidth) throws IllegalArgumentException;
//
  
    
  /**
   * retrieves the previous states of the shape
   * @return the history of the shape
   */
  String getMotions();

}
