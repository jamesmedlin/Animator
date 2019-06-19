package cs3500.animator.view;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
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
    addFrame.setActionCommand("add keyframe button");

    removeFrame = new JButton("remove");
    removeFrame.setActionCommand("remove keyframe button");

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
    eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
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
