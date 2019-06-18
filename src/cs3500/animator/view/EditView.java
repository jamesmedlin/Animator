package cs3500.animator.view;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class EditView extends VisualView {

  JButton pauseButton;
  JButton playButton;
  JButton restartButton;
  JCheckBox loopingButton;
  
  JPanel shapes;
  JRadioButton rectangle;
  JRadioButton ellipse;
  JButton addShape;
  
  JPanel keyFrames;
  JButton editFrame;
  JButton addFrame;
  JButton removeFrame;
  JButton exit;

  public void editSpeed(int newTPS) {
    this.timer.setDelay(1000 / newTPS);
  }

  public void restart() {
    this.tick = 0;
  }

  public void pause() {
    this.timer.stop();
  }

  public void toggleLoop() {
  }

  public void setListener(ActionListener listener) {
  }
}
