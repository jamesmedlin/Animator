# Easy Animator
## Model
### Overview
Most original text from this README descibes our model from Assignment 5. All additions documenting changes will be added below the original text and will be clearly indicated.

### IModel/Model
The model interface is the user-facing interface and will be the one called by the controller or view when they are implemented. Our implementation has only one field: a hashmap that maps unique string names to specific `IAnimatedShape` objects. These shapes are added using the `addShapeAt(...)` method, which takes in a name and the attributes required to initalize the an animated shape. The other methods primarily perform actions on specified animated shapes. The model methods simply finds the correct animated shape based on the name and delegates the action to that object's methods.
CHANGES:
- Removal of  `addShapeAt(..)` function, as it did not align with the way shapes were declared by the given text files. Instead, the the method was changed to `addShape(...)` whose states were then set to null until a full motion was added.
- Added a `shapeCount` field that allowed shapes to be layered in the order they were declared in the input text file. This is especially important in the buildings animation as the buildings and windows must be layered over the background correctly.
- Added `width` and `height` fields to dictate the size of the window. We originally thought that could be handled by the view but with the way the given `AnimationBuilder` was implemented, it seemed better to include that in the model.
- Added addtional getters for better data customization. Also we implemented `deepCopy()` methods for all necessary datatypes to aviod bugs.
- Added `fullMotion(...)` method to accomodate how the inputs were passed from the given `AnimationBuilder` and `AnimationReader` interfaces. Previously, all our motions assumed that the starting state for the next motion was the ending state for the most recent one so no gaps or overlap were even possible.
- Added a `Builder` class that implemented the given `AnimationBuilder` interface.

### IAnimatedShape/AnimatedShape
The animated shape interface is comprised of objects that represent shapes at different states. Our implementation has three different fields: an enum representing the type of shape. A single shape state representing the initial state of the shape when it is intialized from the model, and a list of states that represent endpoints of motions added by the user. The length of the list will always be even as the start and end points of the motion are added at the same time. The motions are added using a pseudo-builder pattern that creates two shape states based on the specifications of the movement. The first shape state is defaulted to be identical to the ending shape state of the previous motion. This ensures that there will be no gaps int the motions of any shape and that the ending state of one motion always matches the starting state of the next one.
This builder pattern also allows for easy extension to create new types of motions as each of the attributes of the shape can be changed independently. The current motions that are supported are a "full motion" (changing all attributes), "move to" (changing just the position), "change color to", "change size to", and "do nothing" (which is required so no gaps appear in the ticks of the motions of the Animated Shape.
This interface also has a `getShapeAtTick` and `getMotions` function. These methods will return an IllegalArgumentException and an empty string repectively if they are called on an Animated shape that has simply been initalized and no motions have been added. This was a design decision we made becuase we feel that an animated shape is a representation of a shape over time, so simply initializing at a single tick does not have any motion to it.
CHANGES:
- Added `order` field so that they can be layered based on their order. We also exteded the `Comparable<T>` inteface for quick sorting based on order.
- Added addtional getters in the `IReadOnlyAnimatedShape` interface to avoid mutability.
- Added `fullMotion(...)` method, see description above.


### IReadOnlyShapeState/IShapeState
These interfaces is comprised of objects that represent shapes at a given tick in the model animation. This inteface was created to represent individual state of an animated shapes at given ticks. Therefore we made an abstract class to implement the interface that had tick, width, height, color, and position fields, as any shape state in the animation will need these properities. The only methods this inteface supports are getters (in both intefaces) and a `toString` and `deepCopy` methods that return new representations of the shapes. This is because we believe that these shape states should be immuatable once created.
The aforementioned abstract class is currently only extended by Rectangles and Ellipses, but new shapes can be added easily by adding new classes and adding the new type of shape to the `ShapeType` enum. The classes that extend the abstract shape state class are comprised only of their explicit constructors and versions of the `deepCopy` method.

### ShapeType Enum
Represents a list of supported types of shapes. In order to add a new supported shape. A user need only add to the enum and write a class exending the abstract shape state class. That class need only have explicit constructors and a override of the `deepCopy` method.

### Color
A simple class to represent the RGB values of a color in an organized way. The implementation is only used internally so users need not be familiar with the `Color` constructor. Instead they can simply pass integers into the `changeColor` methods in the model.
CHANGES:
- Added `getHSB()` method so RBG values could be substituted for HSB values if necesssary.

## View
### IView
Supports all methods for all views and throws `UnsupportedOperationException` if it is not applicable for each concrete implementation.

### VisualView
The VisualView class extends the JFrame class and has a `DrawingPanel`,  `Timer`, and integer field to keep track of the tick. In the view's constructor, the timer is defined to draw shapes (included JPanel method) every time increment specified by the user. The shapes to draw are returned from the `getShapesAtTick(int)` method. Then to start the timer, the `render()` method is called.

### SVGView
The `SVGView` class implements a command pattern for the type of SVG tag it must output. We felt this was a good design decision becuase tags vary based on the type of shape so constructing a tag for a certain kind of `ShapeType` enum is alagous to executing different commands on the view. Each different kind of tag is represented by its own class, with all common code going in an abstracted class. The reason for this was so new types of shapes could be easily added just by extending the abstract class.

### TextView
The `TextView` class is quite simplistic, it is essentially the same as the implementation from Assignment 5, but instead housed in its own class.

### DrawingPanel
The `DrawingPanel` class extends JPanel and is where all the graphics are acutally painted in the `VisuaView`. Its concrete implementation contains the `paintComponent()` method, which is given the shapes to draw and the graphics so it can paint.
