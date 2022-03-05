package csc22100.turtlelogo;

import csc22100.turtlelogo.commands.Command;
import csc22100.turtlelogo.commands.ForwardCommand;
import csc22100.turtlelogo.commands.SingleWordCommand;

import static csc22100.turtlelogo.Direction.*;

public class Turtle {

    private boolean penIsDown; // is pen is down, we draw when we move
    private Direction direction; // which way we face;
    private final Canvas canvas;
    private int currentX;
    private int currentY;

    public Turtle(Canvas canvas) {
        this.penIsDown = true;
        this.canvas = canvas;
        currentX = 0;
        currentY = 0;
        direction = NORTH;
    }

    public void forward(int n) {
        switch (direction) {
            case NORTH:
                for (int i = 0; i < n; i ++) {
                    int newX = currentX - 1;
                    if (newX < 0) {
                        throw new IllegalStateException("Turtle cannot walk off the canvas");
                    }
                    currentX = newX;
                    ink();
                }
            case EAST:
                for (int i = 0; i < n; i++) {
                    int newY = currentY + 1;
                    validatePosition(currentX, newY);
                    currentY = newY;
                    ink();
                }
            case WEST:
                for (int i = 0; i < n; i++) {
                    int newY = currentY - 1;
                    validatePosition(currentX, newY);
                    currentY = newY;
                    ink();
                }
            case SOUTH:
                for (int i=0; i < n; i++) {
                    int newX = currentX + 1;
                    validatePosition(newX, currentY);
                    currentX = newX;
                    ink();
                }
        }
    }

    /**
     * if the pen is down, ink the canvas
     */
    private void ink() {
        if (penIsDown) {
            canvas.fill(currentX, currentY);
        }
    }

    // NOTE: This method is private because it's internal to Turtle
    private void validatePosition(int x, int y) {
        if (x < 0 || y < 0 || x >= canvas.getNumRows() || y >= canvas.getNumCols()){
            throw new IllegalStateException("Turtle cannot walk off the canvas");
        }
    }

    /**
     *
     */
    public void penUp() {
        penIsDown = false;
    }

    public void penDown() {
        penIsDown = true;
    }

    /**
     *of many if ... else if
     **/
    public void turnLeft() {
        switch (direction) {
            case EAST:
                direction = NORTH;
                break;
            case NORTH:
                direction = WEST;
                break;
            case WEST:
                direction = SOUTH;
                break;
            case SOUTH:
                direction = EAST;
                break;
                // default: <- don't need it for this case because we cover all values of the enum
        }
    }

    public void turnRight() {
        switch (direction) {
            case EAST:
                direction = SOUTH;
                break;
            case NORTH:
                direction = EAST;
                break;
            case WEST:
                direction = NORTH;
                break;
            case SOUTH:
                direction = WEST;
                break;
            // default: <- don't need it for this case because we cover all values of the enum
        }
    }

    // Option 1 - reflection
    // Downsides:
    // - we're exposing ourselves to runtime errors
    public void executeCommand(Command command) {
        // NEXT: How do we figure out what kind of command we received????
        // We know that Command is either a ForwardCommand or a SingleWordCommands
        if (command instanceof ForwardCommand) { // this happens at runtime
            // it's a forward command
            // forward(command.getDistance()); // this happens at compile time
            ForwardCommand fwdCommand = (ForwardCommand) command;
            forward(fwdCommand.getDistance());
        } else if (command instanceof SingleWordCommand) {
            SingleWordCommand swCommand = (SingleWordCommand) command;
            // do our switch statement
        } else {
            throw new RuntimeException(String.format("Unknown type of commnd: %s", command.getClass().getName()));
        }
    }

    // Option 2: Polymorphism/overload executeCommand
    public void executeCommand(ForwardCommand forwardCommand) {
        forward(forwardCommand.getDistance());
    }

    public void executeCommand(SingleWordCommand singleWordCommand) {
          // same switch as before
        switch (singleWordCommand) {
            case PEN_UP:
                penUp();
                break;
            case PEN_DOWN:
                penDown();
                break;
            case TURN_LEFT:
                turnLeft();
                break;
            case TURN_RIGHT:
                turnRight();
                break;
        }
    }
}
