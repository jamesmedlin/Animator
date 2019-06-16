package cs3500.animator.model;


/**
 * represents the animation's data structure, independent of user interface. Directly organizes the
 * data and logic of this animation.
 */
public interface IModel extends IReadOnlyModel {

  /**
   * instantiates a shape to the animation when called. <<<<<<< HEAD
   *
   * @param name a unique identifier
   * @param type the type of shape being instantiated
   * @throws IllegalArgumentException when given invalid initial values
   */
  void addShape(String name, ShapeType type) throws IllegalArgumentException;

  /**
   * removes a specific shape when called.
   *
   * @param name the unique identifier
   * @throws IllegalArgumentException when given an invalid name
   */
  void removeShape(String name) throws IllegalArgumentException;


  /**
   * changes the color of this shape over a certain amount of time.
   *
   * @param name     the unique identifier
   * @param red      the value of red color
   * @param green    the value of green color
   * @param blue     the value of blue color
   * @param duration the time it takes to perform this motion
   * @throws IllegalArgumentException when given invalid color values or names
   */
  void changeColorTo(String name, int red, int green, int blue, int duration)
          throws IllegalArgumentException;

  /**
   * moves the shapes from its current position to the given position.
   *
   * @param name     the unique shape identifier
   * @param x        the x coordinate it will move to
   * @param y        the y value it will move to
   * @param duration the time it takes to perform this motion
   */
  void moveTo(String name, double x, double y, int duration);

  /**
   * changes the size of this shape over a specific duration.
   *
   * @param name      the unique shape identifier
   * @param newHeight the new height of the shape
   * @param newWidth  the new width of the shape
   * @param duration  the time it takes to perform this motion
   * @throws IllegalArgumentException when given invalid lengths or names
   */
  void changeSizeTo(String name, int newHeight, int newWidth, int duration)
          throws IllegalArgumentException;


  /**
   * creates a new motion which allows instantaneous changes in states.
   *
   * @param name      the unique shape identifier
   * @param duration  the times over which this motion is performed
   * @param endX      the x value of the position it moves to
   * @param endY      the y value of the position it moves to
   * @param endHeight the final height of the shape
   * @param endWidth  the final width of the shape
   * @param endRed    the final end value of red color
   * @param endGreen  the final end value of green color
   * @param endBlue   the final end value of blue color
   */
  void fullMotionTo(String name, int duration, double endX, double endY, int endHeight,
                    int endWidth, int endRed, int endGreen, int endBlue);


  /**
   * keeps the shape in place, with no change in size or color.
   *
   * @param name     the unique identifier
   * @param duration the time over which this shape freezes
   * @throws IllegalArgumentException when the name is not valid or the duration is less than 1
   */
  void doNothing(String name, int duration) throws IllegalArgumentException;

  /**
   * Adds a full motion to the animation, allowing for customizable start AND ent times.
   *
   * @param name The name of the shape
   * @param t1   The start time of this transformation
   * @param x1   The initial x-position of the shape
   * @param y1   The initial y-position of the shape
   * @param w1   The initial width of the shape
   * @param h1   The initial height of the shape
   * @param r1   The initial red color-value of the shape
   * @param g1   The initial green color-value of the shape
   * @param b1   The initial blue color-value of the shape
   * @param t2   The end time of this transformation
   * @param x2   The final x-position of the shape
   * @param y2   The final y-position of the shape
   * @param w2   The final width of the shape
   * @param h2   The final height of the shape
   * @param r2   The final red color-value of the shape
   * @param g2   The final green color-value of the shape
   * @param b2   The final blue color-value of the shape
   */
  void fullMotion(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
                  int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2);

}
