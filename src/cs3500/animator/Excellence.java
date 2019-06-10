package cs3500.animator;

import java.io.InputStreamReader;
import cs3500.animator.model.Model;
import cs3500.animator.util.AnimationReader;

public class Excellence {
  public static void main(String [] args) {
    AnimationReader.parseFile(new InputStreamReader(System.in), new Model.Builder());
  }

}
