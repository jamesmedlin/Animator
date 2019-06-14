package cs3500.animator.view;
import java.util.List;
import cs3500.animator.model.IReadOnlyShapeState;

public interface IDrawingPanel {
  void draw(List<IReadOnlyShapeState> shapes);
}
