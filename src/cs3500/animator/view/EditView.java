package cs3500.animator.view;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import cs3500.animator.model.IReadOnlyModel;

public class EditView extends VisualView {
  public EditView(int speed, IReadOnlyModel model) {
    super(speed, model);
    pauseButton = new JButton("pause");
    pauseButton.setActionCommand("pause button");

    playButton = new JButton("play");
    playButton.setActionCommand("play button");

    restartButton = new JButton("restart");
    restartButton.setActionCommand("restart button");

    loopingButton = new JCheckBox("loop");
    loopingButton.setActionCommand("looping checkbox");

    rectangle = new JRadioButton("rectangle");
    rectangle.setActionCommand("rectangle button");

    ellipse = new JRadioButton("ellipse");
    ellipse.setActionCommand("ellipse button");

    buttonGroup = new ButtonGroup();
    buttonGroup.add(rectangle);
    buttonGroup.add(ellipse);

    addShape = new JButton("add shape");
    addShape.setActionCommand("add shape button");

    editFrame = new JButton("edit");
    editFrame.setActionCommand("edit button");

    addFrame = new JButton("add");
    addFrame.setActionCommand("add button");

    removeFrame = new JButton("remove");
    removeFrame.setActionCommand("remove button");

    exit = new JButton("exit");
    exit.setActionCommand("exit button");

    speedText = new JTextField("speed");
    speedText.setActionCommand("speed field");

    name = new JTextField("name");
    name.setActionCommand("name field");
  }

  JButton pauseButton;
  JButton playButton;
  JButton restartButton;
  JCheckBox loopingButton;
  JTextField speedText;
  
  JPanel shapes;
  JRadioButton rectangle;
  JRadioButton ellipse;
  ButtonGroup buttonGroup;
  JButton addShape;
  JTextField name;
  
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
    pauseButton.addActionListener(listener);
    playButton.addActionListener(listener);
    restartButton.addActionListener(listener);
    loopingButton.addActionListener(listener);
    addShape.addActionListener(listener);
    editFrame.addActionListener(listener);
    addFrame.addActionListener(listener);
    removeFrame.addActionListener(listener);
    exit.addActionListener(listener);
    rectangle.addActionListener(listener);
    ellipse.addActionListener(listener);
    name.addActionListener(listener);

  }
}
