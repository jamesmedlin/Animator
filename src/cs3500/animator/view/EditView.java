package cs3500.animator.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cs3500.animator.model.IAnimatedShape;
import cs3500.animator.model.IReadOnlyAnimatedShape;
import cs3500.animator.model.IReadOnlyShapeState;
import cs3500.animator.model.ShapeType;

/**
 * Represents a view in which you can edit the animation provided. This is implemented through
 * a variety of swing features.
 */
public class EditView extends VisualView implements ActionListener, ListSelectionListener {
  ArrayList<IReadOnlyAnimatedShape> shapesList;

  /**
   * Constructs the new window through which the user views and edits the animation. The animation
   * panel is render with the given width and height and it runs at the given number of ticks
   * per second.
   * 
   * @param speed the number of ticks per second at which the animation should run
   * @param width the width of the animation
   * @param height the height of the animation
   */
  public EditView(int speed, int width, int height) {
    super(speed, width, height);

    this.shapesList = new ArrayList<IReadOnlyAnimatedShape>();

    this.listeners = new ArrayList<IViewListener>();

    feedback = new JLabel("");
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

    this.shapesArray = new ArrayList<String>();

    shapes = new JPanel(new FlowLayout());
    shapes.add(addShape);
    shapes.add(removeShape);

    makeEastPanel();
    makeNorthPanel();
    makeWestPanel();
    setLayout(new BorderLayout());

    setSize(1000, 800);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocation(200, 200);

    pauseButton.addActionListener(this);
    speedButton.addActionListener(this);
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
    shapeList.addListSelectionListener(this);


    scrollPane = new JScrollPane(panel);

    feedbackPanel = new JPanel();
    feedbackPanel.add(feedback);
    northPanel = new JPanel();
    northPanel.setLayout((LayoutManager) new BoxLayout(northPanel, BoxLayout.Y_AXIS));
    northPanel.add(mainButtons);
    northPanel.add(feedbackPanel);

    add(eastPanel, BorderLayout.EAST);
    add(northPanel, BorderLayout.NORTH);
    add(feedbackPanel, BorderLayout.NORTH);
    add(westPanel, BorderLayout.WEST);
    add(scrollPane, BorderLayout.CENTER);

    setVisible(true);
  }

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

  private JPanel shapes;
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

  //private ArrayList<String> motionsArray;
  private ArrayList<String> shapesArray;


  private void makeWestPanel() {
    westPanel = new JPanel();
    westPanel.setLayout((LayoutManager) new BoxLayout(westPanel, BoxLayout.Y_AXIS));

    shapesPanel = new JPanel();
    shapesLabel = new JLabel("Shapes:");
    shapeList = new JList<Object>(this.shapesArray.toArray());
    shapeList.setPreferredSize(new Dimension(300, 500));
    shapeList.setFixedCellWidth(300);

    namePanel = new JPanel(new FlowLayout());
    nameLabel = new JLabel("Name");
    name = new JTextField(5);
    namePanel.add(nameLabel);
    namePanel.add(name);


    addShape = new JButton("add shape");
    addShape.setActionCommand("add shape button");

    removeShape = new JButton("remove shape");
    removeShape.setActionCommand("remove shape button");


    shapesPanel.add(shapesLabel);
    shapesPanel.add(shapeList);
    westPanel.add(shapesPanel);
    westPanel.add(namePanel);
    westPanel.add(addShape);
    westPanel.add(removeShape);
  }

  public void setShapesArray(ArrayList<IReadOnlyAnimatedShape> array) {
    this.shapesArray = new ArrayList<>();
    for (IReadOnlyAnimatedShape shape : array) {
      switch (shape.getType()) {
        case ELLIPSE:
          this.shapesArray.add("Ellipse " + shape.getName());
          break;
        case RECTANGLE:
          this.shapesArray.add("Rectangle " + shape.getName());
          break;
      }
    }
    DefaultListModel model = new DefaultListModel();
    for (String s : this.shapesArray) {
      model.addElement(s);
    }
    this.shapeList.setModel(model);
  }

  private void makeEastPanel() {
    widthLabel = new JLabel("Width");
    heightLabel = new JLabel("Height");
    xCoordinate = new JLabel("x");
    yCoordinate = new JLabel("y");
    redColor = new JLabel("red color");
    greenColor = new JLabel("green color");
    blueColor = new JLabel("blue color");
    tickLabel = new JLabel("tick");

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
    eastPanel.setLayout((LayoutManager) new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
    labelButtonPanel = new JPanel(new FlowLayout());
    labelButtonPanel.setPreferredSize(new Dimension(300, 150));
    motionsPanel = new JPanel();
    

    motionsLabel = new JLabel("Motions:");

    motionsList = new JList<Object>();
    motionsList.setPreferredSize(new Dimension(300, 500));
    motionsList.setFixedCellWidth(300);

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

  public void getMotionsList() {
      ArrayList<String> array = this.shapesList.get(shapeList.getSelectedIndex()).getStatesStringArray();
      DefaultListModel model = new DefaultListModel();

      for (String s : array) {
        model.addElement(s);
      }

      this.motionsList.setModel(model);
  }

  @Override
  public void addListener(IViewListener listener) {
    this.listeners.add(listener);
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
      case "add shape":
        addShapeAction();
        break;
      case "remove shape button":
        removeShapeAction();
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

  private void makeNorthPanel() {
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
    speedButton = new JButton("adjust speed");
    speedButton.setActionCommand("adjust");

    mainButtons = new JPanel();
    mainButtons.add(speedLabel);
    mainButtons.add(speedText);
    mainButtons.add(speedButton);
    mainButtons.add(playButton);
    mainButtons.add(pauseButton);
    mainButtons.add(restartButton);
    mainButtons.add(loopingButton);
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
    try {
      for (IViewListener listener : this.listeners) {
        listener.removeShape(((IReadOnlyAnimatedShape) shapeList.getSelectedValue()).getName());
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
    this.getMotionsList();
  }
}
