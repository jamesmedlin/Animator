package cs3500.animator.view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

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

    removeShape = new JButton("remove shape");
    removeShape.setActionCommand("remove shape button");

    editFrame = new JButton("edit");
    editFrame.setActionCommand("edit button");

    addFrame = new JButton("add");
    addFrame.setActionCommand("add keyframe button");

    removeFrame = new JButton("remove");
    removeFrame.setActionCommand("remove keyframe button");

//    exit = new JButton("exit");
//    exit.setActionCommand("exit button");

    speedText = new JTextField("speed");
    speedText.setActionCommand("speed field");

    name = new JTextField("name");
    name.setActionCommand("name field");
    
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

    shapesArray = new String[]{};
    motionsArray = new String[]{};

    shapes = new JPanel(new FlowLayout());
    shapes.add(addShape);
    shapes.add(removeShape);

    makeEastPanel();
    makeSouthPanel();

    setLayout(new BorderLayout());

    scrollPane = new JScrollPane(panel);
    scrollPane.add(pauseButton);
    scrollPane.add(playButton);
    scrollPane.add(restartButton);
    scrollPane.add(loopingButton);
    scrollPane.add(speedText);

    setSize(800,800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocation(200,200);


    add(scrollPane, BorderLayout.CENTER);
    add(labelButtonPanel, BorderLayout.SOUTH);
    add(eastPanel, BorderLayout.EAST);

    setVisible(true);
  }

  private JScrollPane scrollPane;
  private JButton pauseButton;
  private JButton playButton;
  private JButton restartButton;
  private JCheckBox loopingButton;
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

  private String[] motionsArray;
  private String[] shapesArray;


  public void makeEastPanel() {
    eastPanel = new JPanel();
    eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
    shapesLabel = new JLabel("Shapes:");
    motionsLabel = new JLabel("Motions:");

    motionsList = new JList<String>( motionsArray);
    motionsList.setPreferredSize(new Dimension(300, 500));
    motionsList.setFixedCellWidth(300);

    shapeList = new JList<String>( shapesArray);
    shapeList.setPreferredSize(new Dimension(300, 500));
    shapeList.setFixedCellWidth(300);
    eastPanel.add(shapesLabel);
    eastPanel.add(shapeList);

    eastPanel.add(motionsLabel);
    eastPanel.add(motionsList);
  }

  public void setMotionsArray(String[] array) {
    this.motionsArray = array;
  }

  public void setShapesArray(String[] array) {
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


    labelButtonPanel = new JPanel(new FlowLayout());
    labelButtonPanel.setPreferredSize(new Dimension(800,100));

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
    labelButtonPanel.add(tName);
    labelButtonPanel.add(widthLabel);
    labelButtonPanel.add(tWidth);
    labelButtonPanel.add(heightLabel);
    labelButtonPanel.add(tHeight);
    labelButtonPanel.add(xCoordinate);
    labelButtonPanel.add(tX);
    labelButtonPanel.add(yCoordinate);
    labelButtonPanel.add(tY);
    labelButtonPanel.add(redColor);
    labelButtonPanel.add(tRed);
    labelButtonPanel.add(greenColor);
    labelButtonPanel.add(tGreen);
    labelButtonPanel.add(blueColor);
    labelButtonPanel.add(tBlue);
    labelButtonPanel.add(submitPanel);

  }
  

  public void addListener(IViewListener listener) {
    this.listeners.add(listener);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "pause button":
        break;
      case "play button":
        break;
      case "edit button":
        break;
      case "add keyframe button":
        break;
      case "remove keyframe button":
        break;
      case "remove shape button":
        break;
      
    }
    
  }
}
