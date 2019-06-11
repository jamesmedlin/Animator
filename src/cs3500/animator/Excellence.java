package cs3500.animator;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import cs3500.animator.model.Model;
import cs3500.animator.util.AnimationReader;

public class Excellence {
  public static void main(String [] args) {
    
    String argString = "";
    for (String s : args) {
      argString += s + " ";
    }
    
    Scanner argParser = new Scanner(new StringReader(argString));
    
    try {
      while (argParser.hasNext()) {
        String next = argParser.next();
        switch (next) {
          
        }
      }
    }
    catch (NoSuchElementException e) {
      System.err.println("Insufficient arguments to run program.");
      System.exit(1);
    }
    
  }

}
