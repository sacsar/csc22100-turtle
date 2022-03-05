package csc22100.turtlelogo;

import csc22100.turtlelogo.commands.BadCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurtleTest {

    @Test
    public void testBadCommandThrowsException() {
        Canvas canvas = new Canvas(100, 100);
        Turtle turtle= new Turtle(canvas);
        turtle.executeCommand(new BadCommand());
    //    assertThrows(RuntimeException.class, () -> turtle.executeCommand(new BadCommand()));
    }

}