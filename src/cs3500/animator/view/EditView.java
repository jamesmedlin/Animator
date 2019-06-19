package cs3500.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import cs3500.animator.model.IReadOnlyModel;

public class EditView extends VisualView implements ActionListener {
  
  List<IViewListener> listeners;
  
  public EditView(int speed, int width, int height) {
    super(speed, width, height);
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
    
    pauseButton.addActionListener(this);
    playButton.addActionListener(this);
    restartButton.addActionListener(this);
    loopingButton.addActionListener(this);
    addShape.addActionListener(this);
    editFrame.addActionListener(this);
    addFrame.addActionListener(this);
    removeFrame.addActionListener(this);
    exit.addActionListener(this);
    rectangle.addActionListener(this);
    ellipse.addActionListener(this);
    name.addActionListener(this);
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


  public void addListener(IViewListener listener) {
    this.listeners.add(listener);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      
    }
    
  }
}
