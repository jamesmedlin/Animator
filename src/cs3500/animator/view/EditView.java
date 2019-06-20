package cs3500.animator.view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import cs3500.animator.model.IReadOnlyAnimatedShape;

public class EditView extends VisualView implements ActionListener {
  
  List<IViewListener> listeners;
  
  public EditView(int speed, int width, int height) {
    super(speed, width, height);
    
    this.listeners = new ArrayList<IViewListener>();

    rectangle = new JRadioButton("rectangle");
    rectangle.setActionCommand("rectangle button");

    ellipse = new JRadioButton("ellipse");
    ellipse.setActionCommand("ellipse button");

    buttonGroup = new ButtonGroup();
    buttonGroup.add(rectangle);
    buttonGroup.add(ellipse);

    addShape = new JButton("add shape");
    addShape.setActionCommand("add shape button");

    removeShape = new JButton("remove shape");
    removeShape.setActionCommand("remove shape button");

    editFrame = new JButton("edit");
    editFrame.setActionCommand("edit button");

    addFrame = new JButton("add");
    addFrame.setActionCommand("add keyframe button");

    removeFrame = new JButton("remove");
    removeFrame.setActionCommand("remove keyframe button");

    name = new JTextField("name");
    name.setActionCommand("name field");
    

    shapesArray = new ArrayList<IReadOnlyAnimatedShape>();
    motionsArray = new ArrayList<String>();

    shapes = new JPanel(new FlowLayout());
    shapes.add(addShape);
    shapes.add(removeShape);

    makeEastPanel();
    makeSouthPanel();
    makeWestPanel();
    setLayout(new BorderLayout());

    setSize(800,800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocation(200,200);
    
    pauseButton.addActionListener(this);
    playButton.addActionListener(this);
    restartButton.addActionListener(this);
    loopingButton.addActionListener(this);
    addShape.addActionListener(this);
    removeShape.addActionListener(this);
    editFrame.addActionListener(this);
    addFrame.addActionListener(this);
    removeFrame.addActionListener(this);
    rectangle.addActionListener(this);
    ellipse.addActionListener(this);
    name.addActionListener(this);

    
    scrollPane = new JScrollPane(panel);
    
    add(labelButtonPanel, BorderLayout.SOUTH);
    add(mainButtons, BorderLayout.NORTH);
    add(eastPanel, BorderLayout.EAST);
    add(scrollPane, BorderLayout.CENTER);

    setVisible(true);
  }

  private JPanel mainButtons;
  private JScrollPane scrollPane;
  private JButton pauseButton;
  private JButton playButton;
  private JButton restartButton;
  private JCheckBox loopingButton;
  private JLabel speedLabel;
  private JTextField speedText;

  private JPanel shapes;
  private JRadioButton rectangle;
  private JRadioButton ellipse;
  private ButtonGroup buttonGroup;
  private JButton addShape;
  private JButton removeShape;
  private JTextField name;

  private JPanel submitPanel;
  private JButton editFrame;
  private JButton addFrame;
  private JButton removeFrame;

  private JPanel eastPanel;
  private JLabel shapesLabel;
  private JLabel motionsLabel;
  private JList motionsList;
  private JList shapeList;

  private JPanel labelButtonPanel;
  private JLabel nameLabel;
  private JLabel widthLabel;
  private JLabel heightLabel;
  private JLabel xCoordinate;
  private JLabel yCoordinate;
  private JLabel redColor;
  private JLabel greenColor;
  private JLabel blueColor;
  private JLabel tickLabel;
  private JTextField tName;
  private JTextField tWidth;
  private JTextField tHeight;
  private JTextField tX;
  private JTextField tY;
  private JTextField tRed;
  private JTextField tGreen;
  private JTextField tBlue;
  private JTextField tTick;
  private JPanel namePanel;
  private JPanel widthPanel;
  private JPanel heightPanel;
  private JPanel xCoordinatePanel;
  private JPanel yCoordinatePanel;
  private JPanel redColorPanel;
  private JPanel greenColorPanel;
  private JPanel blueColorPanel;

  private ArrayList<String> motionsArray;
  private ArrayList<IReadOnlyAnimatedShape> shapesArray;


  public void makeEastPanel() {
    eastPanel = new JPanel();
    eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
    shapesLabel = new JLabel("Shapes:");
    motionsLabel = new JLabel("Motions:");

    motionsList = new JList<Object>(motionsArray.toArray());
    motionsList.setPreferredSize(new Dimension(300, 500));
    motionsList.setFixedCellWidth(300);

    shapeList = new JList<Object>(shapesArray.toArray());
    shapeList.setPreferredSize(new Dimension(300, 500));
    shapeList.setFixedCellWidth(300);
    eastPanel.add(shapesLabel);
    eastPanel.add(shapeList);

    eastPanel.add(motionsLabel);
    eastPanel.add(motionsList);
  }

  public void setMotionsArray(ArrayList<String> array) {
    this.motionsArray = array;
  }

  public void setShapesArray(ArrayList<IReadOnlyAnimatedShape> array) {
    this.shapesArray = array;
  }

  public void makeSouthPanel() {
    nameLabel = new JLabel("Name");
    widthLabel = new JLabel("Width");
    heightLabel = new JLabel("Height");
    xCoordinate = new JLabel("x");
    yCoordinate = new JLabel("y");
    redColor = new JLabel("red color");
    greenColor = new JLabel("green color");
    blueColor = new JLabel("blue color");
    tickLabel = new JLabel("tick");

    tName = new JTextField(5);
    tWidth = new JTextField(5);
    tHeight = new JTextField(5);
    tX = new JTextField(5);
    tY = new JTextField(5);
    tRed = new JTextField(5);
    tGreen = new JTextField(5);
    tBlue = new JTextField(5);
    tTick = new JTextField(5);

    namePanel = new JPanel();
    namePanel.add(nameLabel);
    namePanel.add(tName);

    widthPanel = new JPanel();
    widthPanel.add(widthLabel);
    widthPanel.add(tWidth);

    heightPanel = new JPanel();
    heightPanel.add(heightLabel);
    heightPanel.add(tHeight);

    xCoordinatePanel = new JPanel();
    xCoordinatePanel.add(xCoordinate);
    xCoordinatePanel.add(tX);

    yCoordinatePanel = new JPanel();
    yCoordinatePanel.add(yCoordinate);
    yCoordinatePanel.add(tY);

    redColorPanel = new JPanel();
    redColorPanel.add(redColor);
    redColorPanel.add(tRed);

    greenColorPanel = new JPanel();
    greenColorPanel.add(greenColor);
    greenColorPanel.add(tGreen);

    blueColorPanel = new JPanel();
    blueColorPanel.add(blueColor);
    blueColorPanel.add(tBlue);

    labelButtonPanel = new JPanel(new FlowLayout());
    labelButtonPanel.setPreferredSize(new Dimension(800, 150));

    addShape = new JButton("add shape");
    addShape.setActionCommand("add shape button");

    removeShape = new JButton("remove shape");
    removeShape.setActionCommand("remove shape button");

    submitPanel = new JPanel(new FlowLayout());
    submitPanel.add(addFrame);
    submitPanel.add(editFrame);
    submitPanel.add(removeFrame);

    labelButtonPanel.add(editFrame);
    labelButtonPanel.add(tickLabel);
    labelButtonPanel.add(tTick);
    labelButtonPanel.add(nameLabel);
    labelButtonPanel.add(namePanel);
    labelButtonPanel.add(widthPanel);
    labelButtonPanel.add(heightPanel);
    labelButtonPanel.add(xCoordinatePanel);
    labelButtonPanel.add(yCoordinatePanel);
    labelButtonPanel.add(redColorPanel);
    labelButtonPanel.add(greenColorPanel);
    labelButtonPanel.add(blueColorPanel);
    labelButtonPanel.add(submitPanel);
  }
  

  public void addListener(IViewListener listener) {
    this.listeners.add(listener);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "pause button":
        for (IViewListener listener : this.listeners) {
          listener.pause();
        }
        break;
      case "play button":
        for (IViewListener listener : this.listeners) {
          listener.play();
        }
        break;
      case "edit button":
        for (IViewListener listener : this.listeners) {
          listener.editKeyFrame(
              ((IReadOnlyAnimatedShape) this.shapeList.getSelectedValue()).getName(), this.shapeList.getSelectedIndex(),
              Integer.valueOf(this.tTick.getText()),
              Double.valueOf(this.tX.getText()),
              Double.valueOf(this.tY.getText()),
              Integer.valueOf(this.tWidth.getText()),
              Integer.valueOf(this.tHeight.getText()),
              Integer.valueOf(this.tRed.getText()),
              Integer.valueOf(this.tGreen.getText()),
              Integer.valueOf(this.tBlue.getText()));;
        }
        break;
      case "add keyframe button":
        break;
      case "remove keyframe button":
        break;
      case "remove shape button":
        break;
    }
  }

  public void makeWestPanel() {
    pauseButton = new JButton("pause");
    pauseButton.setActionCommand("pause button");

    playButton = new JButton("play");
    playButton.setActionCommand("play button");

    restartButton = new JButton("restart");
    restartButton.setActionCommand("restart button");

    loopingButton = new JCheckBox("loop");
    loopingButton.setActionCommand("looping checkbox");

    speedLabel = new JLabel("speed");
    speedText = new JTextField(3);
    speedText.setActionCommand("speed field");

    mainButtons = new JPanel();
    mainButtons.add(speedLabel);
    mainButtons.add(speedText);
    mainButtons.add(playButton);
    mainButtons.add(pauseButton);
    mainButtons.add(restartButton);
    mainButtons.add(loopingButton);

  }
}
