package cs3500.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cs3500.animator.model.IModel;
import cs3500.animator.view.IView;

public class AnimatorController implements IAnimatorController, ActionListener {
  IModel model;
  IView view;

  public AnimatorController(IModel model, IView view) {
    this.model = model;
    this.view = view;
    view.setListener(this);
//    view.display();
  }

  @Override
  public void actionPerformed(ActionEvent e) throws IllegalArgumentException {
    switch (e.getActionCommand()) {
      case "pause button":
        break;
      case "play button":
        break;
      case "restart button":
        break;
      case "looping checkbox":
        break;
      case "rectangle button":
        break;
      case "ellipse button":
        break;
      case "add shape button":
        break;
      case "edit button":
        break;
      case "add button":
        break;
      case "remove button":
        break;
      case "exit button":
        break;
      case "speed field":
        break;
      case "name field":
        break;
      default:
        throw new IllegalArgumentException("Must be a valid action/command");
    }
  }

}
