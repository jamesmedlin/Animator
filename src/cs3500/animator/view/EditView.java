package cs3500.animator.view;

import java.awt.*;
import java.awt.event.ActionListener;

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

    makeEastPanel();
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
  JButton removeShape;
  JTextField name;
  
  JPanel keyFrames;
  JButton editFrame;
  JButton addFrame;
  JButton removeFrame;
  JButton exit;

  JPanel eastPanel;
  JLabel shapesLabel;
  JLabel motionsLabel;
  JList motionsList;
  JList shapeList;


  JPanel labelButtonPanel;
  JLabel widthLabel;
  JLabel heightLabel;
  JLabel xCoordinate;
  JLabel yCoordinate;
  JTextField tWidth;
  JTextField tHeight;
  JTextField tX;
  JTextField tY;


  public void makeEastPanel() {
    eastPanel = new JPanel();
    eastPanel.setLayout( new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
    shapesLabel = new JLabel("Shapes:");
    motionsLabel = new JLabel("Motions:");

    motionsList = new JList<String>( new String[]{"Motion1", "Motion2", "Motion3"});
    motionsList.setPreferredSize(new Dimension(300, 500));
    motionsList.setFixedCellWidth(300);

    shapeList = new JList<String>( new String[]{"Shape1", "Shape2", "Shape3"});
    shapeList.setPreferredSize(new Dimension(300, 500));
    shapeList.setFixedCellWidth(300);
    eastPanel.add(shapesLabel);
    eastPanel.add(shapeList);

    eastPanel.add(motionsLabel);
    eastPanel.add(motionsList);

  }

  public void makeSouthPanel() {
    widthLabel = new JLabel("Width");
    heightLabel = new JLabel("Height");
    xCoordinate = new JLabel("x");
    yCoordinate = new JLabel("y");

    tWidth = new JTextField(5);
    tHeight = new JTextField(5);
    tX = new JTextField(5);
    tY = new JTextField(5);

    labelButtonPanel = new JPanel(new FlowLayout());
    labelButtonPanel.add(widthLabel);
    labelButtonPanel.add(tWidth);
    labelButtonPanel.add(heightLabel);
    labelButtonPanel.add(tHeight);
    labelButtonPanel.add(xCoordinate);
    labelButtonPanel.add(tX);
    labelButtonPanel.add(yCoordinate);
    labelButtonPanel.add(tY);
  }
  

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
