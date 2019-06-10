package cs3500.animator.model;
import java.util.List;
public interface IReadOnlyModel {

  /**
   * retrieves the previous states of this shape.
   * @return the history of this shape
   */
  String printHistory();

  /**
   * retrieves all shapes at a certain tick.
   * @param tick the tick at which shapes are retrieves
   * @return the list of readable shapes at the given tick
   */
  List<IReadOnlyShapeState> getShapesAtTick(int tick);

  /**
   * helps for testing by allowing shapes to be retrieved.
   * @param name the unique identifier of a shape
   * @return the shape
   * @throws IllegalArgumentException when the name is not a current shape
   */
  public String getShape(String name) throws IllegalArgumentException;

  /**
   * returns the object version of an snimsted shape.
   * @param name the unique identifier of a shape
   * @return the animated shape with the given name
   * @throws IllegalArgumentException when the name is invalid
   */
  public IAnimatedShape getShapeObject(String name) throws IllegalArgumentException;
}
