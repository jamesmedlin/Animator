package cs3500.easyanimator.model;

/**
 * represents a model for this animation
 */
public interface IModel {

   void addShape(String name, Enum type, Posn StartLoc) throws IllegalArgumentException;
   void removeShape(String name) throws IllegalArgumentException;
   void changeShapeColor(String name, Color color, int duration) throws IllegalArgumentException;
   void moveShape(String name, Posn moveTo, int duration) throws IllegalArgumentException;
   void changeShapeSize(String name, int duration, int newHeight, int newWidth) throws IllegalArgumentException;
   String printHistory();

}
