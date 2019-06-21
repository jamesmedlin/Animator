package cs3500.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import cs3500.animator.model.IModel;
import cs3500.animator.model.IReadOnlyShapeState;
import cs3500.animator.model.ShapeType;
import cs3500.animator.view.IView;

public class VisualController implements IAnimatorController {
  private IModel model;
  private IView view;
  private Timer timer;
  private int tick = 0;

  public VisualController(IModel model, IView view, int speed) {
    this.model = model;
    this.view = view;
    this.timer = new Timer(1000 / speed, new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        List<IReadOnlyShapeState> shapesToRender = model.getShapesAtTick(tick++);
        view.drawShapes(shapesToRender);
      }
    });
  }



  @Override
  public void pause() {
    this.timer.stop();
  }

  @Override
  public void play() {
    this.timer.start();
  }

  @Override
  public void restart() {
    this.tick = 0;
  }

  @Override
  public void updateSpeed(int newTPS) {
    this.timer.setDelay(1000 / newTPS);
  }

  @Override
  public void addShape(String id, ShapeType shapeType) {
    model.addShape(id, shapeType);
  }

  @Override
  public void removeShape(String id) {
    model.removeShape(id);
  }

  @Override
  public void loop(boolean value) {
    // TODO Auto-generated method stub

  }

  @Override
  public void addKeyFrame(
          String id, int tick, double x, double y, int width, int height, int r, int g, int b) {
    model.addKeyFrame(id, tick, x, y, width, height, r, g, b);

  }

  @Override
  public void removeKeyFrame(String id, int index) {
    model.removeKeyFrame(id, index);

  }

  @Override
  public void editKeyFrame(String id, int index, int tick, double x, double y,
                           int width, int height, int r, int g, int b) {
    model.editKeyFrame(id, index, tick, x, y, width, height, r, g, b);

  }

}
