package cs3500.animator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import cs3500.animator.model.IReadOnlyAnimatedShape;
import cs3500.animator.model.ShapeType;

public class EditView extends VisualView implements ActionListener, ListSelectionListener {

  private ArrayList<String> shapeStrings;

  private JPanel northPanel;
  private JLabel feedback;
  private JPanel mainButtons;
  private JScrollPane scrollPane;
  private JButton pauseButton;
  private JButton playButton;
  private JButton restartButton;
  private JCheckBox loopingButton;
  private JLabel speedLabel;
  private JTextField speedText;
  private JButton speedButton;
  private JPanel feedbackPanel;

  private JPanel editShapesPanel;
  private JRadioButton rectangle;
  private JRadioButton ellipse;
  private ButtonGroup buttonGroup;
  private JButton addShape;
  private JButton removeShape;
  private JTextField name;
  private JPanel namePanel;

  private JPanel submitPanel;
  private JButton editFrame;
  private JButton addFrame;
  private JButton removeFrame;

  private JPanel westPanel;
  private JLabel shapesLabel;
  private JLabel motionsLabel;
  private JList motionsList;
  private JPanel motionsPanel;
  private JList shapeList;
  private JPanel shapesPanel;
  private JPanel editShapesButtonPanel;
  private JPanel radioPanel;

  private JPanel eastPanel;
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
  private JTextField tWidth;
  private JTextField tHeight;
  private JTextField tX;
  private JTextField tY;
  private JTextField tRed;
  private JTextField tGreen;
  private JTextField tBlue;
  private JTextField tTick;
  private JPanel widthPanel;
  private JPanel heightPanel;
  private JPanel xCoordinatePanel;
  private JPanel yCoordinatePanel;
  private JPanel redColorPanel;
  private JPanel greenColorPanel;
  private JPanel blueColorPanel;



  public EditView(int speed, int width, int height) {
    super(speed, width, height);

    this.shapeStrings = new ArrayList<String>();

    makeNorthPanel();
    this.add(this.northPanel, BorderLayout.NORTH);

    makeWestPanel();
    this.add(this.westPanel, BorderLayout.WEST);

    makeEastPanel();
    this.add(this.eastPanel, BorderLayout.EAST);
    
    pack();
  }

  private void makeNorthPanel() {
    pauseButton = new JButton("pause");
    pauseButton.setActionCommand("pause button");
    pauseButton.addActionListener(this);

    playButton = new JButton("play");
    playButton.setActionCommand("play button");
    playButton.addActionListener(this);

    restartButton = new JButton("restart");
    restartButton.setActionCommand("restart button");
    restartButton.addActionListener(this);

    loopingButton = new JCheckBox("loop");
    loopingButton.setActionCommand("looping checkbox");
    loopingButton.addActionListener(this);

    speedLabel = new JLabel("speed");
    speedText = new JTextField(3);
    speedText.setActionCommand("speed field");
    speedButton = new JButton("adjust speed");
    speedButton.setActionCommand("adjust");
    speedButton.addActionListener(this);

    feedback = new JLabel("");
    feedbackPanel = new JPanel();
    feedbackPanel.setLayout(new FlowLayout());
    feedbackPanel.add(feedback);

    mainButtons = new JPanel();
    mainButtons.setLayout(new FlowLayout());
    mainButtons.add(speedLabel);
    mainButtons.add(speedText);
    mainButtons.add(speedButton);
    mainButtons.add(playButton);
    mainButtons.add(pauseButton);
    mainButtons.add(restartButton);
    mainButtons.add(loopingButton);

    this.northPanel = new JPanel();
    this.northPanel.setLayout(new BoxLayout(this.northPanel, BoxLayout.Y_AXIS));

    this.northPanel.add(this.mainButtons);
    this.northPanel.add(this.feedbackPanel);
  }

  private void makeWestPanel() {
    westPanel = new JPanel();
    westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));

    shapesPanel = new JPanel();

    shapesLabel = new JLabel("Shapes:");
    shapesPanel.add(shapesLabel);

    shapeList = new JList<String>();
    shapeList.addListSelectionListener(this);
    shapeList.setPreferredSize(new Dimension(300, 500));
    shapeList.setFixedCellWidth(300);
    shapesPanel.add(shapeList);


    addShape = new JButton("add shape");
    addShape.setActionCommand("add shape button");
    addShape.addActionListener(this);

    removeShape = new JButton("remove shape");
    removeShape.setActionCommand("remove shape button");
    removeShape.addActionListener(this);

    editShapesButtonPanel = new JPanel();
    editShapesButtonPanel.setLayout(new FlowLayout());
    editShapesButtonPanel.add(addShape);
    editShapesButtonPanel.add(removeShape);

    rectangle = new JRadioButton("rectangle");
    rectangle.setActionCommand("rectangle button");

    ellipse = new JRadioButton("ellipse");
    ellipse.setActionCommand("ellipse button");

    buttonGroup = new ButtonGroup();
    buttonGroup.add(rectangle);
    buttonGroup.add(ellipse);

    radioPanel = new JPanel();
    radioPanel.add(rectangle);
    radioPanel.add(ellipse);

    namePanel = new JPanel(new FlowLayout());
    nameLabel = new JLabel("Name");
    name = new JTextField(5);
    namePanel.add(nameLabel);
    namePanel.add(name);

    editShapesPanel = new JPanel();
    editShapesPanel.setLayout(new BoxLayout(editShapesPanel, BoxLayout.Y_AXIS));

    editShapesPanel.add(namePanel);
    editShapesPanel.add(radioPanel);
    editShapesPanel.add(editShapesButtonPanel);

    westPanel.add(shapesPanel);
    westPanel.add(editShapesPanel);
  }

  private void makeEastPanel() {
    widthLabel = new JLabel("Width");
    heightLabel = new JLabel("Height");
    xCoordinate = new JLabel("X");
    yCoordinate = new JLabel("Y");
    redColor = new JLabel("Red");
    greenColor = new JLabel("Green");
    blueColor = new JLabel("Blue");
    tickLabel = new JLabel("Tick");

    tWidth = new JTextField(5);
    tHeight = new JTextField(5);
    tX = new JTextField(5);
    tY = new JTextField(5);
    tRed = new JTextField(5);
    tGreen = new JTextField(5);
    tBlue = new JTextField(5);
    tTick = new JTextField(5);

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

    eastPanel = new JPanel();
    eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
    labelButtonPanel = new JPanel(new FlowLayout());
    labelButtonPanel.setPreferredSize(new Dimension(300, 150));
    motionsPanel = new JPanel();

    motionsLabel = new JLabel("Motions:\n(t, x, y, w, h, r, g, b)");

    motionsList = new JList<String>();
    motionsList.setPreferredSize(new Dimension(300, 500));
    motionsList.setFixedCellWidth(300);

    editFrame = new JButton("Edit");
    editFrame.setActionCommand("edit keyframe button");
    editFrame.addActionListener(this);

    addFrame = new JButton("Add");
    addFrame.setActionCommand("add keyframe button");
    addFrame.addActionListener(this);

    removeFrame = new JButton("Remove");
    removeFrame.setActionCommand("remove keyframe button");
    removeFrame.addActionListener(this);

    submitPanel = new JPanel(new FlowLayout());
    submitPanel.add(addFrame);
    submitPanel.add(editFrame);
    submitPanel.add(removeFrame);

    motionsPanel.add(motionsLabel);
    motionsPanel.add(motionsList);
    eastPanel.add(motionsPanel);
    labelButtonPanel.add(editFrame);
    labelButtonPanel.add(tickLabel);
    labelButtonPanel.add(tTick);
    labelButtonPanel.add(widthPanel);
    labelButtonPanel.add(heightPanel);
    labelButtonPanel.add(xCoordinatePanel);
    labelButtonPanel.add(yCoordinatePanel);
    labelButtonPanel.add(redColorPanel);
    labelButtonPanel.add(greenColorPanel);
    labelButtonPanel.add(blueColorPanel);
    labelButtonPanel.add(submitPanel);
    eastPanel.add(labelButtonPanel);
  }

  public void setShapesArray(ArrayList<IReadOnlyAnimatedShape> array) {
    this.shapeStrings.clear();
    for (IReadOnlyAnimatedShape shape : array) {
      switch (shape.getType()) {
        case ELLIPSE:
          this.shapeStrings.add("Ellipse " + shape.getName());
          break;
        case RECTANGLE:
          this.shapeStrings.add("Rectangle " + shape.getName());
          break;
      }
      DefaultListModel model = new DefaultListModel();
      for (String s : this.shapeStrings) {
        model.addElement(s);
      }
      this.shapeList.setModel(model);
    }
  }

  public void getMotionsList(IReadOnlyAnimatedShape shape) {
    ArrayList<String> array =
        shape.getStatesStringArray();
    DefaultListModel model = new DefaultListModel();

    for (String s : array) {
      model.addElement(s);
    }
    this.motionsList.setModel(model);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "pause button":
        try {
          for (IViewListener listener : this.listeners) {
            listener.pause();
          }
          feedback.setText("");
        } catch (Exception r) {
          feedback.setText("");
        }
        break;
      case "play button":
        try {
          for (IViewListener listener : this.listeners) {
            listener.play();
          }
          feedback.setText("");
        } catch (Exception r) {
          feedback.setText("");
        }
        break;
      case "restart button":
        for (IViewListener listener : this.listeners) {
          listener.restart();
        }
        feedback.setText("");
        break;
      case "adjust":
        adjustSpeedAction();
        break;
      case "edit button":
        editAction();
        break;
      case "add keyframe button":
        addKeyFrameAction();
        break;
      case "remove keyframe button":
        removeKeyFrameAction();
        break;
      case "add shape button":
        addShapeAction();
        break;
      case "remove shape button":
        removeShapeAction();
        break;
      case "edit keyframe button":
        editKeyFrameAction();
        break;
      case "looping checkbox":
        for (IViewListener listener : this.listeners) {
          listener.loop(this.loopingButton.isSelected());
        }
        break;
      default:
        throw new UnsupportedOperationException("Action command not supported: "
            + e.getActionCommand());
    }
  }

  private void adjustSpeedAction() {
    try {
      for (IViewListener listener : this.listeners) {
        listener.updateSpeed(Integer.valueOf(speedText.getText()));
      }
      feedback.setText("");
    } catch (Exception r) {
      feedback.setText("Must be a positive value.");
    }
  }

  private void editAction() {
    try {
      for (IViewListener listener : this.listeners) {
        listener.editKeyFrame(
            ((IReadOnlyAnimatedShape) this.shapeList.getSelectedValue()).getName(),
            this.shapeList.getSelectedIndex(),
            Integer.valueOf(this.tTick.getText()),
            Double.valueOf(this.tX.getText()),
            Double.valueOf(this.tY.getText()),
            Integer.valueOf(this.tWidth.getText()),
            Integer.valueOf(this.tHeight.getText()),
            Integer.valueOf(this.tRed.getText()),
            Integer.valueOf(this.tGreen.getText()),
            Integer.valueOf(this.tBlue.getText()));
      }
      feedback.setText("");
    } catch (Exception r) {
      feedback.setText("All fields must be valid and filled to edit a movement.");
    }
  }

  private void addKeyFrameAction() {
    try {
      for (IViewListener listener : this.listeners) {
        listener.addKeyFrame(((IReadOnlyAnimatedShape) shapeList.getSelectedValue()).getName(),
            Integer.valueOf(tTick.getText()), Double.valueOf(tX.getText()),
            Double.valueOf(tY.getText()), Integer.valueOf(tWidth.getText()),
            Integer.valueOf(tHeight.getText()), Integer.valueOf(tRed.getText()),
            Integer.valueOf(tGreen.getText()), Integer.valueOf(tBlue.getText()));
      }
      feedback.setText("");
    } catch (Exception r) {
      feedback.setText("All fields must be valid and filled to add a movement.");
    }
  }
  
  private void editKeyFrameAction() {
    try {
      for (IViewListener listener : this.listeners) {
        listener.editKeyFrame(((IReadOnlyAnimatedShape) shapeList.getSelectedValue()).getName(),
            motionsList.getSelectedIndex(), Integer.valueOf(tTick.getText()),
            Integer.valueOf(tX.getText()), Integer.valueOf(tY.getText()),
            Integer.valueOf(tWidth.getText()), Integer.valueOf(tHeight.getText()),
            Integer.valueOf(tRed.getText()), Integer.valueOf(tGreen.getText()),
            Integer.valueOf(tBlue.getText()));
      }
      feedback.setText("");
    } catch (Exception e) {
      feedback.setText("Ensure a certain shape and its movement are selected. And ensure all frame"
          + "fields are filled out.");
    }
  }

  private void removeKeyFrameAction() {
    try {
      for (IViewListener listener : this.listeners) {
        listener.removeKeyFrame(((IReadOnlyAnimatedShape) shapeList.getSelectedValue()).getName(),
            motionsList.getSelectedIndex());
      }
      feedback.setText("");
    } catch (Exception r) {
      feedback.setText("Ensure a certain shape and its movement are selected.");
    }
  }

  private void removeShapeAction() {
    Scanner string = new Scanner((String)shapeList.getSelectedValue());
    string.next();
    String temp = string.next();
    try {
      for (IViewListener listener : this.listeners) {
        listener.removeShape(temp);
      }
      feedback.setText("");
    } catch (Exception r) {
      feedback.setText("Ensure a certain shape and its movement are selected.");
    }
  }

  private void addShapeAction() {
    try {
      for (IViewListener listener : this.listeners) {
        if (rectangle.isSelected()) {
          listener.addShape(name.getText(), ShapeType.RECTANGLE);
        }
        if (ellipse.isSelected()) {
          listener.addShape(name.getText(), ShapeType.ELLIPSE);
        }
        feedback.setText("");
        if (!rectangle.isSelected() && !ellipse.isSelected()) {
          feedback.setText("Ensure a certain shape type is selected.");
        }
      }
    } catch (Exception r) {
      feedback.setText("Ensure the name entered in a valid and unique name.");
    }
  }

  @Override
  public void valueChanged(ListSelectionEvent e) {
    Scanner string = new Scanner((String)shapeList.getSelectedValue());
    string.next();
    String temp = string.next();
    for (IViewListener listener : this.listeners) {
      this.getMotionsList(listener.getShape(temp));
    }
  }

}
