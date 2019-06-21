package cs3500.animator.view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import cs3500.animator.model.IReadOnlyModel;
import cs3500.animator.model.IReadOnlyShapeState;


public class TestView implements IView {
  
  List<IViewListener> listeners;
  Readable readable;
  
  public TestView(Readable readable){
    listeners = new ArrayList<IViewListener>();
    this.readable = readable;
  }

  @Override
  public void addListner(IViewListener listener) {
    listeners.add(listener);
  }

  @Override
  public String printView(IReadOnlyModel model) {
    throw new UnsupportedOperationException("Test view tests visuals only");
  }

  @Override
  public void drawShapes(List<IReadOnlyShapeState> shapes) {
    Scanner scanner = new Scanner(readable);
    try {
      String command = scanner.next();

      for (IViewListener listener : listeners) {
        switch (command) {
          case "Play":
            listener.play();
            break;
          case "Pause":
            listener.pause();
            break;
          case "Restart":
            listener.restart();
            break;
          case "Speed":
            listener.updateSpeed(50);
            break;
          case "AddShape":
            listener.addShape("Test Success", "rectangle");
            break;
          case "RemoveShape":
            listener.removeShape("Test Success");
            break;
          case "AddKeyframe":
            listener.addKeyFrame("Test Success", 25, 0, 0, 0, 0, 0, 0, 0);
            break;
          case "EditKeyframe":
            listener.editKeyFrame("Test Success", 0, 0, 0, 0, 0, 0, 0, 0, 0);
            break;
          case "RemoveKeyframe":
            listener.removeKeyFrame("Test Success", 0);
            break;
          case "Loop":
            listener.loop(true);
            break;
          default:
            throw new IllegalArgumentException(command + " not a supported test command");
        }
      }
    } catch (Exception e) {
      
    } 
  }
}
