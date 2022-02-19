package csc22100.turtlelogo;

import static csc22100.turtlelogo.Direction.*;

public class Turtle {

    private boolean penIsDown; // is pen is down, we draw when we move
    private Direction direction; // which way we face;
    private Canvas canvas;
    private int currentX;
    private int currentY;

    public Turtle(Canvas canvas) {
        this.penIsDown = true;
        this.canvas = canvas;
    }

    public void forward(int n) {

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
}
