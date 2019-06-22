package cs3500.animator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import cs3500.animator.model.IReadOnlyAnimatedShape;
import cs3500.animator.model.ShapeType;

public class EditView extends VisualView implements ActionListener, ListSelectionListener {

  private ArrayList<String> shapeStrings;
  private String selectedName;

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
  private JList<String> motionsList;
  private JPanel motionsPanel;
  private JList<String> shapeList;
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
  private JScrollPane scrollPaneShapes;
  private JScrollPane scrollPaneMotions;

  /**
   * constructs the editing window with its interface.
   * @param speed the speed at which the animation runs
   * @param width the width of the window
   * @param height the height of the window
   */
  public EditView(int speed, int width, int height) {
    super(speed, width, height);

    this.shapeStrings = new ArrayList<String>();

    scrollPane = new JScrollPane(panel);

    makeNorthPanel();
    this.add(this.northPanel, BorderLayout.NORTH);

    makeWestPanel();
    this.add(this.westPanel, BorderLayout.WEST);

    makeEastPanel();
    this.add(this.eastPanel, BorderLayout.EAST);

    pack();
    this.add(this.scrollPane, BorderLayout.CENTER);

    this.setMinimumSize(new Dimension(1600,700));
  }

  /**
   * builds the animation commands and all buttons and fields that are required for this to happen.
   * Contains the feedback label that leaves feedback based on incorrect operations.
   */
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

  /**
   * builds the shapes list and all buttons and fields that are required for this to happen.
   */
  private void makeWestPanel() {
    westPanel = new JPanel();
    westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));

    shapesPanel = new JPanel();

    shapesLabel = new JLabel("Shapes:");
    shapesPanel.add(shapesLabel);

    shapeList = new JList<String>();
    shapeList.addListSelectionListener(this);
    scrollPaneShapes = new JScrollPane(shapeList);
    shapeList.setFixedCellWidth(300);
    scrollPaneShapes.setPreferredSize(new Dimension(300, 400));
    shapesPanel.add(scrollPaneShapes);

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

  /**
   * builds the motions list and all buttons and fields that are required for this to happen.
   */
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
    scrollPaneMotions = new JScrollPane(motionsList);
    motionsList.setFixedCellWidth(300);
    scrollPaneMotions.setPreferredSize(new Dimension(300, 400));

    motionsPanel.add(motionsLabel);
    motionsPanel.add(scrollPaneMotions);


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

  /**
   * sets the current shapes in the animation.
   * @param array the list of shapes
   */
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
      DefaultListModel<String> model = new DefaultListModel<String>();
      for (String s : this.shapeStrings) {
        model.addElement(s);
      }
      Runnable updateList = new Runnable() {
        @Override
        public void run() {
          shapeList.setModel(model);          
        }
      };
      SwingUtilities.invokeLater(updateList);
    }
  }

  /**
   * retrieves the motions of the given shape.
   * @param shape the read only shape that is currently selected
   */
  private void getMotionsList(IReadOnlyAnimatedShape shape) {
    try {
      ArrayList<String> array =
          shape.getStatesStringArray();
      DefaultListModel<String> model = new DefaultListModel<String>();

      for (String s : array) {
        model.addElement(s);
      }
      this.motionsList.setModel(model);
    } catch (Exception e) {

    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    int index = this.shapeList.getSelectedIndex();
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
      case "add keyframe button":
        addKeyFrameAction();
        this.shapeList.setSelectedIndex(index);
        break;
      case "remove keyframe button":
        removeKeyFrameAction();
        this.shapeList.setSelectedIndex(index);
        break;
      case "add shape button":
        addShapeAction();
        break;
      case "remove shape button":
        removeShapeAction();
        break;
      case "edit keyframe button":
        editKeyFrameAction();
        this.shapeList.setSelectedIndex(index);
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

  /**
   * adjusts the specified speed.
   */
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

  /**
   * adds a keyFrame to the secified shape.
   */
  private void addKeyFrameAction() {
    try {
      //      Scanner string = new Scanner((String)shapeList.getSelectedValue());
      //      string.next();
      //      String temp = string.next();
      for (IViewListener listener : this.listeners) {
        listener.addKeyFrame(this.selectedName,
            Integer.valueOf(tTick.getText()), Double.valueOf(tX.getText()),
            Double.valueOf(tY.getText()), Integer.valueOf(tWidth.getText()),
            Integer.valueOf(tHeight.getText()), Integer.valueOf(tRed.getText()),
            Integer.valueOf(tGreen.getText()), Integer.valueOf(tBlue.getText()));
      }
      feedback.setText("");
    } catch (NumberFormatException r) {
      feedback.setText("All fields must be valid and filled to add a movement.");
    }
  }

  /**
   * edits the selected keyFrame in the selected shape.
   */
  private void editKeyFrameAction() {
    try {
      //      Scanner string = new Scanner((String)shapeList.getSelectedValue());
      //      string.next();
      //      String temp = string.next();
      //      Scanner frame = new Scanner(Integer.toString(motionsList.getSelectedIndex()));
      //      int temp2 = Integer.valueOf(frame.next());
      //      if (this.shapeList.getSelectedValue() != null) {
      //        Scanner string = new Scanner(((String) this.shapeList.getSelectedValue()));
      //        string.next();
      //        this.selectedName = string.next();
      //        string.close();
      //      }
      for (IViewListener listener : this.listeners) {
        listener.editKeyFrame(this.selectedName,
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

  /**
   * removes the selected keyFrame.
   */
  private void removeKeyFrameAction() {
    try {
      //      Scanner string = new Scanner((String)shapeList.getSelectedValue());
      //      string.next();
      //      String temp = string.next();
      //      if (this.shapeList.getSelectedValue() != null) {
      //        Scanner string = new Scanner(((String) this.shapeList.getSelectedValue()));
      //        string.next();
      //        this.selectedName = string.next();
      //        string.close();
      //      }
      for (IViewListener listener : this.listeners) {
        listener.removeKeyFrame(this.selectedName,
            motionsList.getSelectedIndex());
      }
      feedback.setText("");
    } catch (Exception r) {
      feedback.setText("Ensure a certain shape and its movement are selected.");
    }
  }

  /**
   * removes a shape specified in the scanner.
   */
  private void removeShapeAction() {
    try {
      //      Scanner string = new Scanner((String)shapeList.getSelectedValue());
      //      string.next();
      //      String temp = string.next();
      //      if (this.shapeList.getSelectedValue() != null) {
      //        Scanner string = new Scanner(((String) this.shapeList.getSelectedValue()));
      //        string.next();
      //        this.selectedName = string.next();
      //        string.close();
      //      }
      for (IViewListener listener : this.listeners) {
        listener.removeShape(this.selectedName);
      }
      feedback.setText("");
    } catch (Exception r) {
      feedback.setText("Ensure a certain shape and its movement are selected.");
    }
  }

  /**
   * adds a shape with the specified name and type.
   */
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

  /**
   * is called whenever the selection in a list changes.
   * @param e the list of event selections
   */
  @Override
  public void valueChanged(ListSelectionEvent e) {
    if (this.shapeList.getSelectedValue() == null) {
      System.out.println("YEEHAW PARTNER");
      return;
    }
    Scanner string = new Scanner(((String) this.shapeList.getSelectedValue()));
    string.next();
    this.selectedName = string.next();
    for (IViewListener listener : this.listeners) {
      this.getMotionsList(listener.getShape(this.selectedName));
    }
    string.close();
  }
}
